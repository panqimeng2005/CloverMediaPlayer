package com.cloverstudio.mediaplayer.store;

import java.io.File;

import com.cloverstudio.mediaplayer.data.MediaInfo;
import com.cloverstudio.mediaplayer.decoder.IMediaExtractor;
import com.cloverstudio.mediaplayer.decoder.MediaExtractorBuilder;
import com.cloverstudio.mediaplayer.util.MediaLog;

public class DatabaseMediaStoreDevice extends AbstractMediaStoreDevice {

	@Override
	public void startLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScanFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScanOccur(File mediaFile) {
		IMediaExtractor extractor = MediaExtractorBuilder.getMediaExtractor(mediaFile);
		MediaInfo info = extractor.getMediaInfo();
		MediaLog.e(null, "=============================");
		MediaLog.e(null, "Name = " + info.mName);
		MediaLog.e(null, "Duration = " + info.mDuration);
		MediaLog.e(null, "Artist = " + info.mArtist);
		MediaLog.e(null, "Album = " + info.mAlbum);
	}
	
}
