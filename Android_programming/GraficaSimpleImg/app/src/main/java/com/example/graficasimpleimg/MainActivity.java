package com.example.graficasimpleimg;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		
		RelativeLayout mainframe = (RelativeLayout) findViewById(R.id.mainframe);
	
		
		ImageView globoImageView = new ImageView(getApplicationContext());
		
		globoImageView.setImageDrawable(getResources().getDrawable(R.drawable.earth));
		
		int width  = (int) getResources().getDimension(R.dimen.image_width);
		int height = (int) getResources().getDimension(R.dimen.image_height);
		
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width,height);
		lp.addRule(RelativeLayout.CENTER_VERTICAL);
		lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		globoImageView.setBackgroundColor(Color.RED);
		globoImageView.setLayoutParams(lp);
		
		mainframe.addView(globoImageView);
	
	}
}
