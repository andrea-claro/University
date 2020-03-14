package com.example.threadno;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

	private ImageView imageView;
	private TextView counterTextView;
	private int index = 1;
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		imageView = (ImageView)findViewById(R.id.imageView);
		counterTextView = (TextView)findViewById(R.id.counterTextView);
	}
	
	public void loadButtonPressed(View v) {
		/* Ritardo di 8 secondi */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/* procediamo */
		Bitmap bmap = null;
		switch(index) {
		case 1:
			bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
			index = 2;
			break;
		case 2:
			bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
			index = 3;
			break;
		case 3:
			bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image3);
			index = 1;
			break;
		}
		imageView.setImageBitmap(bmap);
	}
	
	public void counterButtonPressed(View v) {
		counter++;
		counterTextView.setText(""+counter);
	}
}
