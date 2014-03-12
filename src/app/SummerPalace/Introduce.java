package app.SummerPalace;
//用于调试时用
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
* <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
	
	String s="颐和园";
	String s1="当前无查询景点的相关介绍，但是你可以了解颐和园的相关介绍：";
    String s2="中国现存规模最大、保存最完整的皇家园林，中国四大名园（另三座为承德避暑山庄、苏州拙政园、苏州留园）之一。位于北京市海淀区，距北京城区十五公里，占地约二百九十公顷。利用昆明湖、万寿山为基址，以杭州西湖风景为蓝本，汲取江南园林的某些设计手法和意境而建成的一座大型天然山水园，也是保存得最完整的一座皇家行宫御苑，被誉为皇家园林博物馆。";
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
		
		//获取的结果搜索信息
		Intent intent=getIntent(); 
		s=intent.getStringExtra("name");  
		s1=intent.getStringExtra("intro1"); 
		s2=intent.getStringExtra("intro2"); 
		s3=intent.getStringExtra("intro3"); 
		s4=intent.getStringExtra("shipin"); 
		s0=intent.getStringExtra("ID"); 
		
	    //查询更新完毕，更新试图
		s="  "+s+"的详细介绍";
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

