/*
 * ������վ:http://www.ShareSDK.cn
 * ����֧��QQ: 4006852216
 * �ٷ�΢��:ShareSDK   ����������°汾�Ļ������ǽ����һʱ��ͨ��΢�Ž��汾�����������͸��������ʹ�ù��������κ����⣬Ҳ����ͨ��΢��������ȡ����ϵ�����ǽ�����24Сʱ�ڸ���ظ���
 *
 * Copyright (c) 2013�� ShareSDK.cn. All rights reserved.
 */

package cn.sharesdk.demo;

import java.util.HashMap;
import m.framework.ui.widget.slidingmenu.SlidingMenu;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.UIHandler;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareCore;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import app.SummerPalace.R;

/**
 * ShareSDK ������ַ �� http://www.sharesdk.cn </br>
 *1��ShareSDK�ӿ���ʾҳ��</br>
 *������ʾʹ�ÿ�ݷ������ͼ�ķ���</br>
 *��ҳ��ֱ�ӷ�����Ȩ����ע�Ͳ�ͬƽ̨�ķ���ȵȹ��ܡ�</br>
 *
 *2�����Ҫ��ѯ�ͷ��������ҵQQ 4006852216 </br>
 *3����ѯ�ͷ�ʱ��������������������ø���������Ϣ��ͼ </br>
 *4��һ�����⣬�����ĵ��ж��У����ȿ��������ĵ������ٿͷ�ѹ������л����  ^_^
 *5�����ڿͷ�ѹ���޴�ÿ������������ô���죬�����
 */
public class DemoPage extends SlidingMenuPage implements
		OnClickListener, PlatformActionListener {
	private TitleLayout llTitle;

	public DemoPage(final SlidingMenu menu) {
		super(menu);
		View pageView = getPage();

		llTitle = (TitleLayout) pageView.findViewById(R.id.llTitle);
		llTitle.getBtnBack().setOnClickListener(this);
		llTitle.getTvTitle().setText(R.string.sm_item_demo);
		pageView.findViewById(R.id.btnShareAllGui).setOnClickListener(this);
		pageView.findViewById(R.id.btnShareAll).setOnClickListener(this);
		pageView.findViewById(R.id.btnFlSw).setOnClickListener(this);
		pageView.findViewById(R.id.btnFlTc).setOnClickListener(this);
		pageView.findViewById(R.id.btnGetToken).setOnClickListener(this);
		pageView.findViewById(R.id.btnVisitWc).setOnClickListener(this);
		pageView.findViewById(R.id.btnGetInfor).setOnClickListener(this);
		pageView.findViewById(R.id.btnGetUserInfor).setOnClickListener(this);

		new Thread() {
			public void run() {
				Platform[] list = ShareSDK.getPlatformList(menu.getContext());
				if (list != null) {
					Message msg = new Message();
					msg.obj = list;
					UIHandler.sendMessage(msg, new Callback() {
						public boolean handleMessage(Message msg) {
							afterPlatformsGot((Platform[]) msg.obj);
							return false;
						}
					});
				}
			}
		}.start();
	}

	private void afterPlatformsGot(Platform[] platforms) {
		View pageView = getPage();
		LinearLayout llList = (LinearLayout) pageView.findViewById(R.id.llList);
		LinearLayout line = (LinearLayout) View.inflate(menu.getContext(),
				R.layout.demo_page_item, null);
		llList.addView(line);
		int lineCount = 0;

		for (Platform platform : platforms) {
			String name = platform.getName();
			if (ShareCore.isUseClientToShare(platform.getContext(), name)) {
				continue;
			}

			if (platform instanceof CustomPlatform) {
				continue;
			}

			if (lineCount >= 2) {
				// ÿ��������ť
				line = (LinearLayout) View.inflate(menu.getContext(),
						R.layout.demo_page_item, null);
				llList.addView(line);
				lineCount = 0;
			}

			// ������߰�ť���ұ߰�ť
			int res = lineCount == 0 ? R.id.btnLeft : R.id.btnRight;
			Button btn = (Button) line.findViewById(res);
			btn.setSingleLine();
			int platNameRes = cn.sharesdk.framework.utils.R.getStringRes(
					menu.getContext(), name);
			if (platNameRes > 0) {
				String platName = menu.getContext().getString(platNameRes);
				String text = menu.getContext().getString(R.string.share_to_format, platName);
				btn.setText(text);
			}
			btn.setTag(platform);
			btn.setVisibility(View.VISIBLE);
			btn.setOnClickListener(this);
			lineCount++;
		}
	}

	protected View initPage() {
		return LayoutInflater.from(menu.getContext())
				.inflate(R.layout.page_demo, null);
	}

	// ʹ�ÿ�ݷ�����ɷ����������ϸ�Ķ�λ��SDK��ѹĿ¼��Docs�ļ�����OnekeyShare���JavaDoc��
	/**ShareSDK���ɷ���������</br>
	 * 1����һ�������÷�ʽ����������onekeyshare��Ŀ��onekeyshare��Ŀ������mainlibs��</br>
	 * 2���ڶ����ǰ�onekeyshare��mainlibs���ɵ���Ŀ�У������Ӿ����õڶ��ַ�ʽ</br>
	 * �뿴��ShareSDK ʹ��˵���ĵ�����SDK����Ŀ¼�� </br>
	 * ���߿����缯���ĵ� http://wiki.sharesdk.cn/Android_%E5%BF%AB%E9%80%9F%E9%9B%86%E6%88%90%E6%8C%87%E5%8D%97
	 * 3������ʱ����sample���߱����ӵĻ�������copy��ȥ����proguard-project.txt�ļ���
	 *
	 *
	 * ƽ̨������Ϣ�����ַ�ʽ��
	 * 1�������Ǻ�̨���ø���΢��ƽ̨��key
	 * 2���ڴ��������ø���΢��ƽ̨��key��http://sharesdk.cn/androidDoc/cn/sharesdk/framework/ShareSDK.html
	 * 3���������ļ������ã������������assets/ShareSDK.conf,
	 */
	private void showShare(boolean silent, String platform) {
		final OnekeyShare oks = new OnekeyShare();
		oks.setNotification(R.drawable.ic_launcher, menu.getContext().getString(R.string.app_name));
		oks.setAddress("12345678901");
		oks.setTitle(menu.getContext().getString(R.string.evenote_title));
		oks.setTitleUrl("http://sharesdk.cn");
		oks.setText(menu.getContext().getString(R.string.share_content));
		oks.setImagePath(MainActivity.TEST_IMAGE);
		oks.setImageUrl("http://sharesdk.cn/media/sharesdk.jpg");
		oks.setUrl("http://www.sharesdk.cn");
		oks.setFilePath(MainActivity.TEST_IMAGE);
		oks.setComment(menu.getContext().getString(R.string.share));
		oks.setSite(menu.getContext().getString(R.string.app_name));
		oks.setSiteUrl("http://sharesdk.cn");
		oks.setVenueName("ShareSDK");
		oks.setVenueDescription("This is a beautiful place!");
		oks.setLatitude(23.056081f);
		oks.setLongitude(113.385708f);
		oks.setSilent(silent);
		if (platform != null) {
			oks.setPlatform(platform);
		}

		// ȥ��ע�ͣ�����༭ҳ����ʾΪDialogģʽ
//		oks.setDialogMode();

		// ȥ��ע�ͣ����Զ���Ȩʱ���Խ���SSO��ʽ
//		oks.disableSSOWhenAuthorize();

		// ȥ��ע�ͣ����ݷ���Ĳ��������ͨ��OneKeyShareCallback�ص�
//		oks.setCallback(new OneKeyShareCallback());
		oks.setShareContentCustomizeCallback(new ShareContentCustomizeDemo());

		// ȥ��ע�ͣ���ʾ�ھŹ��������Զ����ͼ��
//		Bitmap logo = BitmapFactory.decodeResource(menu.getResources(), R.drawable.ic_launcher);
//		String label = menu.getResources().getString(R.string.app_name);
//		OnClickListener listener = new OnClickListener() {
//			public void onClick(View v) {
//				String text = "Customer Logo -- ShareSDK " + ShareSDK.getSDKVersionName();
//				Toast.makeText(menu.getContext(), text, Toast.LENGTH_SHORT).show();
//				oks.finish();
//			}
//		};
//		oks.setCustomerLogo(logo, label, listener);

		oks.show(menu.getContext());
	}

	public void onClick(View v) {
		if (v.equals(llTitle.getBtnBack())) {
			if (menu.isMenuShown()) {
				menu.hideMenu();
			}
			else {
				menu.showMenu();
			}
			return;
		}

		switch (v.getId()) {
			case R.id.btnShareAllGui: {
				// ͼ�ķ���
				showShare(false, null);
			}
			break;
			case R.id.btnShareAll: {
				// ֱ�ӷ���
				showShare(true, null);
			}
			break;
			case R.id.btnFlSw: {
				// ��ע����΢��
				Platform plat = ShareSDK.getPlatform(menu.getContext(), "SinaWeibo");
				plat.setPlatformActionListener(this);
				plat.followFriend(MainAdapter.SDK_SINAWEIBO_UID);
			}
			break;
			case R.id.btnFlTc: {
				// ��ע��Ѷ΢��
				Platform plat = ShareSDK.getPlatform(menu.getContext(), "TencentWeibo");
				plat.setPlatformActionListener(this);
				plat.followFriend(MainAdapter.SDK_TENCENTWEIBO_UID);
			}
			break;
			case R.id.btnGetToken: {
				// ��ȡtoken
				GetTokenPage page = new GetTokenPage();
				page.show(menu.getContext(), null);
			}
			break;
			case R.id.btnVisitWc: {
				// ��ע�ٷ�΢��
				String packageName = "com.tencent.mm";
				PackageInfo pi = null;
				try {
					pi = menu.getContext().getPackageManager().getPackageInfo(packageName, 0);
				} catch (Throwable t) {
					Toast.makeText(menu.getContext(), R.string.wechat_client_is_not_installed_correctly,
			    			Toast.LENGTH_SHORT).show();
					t.printStackTrace();
					break;
				}

				if (pi == null) {
					Toast.makeText(menu.getContext(), R.string.wechat_client_is_not_installed_correctly,
			    			Toast.LENGTH_SHORT).show();
					break;
				}

				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(MainAdapter.WECHAT_ADDR));
				i.setPackage("com.tencent.mm");
			    ResolveInfo ri = menu.getContext().getPackageManager().resolveActivity(i, 0);
			    if (ri == null) {
			    	Toast.makeText(menu.getContext(), R.string.wechat_client_is_not_installed_correctly,
			    			Toast.LENGTH_SHORT).show();
			    	break;
			    }

			    try {
			    	menu.getContext().startActivity(i);
			    } catch (Throwable t) {
			    	Toast.makeText(menu.getContext(), R.string.wechat_client_not_support_following_operation,
			    			Toast.LENGTH_SHORT).show();
			    	t.printStackTrace();
			    }
			}
			break;
			case R.id.btnGetInfor: {
				// ��ȡ�Լ�������
				GetInforPage page = new GetInforPage();
				page.setType(0);
				page.show(menu.getContext(), null);
			}
			break;
			case R.id.btnGetUserInfor: {
				// ��ȡָ���ʺŵ�����
				Intent i = new Intent(menu.getContext(), GetInforPage.class);
				i.putExtra("type", 1);
				menu.getContext().startActivity(i);
			}
			break;
			default: {
				// ���������ƽ̨
				Object tag = v.getTag();
				if (tag != null) {
					showShare(false, ((Platform) tag).getName());
				}
			}
			break;
		}
	}

	public void onComplete(Platform plat, int action,
			HashMap<String, Object> res) {

		Message msg = new Message();
		msg.arg1 = 1;
		msg.arg2 = action;
		msg.obj = plat;
		UIHandler.sendMessage(msg, this);
	}

	public void onCancel(Platform palt, int action) {
		Message msg = new Message();
		msg.arg1 = 3;
		msg.arg2 = action;
		msg.obj = palt;
		UIHandler.sendMessage(msg, this);
	}

	public void onError(Platform palt, int action, Throwable t) {
		t.printStackTrace();

		Message msg = new Message();
		msg.arg1 = 2;
		msg.arg2 = action;
		msg.obj = palt;
		UIHandler.sendMessage(msg, this);
	}

	public boolean handleMessage(Message msg) {
		Platform plat = (Platform) msg.obj;
		String text = MainActivity.actionToString(msg.arg2);
		switch (msg.arg1) {
			case 1: {
				// �ɹ�
				text = plat.getName() + " completed at " + text;
			}
			break;
			case 2: {
				// ʧ��
				text = plat.getName() + " caught error at " + text;
			}
			break;
			case 3: {
				// ȡ��
				text = plat.getName() + " canceled at " + text;
			}
			break;
		}

		Toast.makeText(menu.getContext(), text, Toast.LENGTH_SHORT).show();
		return false;
	}

}
