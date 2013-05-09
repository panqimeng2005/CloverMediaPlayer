package com.cloverstudio.mediaplayer.store;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

abstract public class AbstractMediaStoreDevice implements IMediaStoreDevice {

	private List<IMediaLoadListener> mMediaLoadListeners;
	
	protected AbstractMediaStoreDevice() {
		mMediaLoadListeners = new ArrayList<IMediaLoadListener>();
	}
	
	@Override
	public void registerMediaLoadListener(IMediaLoadListener l) {
		if (!mMediaLoadListeners.contains(l)) {
			mMediaLoadListeners.add(l);
		}
	}

	@Override
	public void unregisterMediaLoadListener(IMediaLoadListener l) {
		mMediaLoadListeners.remove(l);
	}

	protected void notifyOnLoadOccur(File mediaFile) {
		for (IMediaLoadListener l : mMediaLoadListeners) {
			l.onLoadOccur(mediaFile);
		}
	}
	
	protected void notifyOnLoadFinished() {
		for (IMediaLoadListener l : mMediaLoadListeners) {
			l.onLoadFinished();
		}
	}
}
