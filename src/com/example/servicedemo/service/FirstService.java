package com.example.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	/**
	 * ����ʵ�ֵķ���
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Service is Binded");
		Log.d("ServiceDemo", "Service is Binded");
		return null;
	}

	/**
	 * Service������ʱ�ص��÷���
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// System.out.println("Service is Created");
		Log.d("ServiceDemo", "Service is Created");
	}

	/**
	 * Service ���ر�֮ǰ�ص�
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("ServiceDemo", "Service is Destroyed");
	}

	/**
	 * Service������ʱ�ص��÷���
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("ServiceDemo", "Service is Started");
		return super.onStartCommand(intent, flags, startId);
	}

}
