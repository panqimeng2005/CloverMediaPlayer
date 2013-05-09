package com.cloverstudio.mediaplayer.store;

public class MediaStoreDeviceBuilder {
	
	private static IMediaStoreDevice mMediaStoreDevice = new DatabaseMediaStoreDevice();
	
	static IMediaStoreDevice getMediaStoreDevice() {
		return mMediaStoreDevice;
	}
}
