package com.example.graficaimganim;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView earthImageView;
	private Animation[] animations = new Animation[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		
		earthImageView = (ImageView) findViewById(R.id.earth);
		
		animations[0] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.test);
		animations[1] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.traslazione);
		animations[2] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
		animations[3] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trasparenza);
		animations[4] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.combo);
		}
	
	/*
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			earthImageView.startAnimation(animation);
		}
	}
	*/
	public void button_animation_rotazione(View v) {
		earthImageView.startAnimation(animations[0]);
	}
	
	public void button_animation_traslazione(View v) {
		earthImageView.startAnimation(animations[1]);
	}

	public void button_animation_scaling(View v) {
		earthImageView.startAnimation(animations[2]);
	}

	public void button_animation_trasparenza(View v) {
		earthImageView.startAnimation(animations[3]);
	}

	public void button_animation_combo(View v) {
		earthImageView.startAnimation(animations[4]);
	}

}
