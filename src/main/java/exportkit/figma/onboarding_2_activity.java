
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		onboarding_2
	 *	@date 		Saturday 27th of August 2022 03:52:01 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class onboarding_2_activity extends Activity {

	
	private View _bg__onboarding_2;
	private ImageView base;
	private TextView next;
	private View oval;
	private View oval_copy;
	private View oval_copy_2;
	private View rectangle;
	private TextView we_carefully_check_e;
	private ImageView illustration;
	private TextView honest_ratings;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_2);

		
		_bg__onboarding_2 = (View) findViewById(R.id._bg__onboarding_2);
		base = (ImageView) findViewById(R.id.base);
		next = (TextView) findViewById(R.id.next);
		oval = (View) findViewById(R.id.oval);
		oval_copy = (View) findViewById(R.id.oval_copy);
		oval_copy_2 = (View) findViewById(R.id.oval_copy_2);
		rectangle = (View) findViewById(R.id.rectangle);


		/**
		 * Свайп вправо
		 */

		findViewById(R.id.onboarding_2).setOnTouchListener(new OnSwipeTouchListener(onboarding_2_activity.this) {

			public void onSwipeRight() {
				Intent intent = new Intent(getApplicationContext(), onboarding_1_activity.class);
				startActivity(intent);
			}
		});
	
	}
}
	
	