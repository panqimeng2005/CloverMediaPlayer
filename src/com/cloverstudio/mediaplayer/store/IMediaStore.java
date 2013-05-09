package com.cloverstudio.mediaplayer.store;

import java.util.List;

import com.cloverstudio.mediaplayer.data.CategoryInfo;

public interface IMediaStore {

	void startScan();
	void startLoad();
	boolean scanFinished();
	boolean loadFinished();
	List<CategoryInfo> getCategoryInfos(int category);
	void registerMediaStoreChangedListener(IMediaLoadListener l);
	void unregisterMediaStoreChangedListener(IMediaLoadListener l);
}
