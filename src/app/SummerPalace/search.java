package app.SummerPalace;
//ʹ��Sql���ݿ�ʱҪ��
//import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

//���ڵ���
//import android.util.Log;

//import android.view.View.*;
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.*;
//import android.app.AlertDialog;
//import android.content.res.Resources;
//import android.graphics.drawable.Drawable;
//import android.app.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.*;
import android.widget.*;
import android.app.Dialog;
import java.util.ArrayList;
import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechError;
import com.iflytek.ui.RecognizerDialog;
import com.iflytek.ui.RecognizerDialogListener;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class search extends Activity {

	EditText editText = null;
	ImageButton startButton = null;
	Button search=null;
	Button search1=null;
	
	TextView[] view=new TextView[10];
	
	TextView intro1 = null;
	TextView intro2 = null;
	TextView intro3 = null;
    ImageView picture = null;
    TextView shipin = null;
	
	public TextView j=null;
	int i;
	
	String message=null;
	
	View source;
	
	String s="";
	String s1="";
    String s2="";
    String s3="";
    String s4="";
    String s0="";
    SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
      
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		setTitle("  �ú�԰��������");
		
		editText = (EditText) findViewById(R.id.TextResult);
		startButton = (ImageButton) findViewById(R.id.imageButton1);
		search=(Button) findViewById(R.id.Search);
		search1=(Button) findViewById(R.id.Search1);
		
		j=(TextView) findViewById(R.id.where1);
		
		view[0]=j;
		view[1]=(TextView) findViewById(R.id.where2);
		view[2]=(TextView) findViewById(R.id.where3);
		view[3]=(TextView) findViewById(R.id.where4);
		view[4]=(TextView) findViewById(R.id.where5);
		view[5]=(TextView) findViewById(R.id.where6);
		view[6]=(TextView) findViewById(R.id.where7);
		view[7]=(TextView) findViewById(R.id.where8);
		view[8]=(TextView) findViewById(R.id.where9);
		view[9]=(TextView) findViewById(R.id.where10);

		try{
			db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/����.db3", null);
		}
		catch(SQLiteException se)
		{
			message="���ݿⴴ��ʧ�ܣ�����";
			ShowDialog(source);
		}
		Cursor cursor;
		try
		{
			cursor = db.rawQuery("select * from ������Ϣ   where name=?"
					, new String[] {"�ƺ�¥"});
		}
		catch (SQLiteException se)
		{
			String sql = "create table ������Ϣ(ID varchar(255) primary key, name varchar(255), ����1 varchar(255), ����2 varchar(255), ����3 varchar(255), ��Ƶ varchar(255), ����1 varchar(255), ����2 varchar(255), ����3 varchar(255))";
			db.execSQL(sql);
			db.execSQL("insert into ������Ϣ values('1' , '���ٵ�' , '���ٵ����԰ʱ�������ʼ������Ǭ¡ʮ���꣨1750�����̷�ʮ�꣨1860����Ӣ�������ջ٣�����ʮ���꣨1886���ؽ���ȡ������С������١�֮�⣬�������ٵ�����Ǵ����͹���ס԰�ڼ��ٳ����������ܹ��غͽӼ����ʹ�ڵĵط������ú�԰����������Ҫ������', '���ٵ�λ���ú�԰�������ڣ��ǹ�͢������Ҫ����֮һ��Ǭ¡����԰ʱ�ڳơ������������1750�꣬��Ϊ�����������񣻹�������Ϊ��������Ϊʩ�����߳��١����ٵ������򶫣������߼䣬�������ϱ���ǰ�������ţ��������ϱ����䷿��', '���ٵ��Ǵ���̫��͹����ʵ����ú�԰��סʱ����󳼡��Ӽ����ʹ�ڵĵط���Ϊ԰������Ҫ�����λ������Ҳ���й�����ʷ�ϱ䷨ά���˶��Ĳ߻���֮һ��1898������ʵ����ڴ˵��ټ����������俵��Ϊ��������Ϊ����������������¾������ߣ�׼��רߡ���£��Ӷ��ҿ���ά�±䷨����Ļ�����þ����������ڷ⽨���������ķ��ԣ�������ά�¡��չ�ʧ�ܡ�', 'http://www.56.com/u54/v_NTEwNDAyMTk.htm', '����', '����', '����')");
			db.execSQL("insert into ������Ϣ values('2' , '������' , '��������һ������Ժʽ�Ľ����������������������ϣ������ϼ���ң������ź��鿡���������ԭ�Ⱦ��к��ţ�����ɵ����ٵ����ɵ�������ͷ���������ֱ����ܿ�ݡ�', '���������е�ƽ�����豦�����������㼸��Χ���ȣ����Ƕ�������̴ľ�ͳ���ľ��Ƕ��ƴ����������ɣ����Ŷ�ׯ���������������˵Ĳ����������ֳ��г������š�������ˬ��������Ȥ����ů��Ϊ����������ң���ů��Ϊ���ҡ�����ʷ������������������ͬ�͡�����Ϊ�ȣ�����������ʷ�ĺۼ���','������䷨��ʧ�ܺ󣬹�����������Ϻ����̨���ϡ�ÿ��������ú�԰ʱ��������Ҳ�������ͬ����ס�������á�Ϊ�����ܿ��ƹ����ۣ�����������������ǰ�����������˶��שǽ���ſڻ���̫��վ�ڡ���ʱ�������ñ�ȫ��������������һ��������������������ȫʧȥ���ж����ɡ�����������ԭΪ�����������õ�שǽ�Ѳ�ȥ���٣�������Ҳ�����ϻָ��˻ʵ��޹�����ò��ֻ�������ö�������ڵİ�ǽ��Ȼ����ԭ������Ϊ������䷨�йص��ż�����ʷ��֤�����˲ιۡ�','http://www.tudou.com/programs/view/wq_mn6XUgkc/','����',null,null)");
			db.execSQL("insert into ������Ϣ values('3' , '�����' , '�������һ����ΰ����ʽ�ڽ̽�����Ϊȫ԰�������ֵ����ġ������㡱������Դ�ڷ�̶Է�ĸ��̡���Ǭ¡ʱ��1736-1795���ڴ����Ų������������ڰ˲㡰��ּͣ�ޡ����Ľ�������̷�ʮ�꣨1860�꣩����Ӣ������������ʱ��1875һ1908����ԭַ�����ؽ����������','�ø�º��ݵ����������죬�˽���20�׵�ʯ��̨���ϣ��������������ܡ����41�ף����棬���㣬�����ܡ������а˸�����ľ������ֱ�ᶥ��������20�׸ߵ�ʯ̨�������ϲ��Ի ��ʽ�ӷ�̡����в��Ի�������ѻء����²��Ի���������㡱������ ������󡱡��ڹ�������ÿ����˷�������ڴ�������� �������ˣ��Ӹ����£����Ա�������������ʮ����������ķ�⡣','�ú�԰���������޽���һ����ģ���Ļʼ�԰�֡���ˣ����Ƕ������ʼ�԰���е����Ľ�����������޽������ر�����أ�Ҳ�ر�����ġ���˵���޽�������ľ�ϣ��е��������ϣ��е����Զ������޽�������ʯ�ϣ��е����Խ���̫�����е��������ϴ����޽������Ĺ������е������������е��������ݡ��ɼ��������޽�ͬ�ú�԰һ������ȫ���Ͷ������ǻۺ�Ѫ���Ľᾧ ��','http://v.ku6.com/show/jwkJk_4DRWjcL418TR4-pg...html','�ڽ�','����',null )");
			db.execSQL("insert into ������Ϣ values('4' , '���Ƶ�' , '���Ƶ�ԭʼǬ¡Ϊ��ĸ��60�ٳ������Ĵ󱨶������£������ؽ���ʱ�����Ϊ���Ƶ���Ƶ�������ɽǰ���������Ĳ�λ�������ơ�����ȡ�Թ��ʫ������������ɽ���������̨�������齨�����ú�԰��Ϊ׳�۵Ľ���Ⱥ��','���Ƶ�ش�����ɽǰ���������Ĳ�λ���Ǵ���������ʱ���ܳ��ݵĵط���������һ����̨�ϣ�Ъɽ���ܣ�ǰ����21�䷿����ɡ������б�����Χ������¯�����ȵȣ�ƽ̨�¶Գ������Ź�����ʢˮ�õ��Ŀڴ�ͭ�ף��׳ơ��ź����� ���Ƶ����������Ⱥ���ǰԺ��ˮ�ػ򺺰������ɵĽ�ˮ�š�������ص�������������ͷס���Զ����ȥ�����Ƶ�����¥�������š���ˮ�š������������˲�����ߵ�һ��ֱ�ߡ����Ƶ����齨�������ú�԰��Ϊ׳�۵Ľ���Ⱥ�塣�����ơ����ֳ��Խ�����象��������Ƴ�����������̨����ʫ�䣬����������������Ƶ���ɽ����У����ɼ���¶�档','��Ǭ¡ʱ�ڣ����齨���С��󱨶������¡���1860�걻Ӣ�������ٻ٣���������ؽ��������������Ƶ����˵����ʼʱ�������������Ϊ�����޹������ڸ����ʱ�����͵���һ����������Ϊ�������Ǵ˵����Ųླ�������̫���������ڳ��ھ�ס���������ž������޹����������ã������Ƶ�ֻ��Ϊ��������ʱ���ܳ��ݵĵط���','http://v.youku.com/v_show/id_XNDU4MjEzMjU2.html','��','�ƽ�','����')");
			db.execSQL("insert into ������Ϣ values('5' , '����' , 'λ������ɽ��´����������������������ɽ�����������ţ���ֹʯ��ͣ��ȫ��728�ף�1992�걻���缪��˹��¼�϶�Ϊ������ĳ��ȡ�','���ϵ�ÿ�������϶��вʻ棬����ͼ��14000��������ݰ���ɽˮ�羰��������桢�����ʵȡ����е����ﻭ��ȡ�����й��ŵ�������','����ʼ����Ǭ¡ʮ�����ú�԰���ȣ�1750������Ӣ�������ջ٣�����ʮ���꣨1886���ؽ������ȶ��������ţ�����ʯ��ͤ����������ʮ���䣬ȫ���߰ٶ�ʮ���ף������ϻ��������ɽˮ������ȸ��ֲʻ���ǧ��������й��ŵ�԰����������ȡ������м佨�����ѡ���������ˮ����ң�����˽����ܵ�ͤ�ӣ���ɽ��ˮ�������Ƶ�Ϊ���ģ��������߶ԳƵ�չ�������ֲ�������ɽǰ�Ľ�������һ����','http://v.youku.com/v_show/id_XMjg1MzcxNg==.html','�ʻ�','����','ʯ��')");
			db.execSQL("insert into ������Ϣ values('6' , '������' , '������ԭ��ʯ�������ú�԰����ɽ��´���������ߡ���԰��������ˮ�Ͻ�����','��������Ǭ¡ʮ���꣨1755���������ɴ���ʯ��ɣ�����ԭΪ��ʽ¥��1860��Ӣ������������¥���ջ١�1893���ؽ�ʱ����������ʽ������Ϊ����ʽ¥�����Բ�ɫ��������������������֣��������������㴬�����д󾵣�ϸ������֮ʱ���������ھ�ǰ��һ��Ʒ����һ�����;����꾰��','ʯ���ڳ������˺��ߣ���һ����ʯ����ȡ����������Ԣ��������̡�֮�⡣���ú�԰Ψһ����������Ľ�����ʯ����36�ף������Ͻ������㴬¥�����׻�ש�̵أ�����Ϊ��ɫ����������ש��װ�Ρ�����ʱ�����ڴ�������ˮͨ���ĽǵĿ������ӣ��ɴ�����ĸ���ͷ��������У����ʮ�����','http://v.youku.com/v_show/id_XNDEyNTAyNDA4.html','ʯ��','����','���')");
			db.execSQL("insert into ������Ϣ values('7' , 'ʮ�߿���' , 'ʮ�߿������ú�԰�������ľ���֮һ������������ͤ�������Ϻ�������150�ף������й�԰����������������Ǭ¡ʱ��1736һ1795������','ʮ�߿�����һ������ʯ�š������¿�14.6�ף������Ͽ�6.56�ף���7�ס������Ÿ�����һ����ΰ�ߴ�֮�С������Ź���17���Ŷ������Խ�ʮ�߿��š�����17���ſ��У���9��������м���������С�������Գ����С�ˮ��δ����ʱ���Ŷ���ˮ�еĵ�Ӱ�ɷĴ��Σ�ʮ�������������ſ״�С��һ������������һ�����¶ȣ���һ�Ź���ʮ�߿�����������߲ʵĳ���ɼ��ڱ̲�������������ϣ��������е�����״����¸�����ƽ���ƾ���ˮ�С�','���ŵķ羰������������֮ҹ���͸������ˡ�ʮ�߿�����ʯ���侫����ÿ�������������϶�������̬�����ʨ�ӣ���С�������ʮ��ֻ�������ߵİ�ʯ���ˣ�����128��������ÿ�������϶�����ž�������̬�����ʯʨ���е�ĸ���౧���е���ˣ���֣��е���׷�Ҹϣ��е�����۾�������Ω��ΩФ����ͷ������ֻ��ˮ�ޣ��������룬ʮ�����䡣�ŵ���ͷ����ֻʯ�����ޣ����������쳣����Ϊ������','http://v.youku.com/v_show/id_XNDEyNTAwNDU2.html','ʮ��','ʯ��','ʯ��')");
			db.execSQL("insert into ������Ϣ values('8' , '�Ĳ���' , '�����ϣ�����֪��ͤ��֪����ͷ��������һ���ߴ�Ρ��ĳǹ�ʽ������������Ĳ����Ĳ�����������˲�ʢ�����Ĳ������Ĳ��۾����Ĳ��۾��ǵ��������ƹ�����»֮���ܵ��Ŵ����˵��ر���硣�����״Ԫ�����ҵ��ú�԰һ��ʱ���ض�Ҫ���Ĳ����������Ĳ��۾���������԰����԰����У�������ɽ��´�����ܹ���صۣ������﹩���Ĳ��۾������丨��֮Ԣ�⡣','�Ĳ���ʼ����1750�꣬��԰�������ǹأ������ܡ��Ĳ���ǧ��ʴ䡢���ԡ�����������ͨ�ƣ�������һ����Ǭ¡ʱ�ڣ��������������������沢û��Χǽ�������ǹؼ���Ϊ�Ӷ��Ϸ�����԰���Ż���','�Ĳ����ǽ��ڳǹػ����ϵ�¥��ʽ��������ͷ�������ƽ��ʡ��ˡ����Σ��м�Ϊ����¥��1860����Ӣ�������ƻ���ֱ�����������ú�԰ʱ�Ž���Ľ����Ľ���Ϊ�������㣬����Ϊʮ���λ������̼����������档�Ĳ����й������Ĳ��۾�ͭ����С��ͯ�������ң��Ա�һƥͭ�⣬��̬��Ȼ����˵�ǵ۾��ĳ��վ���Ĳ����ϣ��ȿ���Զ������ɽ����ɽ�羰����ɸ��������ȫò��Ӧ���Ǹ��۾��ĺõط���','http://v.youku.com/v_show/id_XNTY1OTYxNDcy.html','�ǹ�','¥��','�۾�')");
			db.execSQL("insert into ������Ϣ values('9' , 'гȤ԰' , 'гȤ԰������ɽ��´����һ�����������������Ϸ�԰�ַ���԰��֮԰������԰ʱ���л�ɽ԰�����Ƿ�������ɽ�ĳ�԰����������ʮ���꣨1811�꣩���޺�ȡ��������֮��Ȥ��г����֮�к͡���Ǭ¡�ʵ۵�ʫ�䡰һͤһ������г��Ȥ������˼������Ϊ��гȤ԰����԰�ڹ���ͤ��̨���á��ʮ���������ðټ����Ⱥ�������ʽ��ͬ�����๵ͨ��','��гȤ԰��ֻ��һ�غɻ���ͤͤ������԰����һ���������������ɽȪ�ֳ�����ע��ɳء����ɽȪ��ˮԴ������������������ˣ�гȤ԰ȡ��˵��ݵĵ��ƣ���Ҫ����Ϊ���γ����ɽȪ��ʹгȤ԰��ˮ��������ˮ���γ�һ���׵�������һ���׵�����У�������ɽʯ�Ķѵ����ֳɼ�����Σ�ʹ������Ϣ��ˮ���ߵ����֣��������ϣ��ѹֺ�����Ȫ�ߵ�һ���ʯ�ϣ����С�����Ͽ�����֡��д�һ����ʹ����԰��֮԰������ɫ����νгȤ԰�ġ���Ȥ����','������Ͽ������һ������¥������¥��԰�ڲ࿴������¥��������㿴��ȴ��һ�㡣ԭ����гȤ԰����ǰ����������·����͵㣬������ǰ���������ߣ�����ֱ�Ӳ�������¥���ϲ㣬������¥��¥����ƣ���ν��¥Ȥ����гȤ԰�й�����������������֪������Ϊ�������ӽ�ˮ�棬���ڹ��㣬ȡ��֪���ţ���������ս��ʱ��ׯ�Ӻͻ����ڡ���ˮ��ϡ���һ���й�֪�㲻֪�ֵĸ�������ı�����Ϸ���ù��˵Ĺ������������˵���ζ������԰�еġ���Ȥ����','http://v.youku.com/v_show/id_XNTY3MzA1ODgw.html','��Ȥ','¥Ȥ','��Ȥ')");
			db.execSQL("insert into ������Ϣ values('10' , '���ݽ�' , '���ݽ��ֳơ������֡������ݽ��Ǻ�������½���ˮ�硪�����ݶ����������֡�����԰ʱ�ڰ����и�ʽ���̣�����������ꡢ��еꡢ�����̡���¥����������¥�ȡ������еĵ�Ա����̫�ࡢ��Ůױ�硣�ʵ�����ʱ��ʼ��Ӫҵ����������ߵ���ʮ������1860�걻��ǿ�ٻ١����ڵľ���Ϊ1986������','���ݽּ���һ����ʷ���ľ��ۣ�����һ�����ص���Ȼ���ۣ����ڹ�Է֮�У�С�����磬��ɽ��ˮ�����罭��ͼ����׺�ں�ɽ����Ľ��������ϣ����ӳ����˺�����������ţ��ѳ���ɽ�ּ�����������ֳ���������Ǭ¡�ʵ۵�ĸ����ϲ������֮����','���ݽ�����ˮ�л���ˮ�ߵĽ�������������ɽ�Ͼ��ۺ�Ӧ�����岼�֣��쾰���򡣶���ԭ������ʵ��Ϊ���ݣ��������������Ʋ�Ų�����Ŵ���С����ʵ���ִ���ʷ�Ϻͺ���ռ��ж�ʧ��һ�������͵����齨��Ⱥ��','http://v.youku.com/v_show/id_XMzE1NjM5NzMy.html','���','����','����')");
		}
		
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(1);
			}
		});
		
	//Ϊ����б�����TextView�ؼ���ӵ��������֪Ϊ�β���ֱ����forѭ����������ִ�
	for(i=0;i<10;i++)
	{
		view[i].setOnClickListener(on);
	}
	
	search.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
      for(i=0;i<10;i++)
      {
          view[i].setTextColor(0xff000000);
      }
		if(editText.getText().toString().isEmpty())
		{
			message="�������������㣡����";
			ShowDialog(source);
			return;
		}
		else //��������Ϊ�ǿ�
		{ 
			s=editText.getText().toString();  //sΪҪ�������������
			
			//������(s)����
			//��ش���
			Cursor cursor;
			cursor = db.rawQuery("select * from ������Ϣ   where name=?"
					, new String[] {s});
			if(cursor.getCount()==0)
			{
				s0="";
			}
			else
			{
				cursor.moveToFirst();
				s0=cursor.getString(0);
				s=cursor.getString(1);
				s1=cursor.getString(2);
				s2=cursor.getString(3);
				s3=cursor.getString(4);
				s4=cursor.getString(5);
			}
			
			if(s0.isEmpty())
			{
		        message="�Բ���δ�ҵ���ؾ��㣡";
		        ShowDialog(source);
		        s=null;
		        return;
			}
			//�������s,s0,s1,s2,s3,s4(s0Ϊ��ID������������ʾͼƬ��s1/s2/s3Ϊ����1��2��3,s4Ϊ��Ƶ��Ӧ������)
			
		   for(i=0;i<10;i++)  //�ж�����ľ����Ƿ�Ϊ�б��еľ���
		       {
		            if(s.equals(view[i].getText().toString()))
		            {
		                view[i].setTextColor(0xffccff33);
		                j=view[i];
		                Intent intent=new Intent();
		                intent.putExtra("name", s);   //������������������
		                intent.putExtra("intro1", s1);  //�������������Ľ���1
		                intent.putExtra("intro2", s2);  //�������������Ľ���2
		                intent.putExtra("intro3", s3);  //�������������Ľ���3
		                intent.putExtra("shipin", s4);  //����������������Ƶ����
		                intent.putExtra("ID", s0);   //��������������ID
		                intent.setClass(search.this, Introduce.class);
		                startActivity(intent);
		            }
		       }
		}
		}
	});
	
	search1.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
	        for(i=0;i<10;i++)
	        {
	            view[i].setTextColor(0xff000000);
	        }
			if(editText.getText().toString().isEmpty())
			{
				message="�������������������������";
				ShowDialog(source);
				return;
			}
			else //��������Ϊ�ǿ�
			{ 
				s=editText.getText().toString();  //sΪҪ�������������
				
				//����������(s)����
				//��ش���......
				Cursor cursor;
				cursor = db.rawQuery("select * from ������Ϣ   where ����1=? or ����2=? or ����3=?"
						, new String[] {s,s,s});
				if(cursor.getCount()==0)
				{
					s0="";
				}
				else
				{
					cursor.moveToFirst();
					s0=cursor.getString(0);
					s=cursor.getString(1);
					s1=cursor.getString(2);
					s2=cursor.getString(3);
					s3=cursor.getString(4);
					s4=cursor.getString(5);
				}
				//���Ϊ��
				if(s0.isEmpty())
				{
			        message="�Բ���δ�ҵ���ؾ��㣡";
			        ShowDialog(source);
			        s=null;
			        return;
				}
				//�������s,s0,s1,s2,s3,s4(s0Ϊ��ID������������ʾͼƬ��s1/s2/s3Ϊ����1��2��3,s4Ϊ��Ƶ��Ӧ������)
				
			    for(i=0;i<10;i++)  //�ж�����ľ����Ƿ�Ϊ�б��еľ���
			       {
			            if(s.equals(view[i].getText().toString()))
			            {
			                view[i].setTextColor(0xffccff33);
			                j=view[i];
			                Intent intent=new Intent();
			                intent.putExtra("name", s);   //������������������
			                intent.putExtra("ID", s0);   //��������������ID
			                intent.putExtra("intro1", s1);  //�������������Ľ���1
			                intent.putExtra("intro2", s2);  //�������������Ľ���2
			                intent.putExtra("intro3", s3);  //�������������Ľ���3
			                intent.putExtra("shipin", s4);  //����������������Ƶ����
			                intent.setClass(search.this, Introduce.class);
			                startActivity(intent);
			            }
			       }
			}
			}
		});}

	public void ShowDialog(View source)
	{
	    //�����Ի���  
	    new AlertDialog.Builder(this)  
	    .setTitle("SORRY")  //���öԻ������  
      .setMessage(message)
      .setIcon(R.drawable.sorry)
	    .setPositiveButton("ȷ��", null)    //���öԻ���[��]��ť  
	    .create()
	    .show();  
	}  
	 
	@Override
	protected Dialog onCreateDialog(int id) {
		RecognizerDialog recognizerDialog = new RecognizerDialog(
				search.this, "appid=51db75c0");// ����Ӧ��д�ӿƴ�Ѷ�����뵽��appid
		recognizerDialog.setEngine("sms", null, null);
		recognizerDialog.setListener(new RecognizerDialogListener() {
			@Override
			public void onResults(ArrayList<RecognizerResult> results,
					boolean arg1) {
				StringBuffer result = new StringBuffer();
				for (RecognizerResult r : results) {
					result.append(r.text);
				}
				String get=result.toString();
				editText.setText(get.substring(0,get.length()-1));
			}

			@Override
			public void onEnd(SpeechError arg0) {

			}
		});
		return recognizerDialog;
	}
	
	OnClickListener on=new OnClickListener()
	{
		public void onClick(View v)
		{
			TextView viewx=(TextView)findViewById(v.getId());
			j.setTextColor(0xff000000);
			viewx.setTextColor(0xffccff33);
	        editText.setText(viewx.getText());
	        j=viewx;
		   
	        //���ڵ������ֱ���������ܵĴ��룬��һ�����������ԭ����
	        //�����ݿ��в�ѯ��ؾ���view[0]����ؽ��ܣ�����s,s0,s1,s2,s3,s4
	        s=viewx.getText().toString();
	        Cursor cursor;
			cursor = db.rawQuery("select * from ������Ϣ   where name=?"
					, new String[] {s});
			if(cursor.getCount()==0)
			{
				s0="";
			}
			else
			{
				cursor.moveToFirst();
				s0=cursor.getString(0);
				s=cursor.getString(1);
				s1=cursor.getString(2);
				s2=cursor.getString(3);
				s3=cursor.getString(4);
				s4=cursor.getString(5);
			}
			
			Intent intent=new Intent();
	        intent.putExtra("name", s);   //������������������
	        intent.putExtra("intro1", s1);  //�������������Ľ���1
	        intent.putExtra("intro2", s2);  //�������������Ľ���2
	        intent.putExtra("intro3", s3);  //�������������Ľ���3
	        intent.putExtra("shipin", s4);  //����������������Ƶ����
	        intent.putExtra("ID", s0);   //��������������ID
	        intent.setClass(search.this, Introduce.class);
	        startActivity(intent);
		}
	};
	}

//����ֱ����forѭ��Ϊ�����Ӧ��TextView���setOnClickListener(��onClick����ֱ��д��new OnClickListener()��ʱ)��
//��ʹ��������ʱ��������ִ�ԭ������������������������Ϳ���ѭ�����setOnClickListener
/*for(i=0;i<=8;i++)  //�˴�����Ϊ9����������ԭ����
{
	view[i].setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			view[j].setTextColor(0xffc0c0c0);
			view[i].setTextColor(0xffccff33);
		    editText.setText(view[i].getText());
		    j=i;
		    }
	});
}*/
