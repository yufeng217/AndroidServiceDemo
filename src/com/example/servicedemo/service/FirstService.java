package com.example.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	/**
	 * 必须实现的方法
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Service is Binded");
		Log.d("ServiceDemo", "Service is Binded");
		return null;
	}

	/**
	 * Service被创建时回调该方法
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// System.out.println("Service is Created");
		Log.d("ServiceDemo", "Service is Created");
	}

	/**
	 * Service 被关闭之前回调
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("ServiceDemo", "Service is Destroyed");
	}

	/**
	 * Service被启动时回调该方法
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("ServiceDemo", "Service is Started");
		return super.onStartCommand(intent, flags, startId);
	}

}
