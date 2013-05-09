package com.cloverstudio.mediaplayer.store;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.cloverstudio.mediaplayer.data.MediaFile;
import com.cloverstudio.mediaplayer.util.MediaLog;

import android.os.Environment;

public class MediaScanner {
	
	private static final File DEFAULT_ROOT = Environment.getExternalStorageDirectory();
	
	private List<IMediaScanListener> mMediaScanListener;
	
	private FileFilter mSuffixFilter = new FileFilter() {

		@Override
		public boolean accept(File file) {
			return suffixAccept(file);
		}

	};
	
	public MediaScanner() {
		mMediaScanListener = new ArrayList<IMediaScanListener>();
	}
	
	public void startScan() {
		listMediaFromPath(DEFAULT_ROOT);
		notifyScanFinished();
	}
	
	private void listMediaFromPath(File root) {
	    File[] mediaFiles = root.listFiles(mSuffixFilter);
	    for (int i = 0; mediaFiles != null && i < mediaFiles.length; i++) {
	        File file = mediaFiles[i];
	        if (file.isDirectory()) {
	        	listMediaFromPath(file);
	        } else {
	        	notifyScanOccur(file);
	        }
	    } 
	}
	
	private boolean suffixAccept(File file) {
		return file.isDirectory()
				|| MediaFile.isMediaFileAndroid(file.getName()) 
				|| MediaFile.isMediaFileExternal(file.getName());
	}
	
	public void registerMediaScanListener(IMediaScanListener l) {
		if (!mMediaScanListener.contains(l)) {
			mMediaScanListener.add(l);
		}
	}
	
	public void unregisterMediaScanListener(IMediaScanListener l) {
		mMediaScanListener.remove(l);
	}
	
	private void notifyScanFinished() {
		MediaLog.e("notifyScanFinished()->");
		for (IMediaScanListener l : mMediaScanListener) {
			l.onScanFinished();
		}
	}
	
	private void notifyScanOccur(File file) {
		MediaLog.v("notifyScanOccur()-> path = " + file.getPath());
		MediaLog.v("notifyScanOccur()-> name = " + file.getName());
		for (IMediaScanListener l : mMediaScanListener) {
			l.onScanOccur(file);
		}
	}
}
