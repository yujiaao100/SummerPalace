package app.SummerPalace;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
/*
 * ���ļ�ʹ��guide ÿ5s����һ�ζ�λ����
 */
public class guidehandler extends Handler 
{
	Activity map;
	public guidehandler(Activity map) 
	{
		// TODO Auto-generated constructor stub
		this.map=map;
	}
	boolean is_closed=true;
	public void start()
	{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(is_closed==false)
				{
					try {
						Thread.sleep(5000);
						sendEmptyMessage(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		
		
	}
	
}
