package com.example.healthgps;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class SimpleMapActivity extends FragmentActivity  {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		/*MapView mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(true);
        
        MapController mc = mapView.getController();
        double lat = Double.parseDouble("48.85827758964043"); // latitude
        double lon = Double.parseDouble("2.294543981552124"); // longitude
        GeoPoint geoPoint = new GeoPoint((int)(lat * 1E6), (int)(lon * 1E6));
        mc.animateTo(geoPoint);
        mc.setZoom(15);
        mapView.invalidate(); */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
/*
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}*/

	
}
