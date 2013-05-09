package com.cloverstudio.mediaplayer.store;

import java.io.File;

public interface IMediaLoadListener {
	
	void onLoadFinished();
	void onLoadOccur(File mediaFile);
}
