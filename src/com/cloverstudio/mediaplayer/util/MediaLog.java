package com.cloverstudio.mediaplayer.util;


import android.util.Log;

public class MediaLog {
	private static final String LOGTAG = "clovermediaplayer";
	
	public static void v(String msg) {
		if (MediaConfig.DEBUG) Log.v(LOGTAG, msg);
	}
	
	public static void v(String tag, String msg) {
		if (MediaConfig.DEBUG) Log.v(tag, msg);
	}

	public static void e(String msg) {
		if (MediaConfig.DEBUG) Log.e(LOGTAG, msg);
	}
	
	public static void e(String tag, String msg) {
		if (MediaConfig.DEBUG) Log.e(tag, msg);
	}
}
