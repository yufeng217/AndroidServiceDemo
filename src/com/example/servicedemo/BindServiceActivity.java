package com.example.servicedemo;

import com.example.servicedemo.service.BindService;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceActivity extends Activity {

	private String logTag = "BindService";

	Button btnBind, btnUnBind, btnGetServiceState;
	// ������������Service��IBinder����
	BindService.MyBinder myBinder;
	// ����һ��ServiceConnection����
	private ServiceConnection conn = new ServiceConnection() {

		/**
		 * ����Activity��Service���ӳɹ�ʱ�ص��÷���
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d(logTag, "--Service Connected--");
			// ��ȡService��onBind���������ص�MyBinder����
			myBinder = (BindService.MyBinder) service;
		}

		/**
		 * ����Activity��Service�Ͽ�����ʱ�ص��÷���
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d(logTag, "--Service Disconnected--");
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bind_service);

		btnBind = (Button) findViewById(R.id.btnBind);
		btnUnBind = (Button) findViewById(R.id.btnUnBind);
		btnGetServiceState = (Button) findViewById(R.id.btnGetServiceState);
		// ��������Service��Intent
		final Intent intent = new Intent(this,BindService.class);
		//intent.setAction("com.example.servicedemo.BIND_SERVICE");

		btnBind.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ��ָ����Service
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});

		btnUnBind.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unbindService(conn);
			}
		});

		btnGetServiceState.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Service��countֵ��" + myBinder.getCount(),
						Toast.LENGTH_LONG).show();
				
				Log.d(logTag, "Service��countֵ��" + myBinder.getCount());
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bind, menu);
		return true;
	}

}
