package com.example.notifications;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void showToast(View v) {    
        Toast.makeText(getApplicationContext(), "Toast!", Toast.LENGTH_LONG).show();
	}

	public void showCustomToast(View v) {    
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);        
        toast.setView(getLayoutInflater().inflate(R.layout.custom_toast,null));
        toast.show();
	}
	
	public void showDialog(View v) {
		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int which) {
				 switch (which) {
				 case DialogInterface.BUTTON_POSITIVE:
					 Toast.makeText(getApplicationContext(), "Ok!", Toast.LENGTH_LONG).show();
					 break;
				 case DialogInterface.BUTTON_NEGATIVE:
					 Toast.makeText(getApplicationContext(), "Azione annullata",Toast.LENGTH_LONG).show();
					 break;
				 }
			 }
		};
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this); 
		builder.setMessage("Stai per ripartire da capo. Sei sicuro?")
			.setPositiveButton("Si", dialogClickListener) 
			.setNegativeButton("No", dialogClickListener).show();
		
		return;
	}
	
	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	public void showNotification(View v) {
		Notification.Builder notificationBuilder = new Notification.Builder(
				getApplicationContext())
				.setTicker("Messaggio breve")
				.setSmallIcon(R.drawable.pacman_ghost)
				.setAutoCancel(true)
				.setContentTitle("Titolo notifica")
				.setContentText("Testo della notifica");

		// Pass the Notification to the NotificationManager:
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1,notificationBuilder.build());
	}

	public void cancelNotification(View v) {    
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(1);
	}

}
