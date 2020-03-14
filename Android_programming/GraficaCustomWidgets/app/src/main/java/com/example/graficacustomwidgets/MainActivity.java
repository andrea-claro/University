package com.example.graficacustomwidgets;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LinearLayout container = (LinearLayout) findViewById(R.id.container);

		CustomWidget cw;
		cw = new CustomWidget(getApplicationContext(),500,100);
		cw.setColor(Color.RED);
		container.addView(cw);	
	    cw = new CustomWidget(getApplicationContext(),500,100);
	    cw.setColor(Color.YELLOW);
	    container.addView(cw);		
	    cw = new CustomWidget(getApplicationContext(),500,100);
	    cw.setColor(Color.BLUE);
	    container.addView(cw);		
	}	
}
