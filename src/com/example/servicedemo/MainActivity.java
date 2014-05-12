package com.example.servicedemo;

import com.example.servicedemo.service.BindService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button start,stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		start = (Button)findViewById(R.id.btnStartService);
		stop = (Button)findViewById(R.id.btnStopService);

		Log.d("ServiceDemo", "Activity Created");
		//创建启动Service的Intent
		final Intent intent = new Intent();
		//为Intent设置Action属性
		intent.setAction("com.example.servicedemo.FIRST_SERVICE");
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "start Service", Toast.LENGTH_SHORT).show();
				startService(intent);
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "stop Service", Toast.LENGTH_SHORT).show();
				stopService(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
