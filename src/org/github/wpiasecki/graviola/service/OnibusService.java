package org.github.wpiasecki.graviola.service;

import org.github.wpiasecki.graviola.util.Logger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OnibusService extends Service {

	Logger log = new Logger(this);
	
	@Override
	public IBinder onBind(Intent intent) {
		log.d("onBind " + intent);
		return null;
	}

	@Override
	public void onCreate() {
		log.d("onCreate");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		log.d("onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		log.d("onStartCommand " + intent + " -> " + flags + " -> " + startId);
		return super.onStartCommand(intent, flags, startId);
	}

}
