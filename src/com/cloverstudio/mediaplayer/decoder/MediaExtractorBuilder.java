package com.cloverstudio.mediaplayer.decoder;

import java.io.File;

import com.cloverstudio.mediaplayer.data.MediaFile;

public class MediaExtractorBuilder {
	private static IMediaExtractor mMediaExtractorAndroid = new MediaExtractorAndroid();
	
	public static IMediaExtractor getMediaExtractor(File mediaFile) {
		IMediaExtractor extractor = null;
		if (MediaFile.isMediaFileAndroid(mediaFile)) {
			extractor = mMediaExtractorAndroid;
			extractor.setDataSource(mediaFile);
		}
		return extractor;
	}
}
