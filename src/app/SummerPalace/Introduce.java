package app.SummerPalace;
//���ڵ���ʱ��
//import android.util.Log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import cn.sharesdk.demo.*;
/**
* Description:
* <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
* <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
* <br/>This program is protected by copyright laws.
* <br/>Program Name:
* <br/>Date:
* @author  Yeeku.H.Lee kongyeeku@163.com
* @version  1.0
*/
public class Introduce extends Activity
{
	TextView name = null;
	TextView intro1 = null;
	TextView intro2 = null;
	TextView intro3 = null;
	ImageView picture = null;
	TextView shipin = null;
	
	String s="�ú�԰";
	String s1="��ǰ�޲�ѯ�������ؽ��ܣ�����������˽��ú�԰����ؽ��ܣ�";
    String s2="�й��ִ��ģ��󡢱����������Ļʼ�԰�֣��й��Ĵ���԰��������Ϊ�е±���ɽׯ������׾��԰��������԰��֮һ��λ�ڱ����к��������౱������ʮ�幫�ռ��Լ���پ�ʮ���ꡣ����������������ɽΪ��ַ���Ժ��������羰Ϊ��������ȡ����԰�ֵ�ĳЩ����ַ����⾳�����ɵ�һ��������Ȼɽˮ԰��Ҳ�Ǳ������������һ���ʼ��й���Է������Ϊ�ʼ�԰�ֲ���ݡ�";
    String s3="";
    String s4="http://www.tudou.com/programs/view/ZpdWLfGUrxQ/";
    String s0="0";
  
  int[] images = new int[]{
	 		R.drawable.p0,
	 		R.drawable.p1,
	 		R.drawable.p2,
	 		R.drawable.p3,
	 		R.drawable.p4,
	 		R.drawable.p5,
	 		R.drawable.p6,
	 		R.drawable.p7,
	 		R.drawable.p8,
	 		R.drawable.p9,
	 		R.drawable.p10,
	 	};
  
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		
		//��ȡ�Ľ��������Ϣ
		Intent intent=getIntent(); 
		s=intent.getStringExtra("name");  
		s1=intent.getStringExtra("intro1"); 
		s2=intent.getStringExtra("intro2"); 
		s3=intent.getStringExtra("intro3"); 
		s4=intent.getStringExtra("shipin"); 
		s0=intent.getStringExtra("ID"); 
		
	    //��ѯ������ϣ�������ͼ
		s="  "+s+"����ϸ����";
		setTitle(s);
		name = (TextView)findViewById(R.id.name);
		intro1 = (TextView)findViewById(R.id.con1);
		intro2 = (TextView)findViewById(R.id.con2);
		intro3 = (TextView)findViewById(R.id.con3);
		picture = (ImageView)findViewById(R.id.pic);
		shipin = (TextView)findViewById(R.id.shipin2);
		name.setText(s);
		intro1.setText("       "+s1);
		intro2.setText("       "+s2);
		intro3.setText("       "+s3);
		picture.setImageResource(images[Integer.valueOf(s0).intValue()]);
		shipin.setText(s4);
		Button button=(Button)this.findViewById(R.id.buttonweibo);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Introduce.this,MainActivity.class );
				Introduce.this.startActivity(intent);
			}
		});
		}
}

