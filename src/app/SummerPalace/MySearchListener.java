package app.SummerPalace;

import android.app.Activity;

import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.RouteOverlay;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MySearchListener implements MKSearchListener {
	
	Activity map=null;
	GeoPoint pt=null;
	public MySearchListener(Activity map) {
		// TODO Auto-generated constructor stub
		this.map=map;
	}
	public GeoPoint getPt() {
		return pt;
	}
	@Override
	public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
		// TODO Auto-generated method stub
		MapView view=(MapView)map.findViewById(R.id.bmapsView);
		pt=arg0.geoPt;
		((guide)map).setGeopoint2(pt);
		view.getController().animateTo(arg0.geoPt);
		((guide)map).findway();
	}

	@Override
	public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub
		MapView view=(MapView)map.findViewById(R.id.bmapsView);
		 RouteOverlay routeOverlay = new RouteOverlay(map,view);  // 此处仅展示一个方案作为示例  
	        routeOverlay.setData(arg0.getPlan(0).getRoute(0));  
	        view.getOverlays().add(routeOverlay);     
	        view.refresh();  
	}

	@Override
	public void onGetPoiDetailSearchResult(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetPoiResult(MKPoiResult arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetShareUrlResult(MKShareUrlResult arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub
		MapView view=(MapView)map.findViewById(R.id.bmapsView);
		 RouteOverlay routeOverlay = new RouteOverlay(map,view);  // 此处仅展示一个方案作为示例  
	        routeOverlay.setData(arg0.getPlan(0).getRoute(0));  
	        view.getOverlays().add(routeOverlay);     
	        view.refresh();  
	}

}
