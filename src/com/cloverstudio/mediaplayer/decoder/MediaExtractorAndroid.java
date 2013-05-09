package com.cloverstudio.mediaplayer.decoder;

import java.io.File;

import com.cloverstudio.mediaplayer.data.MediaInfo;
import com.cloverstudio.mediaplayer.util.MediaLog;

import android.media.MediaMetadataRetriever;


public class MediaExtractorAndroid implements IMediaExtractor {

	private MediaMetadataRetriever mMediaMetadataRetriever;
	
	public MediaExtractorAndroid() {
		mMediaMetadataRetriever = new MediaMetadataRetriever();
	}
	
	@Override
	public void setDataSource(String path) {
		mMediaMetadataRetriever.setDataSource(path);
	}
	
	@Override
	public void setDataSource(File mediaFile) {
		MediaLog.e(null, "setDataSource" + mediaFile.getPath());
		mMediaMetadataRetriever.setDataSource(mediaFile.getPath());
	}
	
	@Override
	public MediaInfo getMediaInfo() {
		MediaInfo info = new MediaInfo();
		info.mName = mMediaMetadataRetriever
				.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
		info.mArtist = mMediaMetadataRetriever
				.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
		info.mAlbum = mMediaMetadataRetriever
				.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
		info.mDuration = mMediaMetadataRetriever
				.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
		return info;
	}

}
