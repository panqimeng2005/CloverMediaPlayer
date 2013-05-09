package com.cloverstudio.mediaplayer.data;

import java.io.File;

class MediaFileMap {
	String mSuffix;
	String mExtractor;
	MediaFileMap(String suffix, String extractor) {
		mSuffix = suffix;
		mExtractor = extractor;
	}
}

public class MediaFile {
	private static MediaFileMap[] mMediaFilesAndroid = {
		new MediaFileMap("mp3", null),
		new MediaFileMap("aac", null),
	};
	
	private static MediaFileMap[] mMediaFilesExternal = {
		new MediaFileMap("ape", null),
	};

	public static boolean isMediaFileAndroid(File mediaFile) {
		return isMediaFile(mediaFile.getName(), mMediaFilesAndroid);
	}
	
	public static boolean isMediaFileAndroid(String filename) {
		return isMediaFile(filename, mMediaFilesAndroid);
	}
	
	public static boolean isMediaFileExternal(File mediaFile) {
		return isMediaFile(mediaFile.getName(), mMediaFilesExternal);
	}
	
	public static boolean isMediaFileExternal(String filename) {
		return isMediaFile(filename, mMediaFilesExternal);
	}
		
	private static boolean isMediaFile(String filename, MediaFileMap[] mediaFiles) {
		boolean bRet = false;
		for (MediaFileMap item : mediaFiles) {
			if (filename.endsWith("." + item.mSuffix)) {
				bRet = true;
				break;
			}
		}
		return bRet;
	}
}
