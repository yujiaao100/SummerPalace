package app.SummerPalace;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

/*Author:Tsing Miao*/
public class more extends Activity {
	Button button1 = null;
	Button button2 = null;
    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more); 
        button1 =(Button)findViewById(R.id.buttonzhinan);
        button1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent =new Intent();
        		intent.setClass(more.this, zhinan.class);
        		startActivity(intent);
        	}
        });
        
        setContentView(R.layout.more); 
        button2 =(Button)findViewById(R.id.buttonours);
        button2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent =new Intent();
        		intent.setClass(more.this, ours.class);
        		startActivity(intent);
        	}
        });
        
    }*/
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more);
		button1 = (Button)findViewById(R.id.buttonzhinan);
		TextView text1= (TextView)findViewById(R.id.textzhinan);
		text1.setOnClickListener(xx);
		button1.setOnClickListener(xx);
		
		button2 = (Button)findViewById(R.id.buttonours);
		TextView text2= (TextView)findViewById(R.id.textours);
		text2.setOnClickListener(xx);
		button2.setOnClickListener(xx2);
	}

	private OnClickListener xx = new OnClickListener() 
	{
		public void onClick(View v)
		{
			Intent intent = new Intent();
			intent.setClass(more.this, zhinan.class);
			startActivity(intent);
		}			
	};
	
	private OnClickListener xx2 = new OnClickListener() 
	{
		public void onClick(View v2)
		{
			Intent intent2 = new Intent();
			intent2.setClass(more.this, ours.class);
			startActivity(intent2);
		}			
	};
}