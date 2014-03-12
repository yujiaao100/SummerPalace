/*
 * ������վ:http://www.ShareSDK.cn
 * ����֧��QQ: 4006852216
 * �ٷ�΢��:ShareSDK   ����������°汾�Ļ������ǽ����һʱ��ͨ��΢�Ž��汾�����������͸��������ʹ�ù��������κ����⣬Ҳ����ͨ��΢��������ȡ����ϵ�����ǽ�����24Сʱ�ڸ���ظ���
 *
 * Copyright (c) 2013�� ShareSDK.cn. All rights reserved.
 */

package cn.sharesdk.demo;

import app.SummerPalace.R;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

/**
 * ��ݷ�����Ŀ�������Ϊ��ͬ��ƽ̨��Ӳ�ͬ�������ݵķ�����
 *����������ʾ�������Twitter�ķ������ݺ�����ƽ̨�������ݡ�
 *�������{@link DemoPage#showShare(boolean, String)}����
 *�б����á�
 */
public class ShareContentCustomizeDemo implements ShareContentCustomizeCallback {

	public void onShare(Platform platform, ShareParams paramsToShare) {
		// ��дtwitter���������е�text�ֶΣ�����ᳬ����
		// ��Ϊtwitter�ὫͼƬ��ַ�����ı���һ����ȥ���㳤��
		if ("Twitter".equals(platform.getName())) {
			paramsToShare.text = platform.getContext().getString(R.string.share_content_short);				
		}
	}

}
