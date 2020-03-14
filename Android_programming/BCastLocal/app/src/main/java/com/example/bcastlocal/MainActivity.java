package com.example.bcastlocal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	BroadcastReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		setBroadcastReceiver();
	}
	
	public void sendBroadcast(View v) {
		sendBroadcast(new Intent(".bcastlocal.my_string"));
	}
	
	private void setBroadcastReceiver() {
		IntentFilter intentFilter = 
				new IntentFilter(".bcastlocal.my_string");

		receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Log.d("DEBUG", "dynamically registered receiver");
				Toast.makeText(context, 
						   "Intent received by the dynamically registered receiver", 
						   Toast.LENGTH_LONG).show();

			}
		};
		
		registerReceiver(receiver, intentFilter);
	}


}
