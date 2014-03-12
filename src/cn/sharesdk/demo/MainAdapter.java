/*
 * ������վ:http://www.ShareSDK.cn
 * ����֧��QQ: 4006852216
 * �ٷ�΢��:ShareSDK   ����������°汾�Ļ������ǽ����һʱ��ͨ��΢�Ž��汾�����������͸��������ʹ�ù��������κ����⣬Ҳ����ͨ��΢��������ȡ����ϵ�����ǽ�����24Сʱ�ڸ���ظ���
 *
 * Copyright (c) 2013�� ShareSDK.cn. All rights reserved.
 */

package cn.sharesdk.demo;

import java.util.HashMap;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.UIHandler;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Message;
import android.os.Handler.Callback;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout.LayoutParams;
import app.SummerPalace.R;
import m.framework.ui.widget.slidingmenu.MenuAdapter;
import m.framework.ui.widget.slidingmenu.SlidingMenu;
import m.framework.ui.widget.slidingmenu.SlidingMenuItem;

/**
 * ����ʵ���߼��ࡣ
 * <p>
 * ������ɲ���Ŀ¼��չʾ���¼��ļ�����ҳ���������ʾ���л��ȵ�ҵ��
 */
public class MainAdapter extends MenuAdapter
		implements Callback, PlatformActionListener {
	/** "�ӿ�"���� */
	public static final int GROUP_DEMO = 1;
	/** �����ࡱ���� */
	public static final int GROUP_MORE = 2;

	/** ���ӿڡ��� */
	public static final int ITEM_DEMO = 1;
	/** ����Ȩ���� */
	public static final int ITEM_AUTH = 2;
	/** ��΢�š��� */
	public static final int ITEM_WECHAT = 3;
	/** �����š��� */
	public static final int ITEM_YIXIN = 4;
	/** ���Զ���ӿڡ��� */
	public static final int ITEM_CUSTOMER = 5;
	/** ����ע����΢������ */
	public static final int ITEM_FOLLOW_SINAWEIBO = 7;
	/** ����ע��Ѷ΢������ */
	public static final int ITEM_FOLLOW_TECENTWEIBO = 8;
	/** ����ע�ٷ�΢�š��� */
	public static final int ITEM_VISIT_WECHAT = 9;
	/** ����ע�ٷ���վ���� */
	public static final int ITEM_VISIT_WEBSITE = 10;
	public static final int ITEM_ABOUT = 11;

	/** �ٷ�΢�� */
	public static final String WECHAT_ADDR = "http://weixin.qq.com/r/HHURHl7EjmDxh099nyA4";
	/** �ٷ���վ */
	public static final String WEBSITE_ADDR = "http://www.shareSDK.cn";
	/** �ٷ�����΢�� */
	public static final String SDK_SINAWEIBO_UID = "3189087725";
	/** �ٷ���Ѷ΢�� */
	public static final String SDK_TENCENTWEIBO_UID = "shareSDK";

	private SlidingMenu menu;
	private SlidingMenuItem curItem;

	public MainAdapter(SlidingMenu menu) {
		super(menu);
		this.menu = menu;
		initDate();
	}

	private void initDate() {
		
		setGroup(GROUP_DEMO, "");
		setGroup(GROUP_MORE, menu.getResources().getString(R.string.more));

		SlidingMenuItem item = new SlidingMenuItem();
		item.id = ITEM_DEMO;
		item.body = menu.getResources().getString(R.string.sm_item_demo);
		setItem(GROUP_DEMO, item);

		item = new SlidingMenuItem();
		item.id = ITEM_AUTH;
		item.body = menu.getResources().getString(R.string.sm_item_auth);
		setItem(GROUP_DEMO, item);

		item = new SlidingMenuItem();
		item.id = ITEM_WECHAT;
		item.body = menu.getResources().getString(R.string.sm_item_wechat);
		setItem(GROUP_DEMO, item);

		item = new SlidingMenuItem();
		item.id = ITEM_YIXIN;
		item.body = menu.getResources().getString(R.string.sm_item_yixin);
		setItem(GROUP_DEMO, item);

		item = new SlidingMenuItem();
		item.id = ITEM_CUSTOMER;
		item.body = menu.getResources().getString(R.string.sm_item_customer);
		setItem(GROUP_DEMO, item);

		item = new SlidingMenuItem();
		item.id = ITEM_FOLLOW_SINAWEIBO;
		item.body = menu.getResources().getString(R.string.sm_item_fl_weibo);
		setItem(GROUP_MORE, item);

		item = new SlidingMenuItem();
		item.id = ITEM_FOLLOW_TECENTWEIBO;
		item.body = menu.getResources().getString(R.string.sm_item_fl_tc);
		setItem(GROUP_MORE, item);

		item = new SlidingMenuItem();
		item.id = ITEM_VISIT_WECHAT;
		item.body = menu.getResources().getString(R.string.sm_item_visit_wechat);
		setItem(GROUP_MORE, item);

		item = new SlidingMenuItem();
		item.id = ITEM_VISIT_WEBSITE;
		item.body = menu.getResources().getString(R.string.sm_item_visit_website);
		setItem(GROUP_MORE, item);

		item = new SlidingMenuItem();
		item.id = ITEM_ABOUT;
		
		String appVer = menu.getResources().getString(R.string.app_version);
		item.body = menu.getResources().getString(R.string.sm_item_about, appVer);
		setItem(GROUP_MORE, item);
	}

	/** �조�顱���� */
	public View getGroupView(int position, ViewGroup menu) {
		String text = getTitle(position);
		if (text == null || text.length() <= 0) {
			return new LinearLayout(menu.getContext());
		}

		TextView tvTitle = new TextView(menu.getContext());
		tvTitle.setBackgroundResource(R.drawable.sidebar_titlt_back);
		int dp_13 = dipToPx(menu.getContext(), 13);
		int dp_5 = dipToPx(menu.getContext(), 3);
		tvTitle.setPadding(dp_13, dp_5, dp_13, dp_5);
		tvTitle.setText(text);
		tvTitle.setGravity(Gravity.CENTER_VERTICAL);
		tvTitle.setTextColor(0xff999999);
		tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
		tvTitle.setLayoutParams(new ScrollView.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		return tvTitle;
	}

	/** �조�˵�� */
	public View getItemView(SlidingMenuItem item, ViewGroup menu) {
		TextView tvItem = new TextView(menu.getContext());
		tvItem.setGravity(Gravity.CENTER_VERTICAL);
		tvItem.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
	//	tvItem.setTextColor(tvItem.getResources().getColorStateList(
		//		R.color.normal_gray_pressed_white));
		tvItem.setText(String.valueOf(item.body));
		tvItem.setCompoundDrawablesWithIntrinsicBounds(
				0, 0, R.drawable.pointer, 0);
		int dp_13 = dipToPx(menu.getContext(), 13);
		tvItem.setCompoundDrawablePadding(dp_13);
		tvItem.setPadding(dp_13, 0, dp_13, 0);
		int dp_52 = dipToPx(menu.getContext(), 52);
		tvItem.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, dp_52));
		return tvItem;
	}

	private int dipToPx(Context context, int dip) {
		return (int) (dip * context.getResources().getDisplayMetrics().density + 0.5f);
	}

	/**
	 * ���˵�������ʱ�򣬴˷����ᱻ���������ڴ���˵����ҵ���߼�
	 *�����ض�Ӧ��ҳ�����塣
	 */
	public boolean onItemTrigger(SlidingMenuItem item) {
		if (curItem != null && curItem.equals(item)
				&& item.group == GROUP_DEMO) {
			return false;
		}

		curItem = item;
		switch(item.group) {
			case GROUP_DEMO: {
				SlidingMenuPage page = null;
				switch(item.id) {
					case ITEM_DEMO: {
						page = new DemoPage(menu);
					}
					break;
					case ITEM_AUTH: {
						page = new AuthPage(menu);
					}
					break;
					case ITEM_WECHAT: {
						page = new WechatPage(menu);
					}
					break;
					case ITEM_YIXIN: {
						page = new YixinPage(menu);
					}
					break;
					case ITEM_CUSTOMER: {
						page = new CustomerPage(menu);
					}
					break;
				}
				if (page != null) {
					menu.setBodyView(page.getPage());
				}
			}
			break;
			case GROUP_MORE: {
				switch(item.id) {
					case ITEM_FOLLOW_SINAWEIBO: {
						Platform plat = ShareSDK.getPlatform(menu.getContext(), "SinaWeibo");
						plat.setPlatformActionListener(this);
						plat.followFriend(SDK_SINAWEIBO_UID);
					}
					break;
					case ITEM_FOLLOW_TECENTWEIBO: {
						Platform plat = ShareSDK.getPlatform(menu.getContext(), "TencentWeibo");
						plat.setPlatformActionListener(this);
						plat.followFriend(SDK_TENCENTWEIBO_UID);
					}
					break;
					case ITEM_VISIT_WECHAT: {
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
						i.setData(Uri.parse(WECHAT_ADDR));
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
					case ITEM_VISIT_WEBSITE: {
						Intent i = new Intent(Intent.ACTION_VIEW);
						i.setData(Uri.parse(WEBSITE_ADDR));
						menu.getContext().startActivity(i);
					}
					break;
					case ITEM_ABOUT: {
						String appName = menu.getResources().getString(R.string.app_name);
						String version = menu.getResources().getString(R.string.app_version);
						Toast.makeText(menu.getContext(), appName + " " + version, Toast.LENGTH_SHORT).show();
					}
					break;
				}
				return true;
			}
		}
		return false;
	}

	public void onComplete(Platform plat, int action,
			HashMap<String, Object> res) {
		Message msg = new Message();
		msg.arg1 = 1;
		msg.arg2 = action;
		msg.obj = plat;
		UIHandler.sendMessage(msg, this);
	}

	public void onCancel(Platform plat, int action) {
		Message msg = new Message();
		msg.arg1 = 3;
		msg.arg2 = action;
		msg.obj = plat;
		UIHandler.sendMessage(msg, this);
	}

	public void onError(Platform plat, int action, Throwable t) {
		t.printStackTrace();

		Message msg = new Message();
		msg.arg1 = 2;
		msg.arg2 = action;
		msg.obj = plat;
		UIHandler.sendMessage(msg, this);
	}

	public boolean handleMessage(Message msg) {
		Platform palt = (Platform) msg.obj;
		String text = MainActivity.actionToString(msg.arg2);
		switch (msg.arg1) {
			case 1: {
				// �ɹ�
				text = palt.getName() + " completed at " + text;
			}
			break;
			case 2: {
				// ʧ��
				text = palt.getName() + " caught error at " + text;
			}
			break;
			case 3: {
				// ȡ��
				text = palt.getName() + " canceled at " + text;
			}
			break;
		}

		Toast.makeText(menu.getContext(), text, Toast.LENGTH_SHORT).show();
		return false;
	}

}
