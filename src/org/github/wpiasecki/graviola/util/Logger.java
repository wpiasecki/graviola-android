package org.github.wpiasecki.graviola.util;

import android.util.Log;

public class Logger {

	private String tag;
	
	public Logger(Object o) { tag = o.getClass().getSimpleName(); }
	
	public int 	d(String msg) { return Log.d(tag, msg); }
	public int 	d(String msg, Throwable tr) { return Log.d(tag, msg, tr); }
	
	public int 	e(String msg) { return Log.e(tag, msg); }
	public int 	e(String msg, Throwable tr) { return Log.e(tag, msg, tr); }
	public String 	getStackTraceString(Throwable tr) { return Log.getStackTraceString(tr); }
	public int 	i(String msg) { return Log.i(tag, msg); }
	public int 	i(String msg, Throwable tr) { return Log.i(tag, msg, tr); }
	public boolean 	isLoggable(int level) { return Log.isLoggable(tag, level); }
	public int 	println(int priority, String msg) { return Log.println(priority, tag, msg); }
	public int 	v(String msg) { return Log.v(tag, msg); }
	public int 	v(String msg, Throwable tr) { return Log.v(tag, msg, tr); }
	public int 	w(Throwable tr) { return Log.w(tag, tr); }
	public int 	w(String msg, Throwable tr) { return Log.w(tag, msg, tr); }
	public int 	w(String msg) { return Log.w(tag, msg); }
	public int 	wtf(Throwable tr) { return Log.wtf(tag, tr); }
	public int 	wtf(String msg) { return Log.wtf(tag, msg); }
	public int 	wtf(String msg, Throwable tr) { return Log.wtf(tag, msg, tr); }
	
}
