package com.healthgps.listview;

import com.twotoasters.jazzylistview.JazzyEffect;
import com.twotoasters.jazzylistview.JazzyHelper;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/**
 * A more specific expandable listview in which the expandable area consist of
 * some buttons which are context actions for the item itself.
 * 
 * It handles event binding for those buttons and allow for adding a listener
 * that will be invoked if one of those buttons are pressed.
 * 
 * @author tjerk
 * @date 6/26/12 7:01 PM
 */
public class ActionSlideExpandableListView extends SlideExpandableListView {
	private OnActionClickListener listener;
	private int[] buttonIds = null;
	private final JazzyHelper mHelper;
	

	public ActionSlideExpandableListView(Context context) {
		super(context);
		mHelper = init(context, null);
	}

	public ActionSlideExpandableListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mHelper = init(context, attrs);
	}

	public ActionSlideExpandableListView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		mHelper = init(context, attrs);
	}
	
	private JazzyHelper init(Context context, AttributeSet attrs) {
        JazzyHelper helper = new JazzyHelper(context, attrs);
        super.setOnScrollListener(helper);
        return helper;
    }

	public void setItemActionListener(OnActionClickListener listener,
			int... buttonIds) {
		this.listener = listener;
		this.buttonIds = buttonIds;
	}

	/**
	 * Interface for callback to be invoked whenever an action is clicked in the
	 * expandle area of the list item.
	 */
	public interface OnActionClickListener {
		/**
		 * Called when an action item is clicked.
		 * 
		 * @param itemView
		 *            the view of the list item
		 * @param clickedView
		 *            the view clicked
		 * @param position
		 *            the position in the listview
		 */
		public void onClick(View itemView, View clickedView, int position);
	}
	
	@Override
    public final void setOnScrollListener(OnScrollListener l) {
        mHelper.setOnScrollListener(l);
    }
	
	public void setTransitionEffect(int transitionEffect) {
        mHelper.setTransitionEffect(transitionEffect);
    }
	
	public void setTransitionEffect(JazzyEffect transitionEffect) {
        mHelper.setTransitionEffect(transitionEffect);
    }
	
	public void setShouldOnlyAnimateNewItems(boolean onlyAnimateNew) {
        mHelper.setShouldOnlyAnimateNewItems(onlyAnimateNew);
    }
	
	 public void setShouldOnlyAnimateFling(boolean onlyFling) {
	        mHelper.setShouldOnlyAnimateFling(onlyFling);
	 }
	 
	 public void setMaxAnimationVelocity(int itemsPerSecond) {
	        mHelper.setMaxAnimationVelocity(itemsPerSecond);
	 }
	 
	 public void setSimulateGridWithList(boolean simulateGridWithList) {
	        mHelper.setSimulateGridWithList(simulateGridWithList);
	        setClipChildren(!simulateGridWithList);
	    }

	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(new WrapperListAdapterImpl(adapter) {

			@Override
			public View getView(final int position, View view,
					ViewGroup viewGroup) {
				final View listView = wrapped
						.getView(position, view, viewGroup);
				// add the action listeners
				if (buttonIds != null && listView != null) {
					for (int id : buttonIds) {
						View buttonView = listView.findViewById(id);
						if (buttonView != null) {
							buttonView.findViewById(id).setOnClickListener(
									new OnClickListener() {
										@Override
										public void onClick(View view) {
											if (listener != null) {
												listener.onClick(listView,
														view, position);
											}
										}
									});
						}
					}
				}
				return listView;
			}
		});
	}
}