package com.healthgps.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.healthgps.R;
import com.example.healthgps.R.id;
import com.example.healthgps.R.layout;

public class SimpleListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<String> data;
	private static LayoutInflater inflater = null;

	public SimpleListAdapter(Activity a, ArrayList<String> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, final ViewGroup parent) {
		View listView;
		TextView movieTitle = null;
		TextView movieDirector = null;
		if (convertView == null) {

			listView = inflater.inflate(R.layout.expandable_list_item, null);

			if (data != null) {
				movieTitle = (TextView) listView.findViewById(R.id.movieTitle);
				movieTitle.setText("\"" + data.get(position) + "\"");
				movieDirector = (TextView) listView
						.findViewById(R.id.movieDirector);
				movieDirector.setText(data.get(position));
			}

		} else {
			listView = (LinearLayout) convertView;
			movieTitle = (TextView) listView.findViewById(R.id.movieTitle);
		}

		return listView;
	}

}