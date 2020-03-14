package com.example.graficashapeprog;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	int trasparenza = 127;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		int width = (int) getResources().getDimension(R.dimen.image_width);
		int height = (int) getResources().getDimension(R.dimen.image_height);
		int padding = (int) getResources().getDimension(R.dimen.image_padding);
	
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.main_window);

		/*
		 * CERCHIO
		 */
		
		// Creiamo il cerchio
		ShapeDrawable cerchio = new ShapeDrawable(new OvalShape());
		cerchio.getPaint().setColor(Color.RED);
		cerchio.setIntrinsicHeight(height);
		cerchio.setIntrinsicWidth(width);
		cerchio.setAlpha(trasparenza);

		// Inseriamolo in un ImageView
		ImageView viewCerchio = new ImageView(getApplicationContext());
		viewCerchio.setImageDrawable(cerchio);
		viewCerchio.setPadding(padding, padding, padding, padding);

		// Parametri per posizionare l'ImageView nel RelativeLayout
		RelativeLayout.LayoutParams viewCerchioLayoutParams = new RelativeLayout.LayoutParams(
				height, width);
		viewCerchioLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		viewCerchioLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		viewCerchio.setLayoutParams(viewCerchioLayoutParams);
		
		//Aggiungiamo la view all'interno della main_window
		rl.addView(viewCerchio);
		
		/*
		 * QUADRATO
		 */
		
		// Creiamo il quadrato
		ShapeDrawable quadrato = new ShapeDrawable(new RectShape());
		quadrato.getPaint().setColor(Color.GREEN);
		quadrato.setIntrinsicHeight(height);
		quadrato.setIntrinsicWidth(width);
		quadrato.setAlpha(trasparenza);

		// Inseriamolo in un ImageView
		ImageView viewQuadrato = new ImageView(getApplicationContext());
		viewQuadrato.setImageDrawable(quadrato);
		viewQuadrato.setPadding(padding, padding, padding, padding);

		// Parametri per posizionare l'ImageView nel RelativeLayout
		RelativeLayout.LayoutParams viewQuadratoLayoutParams = new RelativeLayout.LayoutParams(
				height, width);
		viewQuadratoLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		viewQuadratoLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		viewQuadrato.setLayoutParams(viewQuadratoLayoutParams);
		
		//Aggiungiamo la view all'interno della main_window
		rl.addView(viewQuadrato);

	}
}