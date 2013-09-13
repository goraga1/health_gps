package com.example.healthgps;
 
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
@SuppressWarnings("deprecation")
public class TabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabview);
         
        TabHost tabHost = getTabHost();
         
        // Tab for Object list
        TabSpec listTab = tabHost.newTabSpec("Photos");        
        listTab.setIndicator("List", getResources().getDrawable(R.drawable.list));
        Intent photosIntent = new Intent(this, ListActivity.class);
        listTab.setContent(photosIntent);
         
        // Tab for Maps
        TabSpec mapTab = tabHost.newTabSpec("Map");        
        mapTab.setIndicator("Map", getResources().getDrawable(R.drawable.map));
        Intent songsIntent = new Intent(this, SimpleMapActivity.class);
        mapTab.setContent(songsIntent);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(listTab); // Adding photos tab
        tabHost.addTab(mapTab); // Adding songs tab
    }
}