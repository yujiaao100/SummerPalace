package app.SummerPalace;

import android.app.Activity;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MyLocationListener implements BDLocationListener {
		Activity map=null;
		GeoPoint pt=null;
		int i=0;
		public MyLocationListener(Activity map) {
			// TODO Auto-generated constructor stub
			this.map=map;
		}
	@Override
	public void onReceiveLocation(BDLocation arg0) {
		// TODO Auto-generated method stub
	
		if(arg0==null)
			return;
		MapView view=(MapView) map.findViewById(R.id.bmapsView);
		pt=new GeoPoint( (int) (arg0.getLatitude()* 1E6),(int)(arg0.getLongitude()* 1E6));	
		Log.e("success",String.valueOf(arg0.getLatitude()));
	//	Log.e("success",String.valueOf(arg0.getDirection()));
		((guide)map ).setGeopoint(pt);
		view.getController().animateTo(pt);
			
	}

	public GeoPoint getPt() {
		return pt;
	}
	@Override
	public void onReceivePoi(BDLocation arg0) {
		// TODO Auto-generated method stub

	}

}
