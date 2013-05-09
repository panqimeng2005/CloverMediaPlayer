package com.cloverstudio.mediaplayer.store;

import java.io.File;

public interface IMediaScanListener {

	void onScanFinished();
	void onScanOccur(File mediaFile);
}
