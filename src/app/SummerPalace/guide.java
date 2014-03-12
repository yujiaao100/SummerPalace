package app.SummerPalace;
import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MKMapViewListener;
import com.baidu.mapapi.map.MKOLUpdateElement;
import com.baidu.mapapi.map.MKOfflineMap;
import com.baidu.mapapi.map.MKOfflineMapListener;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.navi.BaiduMapNavigation;
import com.baidu.mapapi.navi.NaviPara;
import com.baidu.mapapi.search.MKPlanNode;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;//�����õ�λ�����ѹ��ܣ���Ҫimport����
//���ʹ�õ���Χ�����ܣ���Ҫimport������
import com.baidu.location.BDGeofence;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.location.GeofenceClient;
import com.baidu.location.GeofenceClient.OnAddBDGeofencesResultListener;
import com.baidu.location.GeofenceClient.OnGeofenceTriggerListener;
import com.baidu.location.GeofenceClient.OnRemoveBDGeofencesResultListener;
//import com.baidu.location.LocationClientOption.LocationMode;
/*Author:Tsing Miao*/

public class guide extends Activity {
	
	BMapManager mBMapMan = null;
	MapView mMapView = null;
	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener(this);
	MKSearch mMKSearch = null;
	GeoPoint geopoint=null;
	GeoPoint geopoint2=null;
	public GeoPoint getGeopoint() {
		return geopoint;
	}

	public void setGeopoint(GeoPoint geopoint) {
		this.geopoint = geopoint;
	}

	public GeoPoint getGeopoint2() {
		return geopoint2;
	}

	public void setGeopoint2(GeoPoint geopoint2) {
		this.geopoint2 = geopoint2;
	}

	MKSearchListener searchListener=new MySearchListener(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		mBMapMan = new BMapManager(getApplication());
		mBMapMan.init("Pq5dv11d7DVxMc9KrcZSTbyy", null);
		// ע�⣺��������setContentViewǰ��ʼ��BMapManager���󣬷���ᱨ��
		mLocationClient = new LocationClient(getApplicationContext());    
	    mLocationClient.registerLocationListener( myListener );
	    mMKSearch = new MKSearch();  
	    mMKSearch.init(mBMapMan, searchListener);//ע�⣬MKSearchListenerֻ֧��һ���������һ������Ϊ׼  
		setContentView(R.layout.guide);
		Button button2=(Button) this.findViewById(R.id.button2);
		Button button=(Button) this.findViewById(R.id.button1);
		TextView view=(TextView)this.findViewById(R.id.editText1);
		view.setText("ʮ�߿���");
		// EditText text=(EditText)this.findViewById(R.id.textView1);
		mMapView = (MapView) findViewById(R.id.bmapsView);
		mMapView.setBuiltInZoomControls(true);
		// �����������õ����ſؼ�
		MapController mMapController = mMapView.getController();
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		GeoPoint point = new GeoPoint((int) (39.984875 * 1E6),
				(int) (116.282272 * 1E6));
		// �ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢�� (�� * 1E6)
		mMapController.setCenter(point);// ���õ�ͼ���ĵ�
		mMapController.setZoom(12);// ���õ�ͼzoom����
		
		LocationClientOption option = new LocationClientOption();
		
	//	option.setLocationMode(LocationMode.Hight_Accuracy);//���ö�λģʽ
		option.setCoorType("bd09ll");//���صĶ�λ����ǰٶȾ�γ�ȣ�Ĭ��ֵgcj02
	//	option.setScanType(5000);//���÷���λ����ļ��ʱ��Ϊ5000ms
	//	option.setIsNeedAddress(true);//���صĶ�λ���������ַ��Ϣ
	//	option.setNeedDeviceDirect(true);//���صĶ�λ��������ֻ���ͷ�ķ���
		option.setScanSpan(1000);
		// mLocationClient.setLocOption(option);
		// mLocationClient.start();//�ǵÿ�ʼ���� ����ͻ�ӡ�����
		geopoint= new GeoPoint((int) (39.984875 * 1E6),
				(int) (116.282272 * 1E6));
		 
		 button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Log.d("button","ok");
				if ( mLocationClient != null &&  mLocationClient.isStarted())
					
					{
						mLocationClient.requestLocation();
					//	geopoint=((MyLocationListener) (myListener)).getPt();
					//	Toast.makeText(MainActivity.this.getApplicationContext(), String.valueOf(geopoint.getLatitudeE6()),Toast.LENGTH_LONG);
					//	Toast.makeText(MainActivity.this.getApplicationContext(), String.valueOf(geopoint.getLatitudeE6()),Toast.LENGTH_LONG);
					}
					else 
					 {
						Log.d("LocSDK3", "locClient is null or not started");
					//	Log.d("LocSDK3", String.valueOf(mLocationClient==null));
				//		Log.d("LocSDK3", String.valueOf(mLocationClient.isStarted()));
					 }
			}
		});
		 
		 button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
				 	if ( mLocationClient != null &&  mLocationClient.isStarted())
					 mLocationClient.requestLocation();
					else 
					 Log.d("LocSDK3", "locClient is null or not started");
				 	EditText text=(EditText)guide.this.findViewById(R.id.editText1);
				 String temp=text.getText().toString();
				 	mMKSearch.geocode(temp,"����");
				 //	 	Log.d("success1",geopoint.toString());
				 //	 	Log.d("success1",geopoint2.toString());
					//Toast.makeText(MainActivity.this.getApplicationContext(), String.valueOf(geopoint.getLatitudeE6()),Toast.LENGTH_LONG);
					//	Toast.makeText(MainActivity.this.getApplicationContext(), String.valueOf(geopoint.getLatitudeE6()),Toast.LENGTH_LONG);
				 	//	Log.d("love",String.valueOf(geopoint.getLatitudeE6()));
				 	//	Log.d("love",String.valueOf(geopoint.getLongitudeE6()));
			}
		});
	}

	

	@Override
	protected void onDestroy() {
		mMapView.destroy();
		if (mBMapMan != null) {
			mBMapMan.destroy();
			mBMapMan = null;
			  if (mLocationClient  != null)
		        {
				  mLocationClient .stop();
		        }
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		if (mBMapMan != null) {
			mBMapMan.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		if (mBMapMan != null) {
			mBMapMan.start();
		}
		super.onResume();
	}
	public void startWebNavi(GeoPoint pt1,GeoPoint pt2)
	{
	
		// ���� ��������
		NaviPara para = new NaviPara();
		para.startPoint = pt1;
		para.endPoint = pt2;
		BaiduMapNavigation.openWebBaiduMapNavi(para, this);
	}
		public void findway()
		{
				Log.d("love",String.valueOf(geopoint.getLatitudeE6()));
		 		Log.d("love",String.valueOf(geopoint.getLongitudeE6()));
		 		Log.d("love",String.valueOf(geopoint2.getLatitudeE6()));
		 		Log.d("love",String.valueOf(geopoint2.getLongitudeE6()));
		 		MKPlanNode start = new MKPlanNode();  
		 		start.pt =geopoint;
		 		MKPlanNode end = new MKPlanNode();  
		 		end.pt = geopoint2;  
		 		//mMKSearch.setDrivingPolicy(MKSearch.ECAR_TIME_FIRST);  
		 		//mMKSearch.set
		 		mMKSearch.walkingSearch(null,start, null, end);
		}
}
