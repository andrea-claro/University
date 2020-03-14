package com.example.bcastglobal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	BroadcastReceiver receiver;
	TextView tv;
	int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setBroadcastReceiver();
		tv = (TextView) findViewById(R.id.textView);
	}
	
	@Override
	protected void onDestroy() {
	  super.onDestroy();
	  unregisterReceiver(receiver);
	}
	
	private void setBroadcastReceiver() {
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);

		receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Log.d("DEBUG","Hello, another minute is gone!!!");
				counter++;
				tv.setText(counter+" minuti");
			}
		};
		
		registerReceiver(receiver, intentFilter);
	}
}
