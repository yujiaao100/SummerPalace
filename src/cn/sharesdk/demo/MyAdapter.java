/*
 * ������վ:http://www.ShareSDK.cn
 * ����֧��QQ: 4006852216
 * �ٷ�΢��:ShareSDK   ����������°汾�Ļ������ǽ����һʱ��ͨ��΢�Ž��汾�����������͸��������ʹ�ù��������κ����⣬Ҳ����ͨ��΢��������ȡ����ϵ�����ǽ�����24Сʱ�ڸ���ظ���
 *
 * Copyright (c) 2013�� ShareSDK.cn. All rights reserved.
 */

package cn.sharesdk.demo;

import java.util.HashMap;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import app.SummerPalace.R;
import cn.sharesdk.framework.authorize.AuthorizeAdapter;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;

/**
 * һ��������ʾ{@link AuthorizeAdapter}�����ӡ�
 * <p>
 * ��demo������Ȩҳ��ײ���ʾһ������ע�ٷ�΢��������ʾ��
 *�û���������Ȩ�ڼ�������ʾ���п��ƣ�ѡ���ע���߲���
 *ע������û����ȷ����ע��ƽ̨�ٷ�΢����������Ȩ������
 *��ִ�й�ע�ķ�����
 */
public class MyAdapter extends AuthorizeAdapter implements OnClickListener,
		PlatformActionListener {
	private CheckedTextView ctvFollow;
	private PlatformActionListener backListener;
	private boolean stopFinish;

	public void onCreate() {
		// ���ر������Ҳ���ShareSDK Logo
		//hideShareSDKLogo();

//		TitleLayout llTitle = getTitleLayout();
//		llTitle.getTvTitle().setText("xxxx");

		String platName = getPlatformName();
		if ("SinaWeibo".equals(platName)
				|| "TencentWeibo".equals(platName)) {
			initUi(platName);
			interceptPlatformActionListener(platName);
			return;
		}

		// ʹ��������ʧЧ��ֻ����onCreate�е��ã������޷�������
		if ("KaiXin".equals(platName)) {
			disablePopUpAnimation();
		}

		// ����Ĵ�����ʾ��������Զ������Ȩҳ��򿪶���
		if ("Douban".equals(platName)) {
			stopFinish = true;
			disablePopUpAnimation();
			View rv = (View) getBodyView().getParent();
			TranslateAnimation ta = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, -1,
					Animation.RELATIVE_TO_SELF, 0,
					Animation.RELATIVE_TO_SELF, 0,
					Animation.RELATIVE_TO_SELF, 0);
			ta.setDuration(500);
			rv.setAnimation(ta);
		}
	}

	private void initUi(String platName) {
		ctvFollow = new CheckedTextView(getActivity());
		try {
			ctvFollow.setBackgroundResource(R.drawable.auth_follow_bg);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		ctvFollow.setChecked(true);
		int dp_10 = cn.sharesdk.framework.utils.R.dipToPx(getActivity(), 10);
		ctvFollow.setCompoundDrawablePadding(dp_10);
		ctvFollow.setCompoundDrawablesWithIntrinsicBounds(R.drawable.auth_cb, 0, 0, 0);
		ctvFollow.setGravity(Gravity.CENTER_VERTICAL);
		ctvFollow.setPadding(dp_10, dp_10, dp_10, dp_10);
		ctvFollow.setText(R.string.sm_item_fl_weibo);
		if (platName.equals("TencentWeibo")) {
			ctvFollow.setText(R.string.sm_item_fl_tc);
		}
		ctvFollow.setTextColor(0xff909090);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		ctvFollow.setLayoutParams(lp);
		LinearLayout llBody = (LinearLayout) getBodyView().getChildAt(0);
		llBody.addView(ctvFollow);
		ctvFollow.setOnClickListener(this);

		ctvFollow.measure(0, 0);
		int height = ctvFollow.getMeasuredHeight();
		TranslateAnimation animShow = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 0,
				Animation.ABSOLUTE, height,
				Animation.ABSOLUTE, 0);
		animShow.setDuration(1000);
		getWebBody().startAnimation(animShow);
		ctvFollow.startAnimation(animShow);
	}

	private void interceptPlatformActionListener(String platName) {
		Platform plat = ShareSDK.getPlatform(getActivity(), platName);
		// ���ݴ�ǰ���õ��¼�������
		backListener = plat.getPlatformActionListener();
		// �����µļ�������ʵ���¼�����
		plat.setPlatformActionListener(this);
	}

	public void onError(Platform plat, int action, Throwable t) {
		if (action == Platform.ACTION_AUTHORIZING) {
			// ��Ȩʱ����������
			plat.setPlatformActionListener(backListener);
			if (backListener != null) {
				backListener.onError(plat, action, t);
			}
		}
		else {
			// ��עʱ��������
			plat.setPlatformActionListener(backListener);
			if (backListener != null) {
				backListener.onComplete(plat, Platform.ACTION_AUTHORIZING, null);
			}
		}
	}

	public void onComplete(Platform plat, int action,
			HashMap<String, Object> res) {
		if (action == Platform.ACTION_FOLLOWING_USER) {
			// ������Ȩ�Ժ����κ�����
			plat.setPlatformActionListener(backListener);
			if (backListener != null) {
				backListener.onComplete(plat, Platform.ACTION_AUTHORIZING, null);
			}
		}
		else if (ctvFollow.isChecked()) {
			// ��Ȩ�ɹ���ִ�й�ע
			String account = MainAdapter.SDK_SINAWEIBO_UID;
			if ("TencentWeibo".equals(plat.getName())) {
				account = MainAdapter.SDK_TENCENTWEIBO_UID;
			}
			plat.followFriend(account);
		}
		else {
			// ���û�б��Ϊ����Ȩ����ע����ֱ�ӷ���
			plat.setPlatformActionListener(backListener);
			if (backListener != null) {
				// ��ע�ɹ�Ҳֻ�ǵ�����Ȩ�ɹ�����
				backListener.onComplete(plat, Platform.ACTION_AUTHORIZING, null);
			}
		}
	}

	public void onCancel(Platform plat, int action) {
		plat.setPlatformActionListener(backListener);
		if (action == Platform.ACTION_AUTHORIZING) {
			// ��Ȩǰȡ��
			if (backListener != null) {
				backListener.onCancel(plat, action);
			}
		}
		else {
			// ������Ȩ�Ժ����κ�����
			if (backListener != null) {
				backListener.onComplete(plat, Platform.ACTION_AUTHORIZING, null);
			}

		}
	}

	public void onClick(View v) {
		CheckedTextView ctv = (CheckedTextView) v;
		ctv.setChecked(!ctv.isChecked());
	}

	public void onResize(int w, int h, int oldw, int oldh) {
		if (ctvFollow != null) {
			if (oldh - h > 100) {
				ctvFollow.setVisibility(View.GONE);
			}
			else {
				ctvFollow.setVisibility(View.VISIBLE);
			}
		}
	}

	public boolean onFinish() {
		// ����Ĵ�����ʾ��������Զ������Ȩҳ���˳�����
		if ("Douban".equals(getPlatformName())) {
			final View rv = (View) getBodyView().getParent();
			rv.clearAnimation();

			TranslateAnimation ta = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0,
					Animation.RELATIVE_TO_SELF, 1,
					Animation.RELATIVE_TO_SELF, 0,
					Animation.RELATIVE_TO_SELF, 0);
			ta.setDuration(500);
			ta.setAnimationListener(new AnimationListener() {
				public void onAnimationStart(Animation animation) {

				}

				public void onAnimationRepeat(Animation animation) {

				}

				public void onAnimationEnd(Animation animation) {
					stopFinish = false;
					getActivity().finish();
				}
			});
			rv.setAnimation(ta);
		}
		return stopFinish;
	}

}
