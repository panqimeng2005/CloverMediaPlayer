package com.cloverstudio.mediaplayer.store;

public interface IMediaStoreDevice extends IMediaScanListener {
	void startLoad();
	void registerMediaLoadListener(IMediaLoadListener l);
	void unregisterMediaLoadListener(IMediaLoadListener l);
}
