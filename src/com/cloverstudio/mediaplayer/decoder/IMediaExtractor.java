package com.cloverstudio.mediaplayer.decoder;

import java.io.File;

import com.cloverstudio.mediaplayer.data.MediaInfo;

public interface IMediaExtractor {
	
	void setDataSource(String path);
	void setDataSource(File mediaFile);
	MediaInfo getMediaInfo();
}
