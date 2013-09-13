package com.example.healthgps;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.healthgps.listview.ActionSlideExpandableListView;
<<<<<<< HEAD
import com.healthgps.listview.SimpleListAdapter;
=======
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;


>>>>>>> 508ba387ad5f880db527ee9b8d9a6c17a7bdd720

public class ListActivity extends Activity {
	 private static final String KEY_TRANSITION_EFFECT = "transition_effect";
	
	
	 SimpleListAdapter listAdapter;
	 private ActionSlideExpandableListView list;
	 private HashMap<String, Integer> mEffectMap;
	 private int mCurrentTransitionEffect = JazzyHelper.HELIX;
	

	@Override
	public void onCreate(Bundle savedData) {
		super.onCreate(savedData);
		this.setContentView(R.layout.single_expandable_list);
	    list = (ActionSlideExpandableListView) this
				.findViewById(R.id.list);
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			array.add(String.valueOf(i));
		}

//		listAdapter = new SimpleListAdapter(this, array);
		setupJazziness(mCurrentTransitionEffect);
		list.setAdapter(buildDummyData());
<<<<<<< HEAD
		list.setItemActionListener(
				new ActionSlideExpandableListView.OnActionClickListener() {
					@Override
					public void onClick(View listView, View buttonview,
							int position) {
						switch (buttonview.getId()) {
						case R.id.buttonA:
							Intent intent = new Intent(ListActivity.this,
									MapViewActivity.class);
							startActivity(intent);
							break;
						case R.id.buttonB:

							break;
						case R.id.buttonC:

							break;
						case R.id.buttonD:

							break;
						}

					}
=======
>>>>>>> 508ba387ad5f880db527ee9b8d9a6c17a7bdd720

        if (savedData != null) {
            mCurrentTransitionEffect = savedData.getInt(KEY_TRANSITION_EFFECT, JazzyHelper.HELIX);
            setupJazziness(mCurrentTransitionEffect);
        }
//		list.setItemActionListener(
//				new ActionSlideExpandableListView.OnActionClickListener() {
//					@Override
//					public void onClick(View listView, View buttonview,
//							int position) {
//						switch (buttonview.getId()) {
//						case R.id.buttonA:
//
//							break;
//						case R.id.buttonB:
//
//							break;
//						case R.id.buttonC:
//
//							break;
//						case R.id.buttonD:
//
//							break;
//						}
//
//					}
//
//					// note that we also add 1 or more ids to the
//					// setItemActionListener
//					// this is needed in order for the listview to discover the
//					// buttons
//				}, R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD);
	}

	/**
	 * Builds dummy data for the test. In a real app this would be an adapter
	 * for your data. For example a CursorAdapter
	 */
	public ArrayAdapter<String> buildDummyData() {
<<<<<<< HEAD
		final int SIZE = 20;
=======
		ArrayList<String> movies = null;

		final int SIZE = 50;
>>>>>>> 508ba387ad5f880db527ee9b8d9a6c17a7bdd720
		String[] values = new String[SIZE];
		for (int i = 0; i < SIZE; i++) {
			values[i] = String.valueOf(i);
		}
		return new ArrayAdapter<String>(this, R.layout.expandable_list_item,
				R.id.movieTitle, values);
	}
	
	private void setupJazziness(int effect) {
        mCurrentTransitionEffect = effect;
        list.setTransitionEffect(mCurrentTransitionEffect);
    }
	
	 @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        outState.putInt(KEY_TRANSITION_EFFECT, mCurrentTransitionEffect);
	    }

}
