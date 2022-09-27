
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		onboarding_1
	 *	@date 		Saturday 27th of August 2022 03:48:14 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.figma;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebView;

import androidx.navigation.Navigation;

import java.util.Calendar;


	public class onboarding_1_activity extends Activity {

	
	private View _bg__onboarding_1;
	private ImageView base;
	private TextView next;
	private View button_next;
	private View oval;
	private View oval_copy;
	private View oval_copy_2;
	private View rectangle;
	private View content_container;
	private EditText editTextTextPersonName;
	private TextView proven_specialists;
	private ControllerSqlLite dbSQL;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_1);
		Intent intent = getIntent();

		
		_bg__onboarding_1 = (View) findViewById(R.id._bg__onboarding_1);
		content_container = (View) findViewById(R.id.content_container);
		base = (ImageView) findViewById(R.id.base);
		next = (TextView) findViewById(R.id.next);
		button_next = (View) findViewById(R.id.button_next);
		oval = (View) findViewById(R.id.oval);
		oval_copy = (View) findViewById(R.id.oval_copy);
		oval_copy_2 = (View) findViewById(R.id.oval_copy_2);
		rectangle = (View) findViewById(R.id.rectangle);
		editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
		proven_specialists = (TextView) findViewById(R.id.proven_specialists);

		dbSQL = new ControllerSqlLite(getApplicationContext());

		WebView web= (WebView)findViewById(R.id.webContainer);
		web.setWebChromeClient(new WebChromeClient());
		web.getSettings().setJavaScriptEnabled(true);
		//web.loadUrl("file:///android_asset/www/index.html");
		web.loadUrl("http://188.225.42.19:8080/");

		//получаем данные из таблицы

		Cursor newtable = dbSQL.getTable(1);
		editTextTextPersonName.setText(newtable.getString(0));

		/**
		 * Кнопка next
		 */
		button_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


				//если есть строки
				if (newtable != null) {

					// идем на первую строку
					newtable.moveToFirst();


					//получаем значения ФИО, Должности и Телефона и присваиваем их нашим= полям
					dbSQL.updateTable(1, editTextTextPersonName.getText().toString());


				}
			}
		});

		/**
		 * Свайп вправо
		 */

		findViewById(R.id.onboarding_1).setOnTouchListener(new OnSwipeTouchListener(onboarding_1_activity.this) {

			public void onSwipeLeft() {
				Intent intent = new Intent(getApplicationContext(), onboarding_2_activity.class);
				startActivity(intent);
			}
		});
	
	}

}
	
	