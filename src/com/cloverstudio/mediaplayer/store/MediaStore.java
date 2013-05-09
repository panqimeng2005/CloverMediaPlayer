package com.cloverstudio.mediaplayer.store;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cloverstudio.mediaplayer.data.CategoryInfo;

public class MediaStore implements IMediaLoadListener, IMediaScanListener{
	@SuppressWarnings("unused")
	private static final String TAG = "MediaStore ";
	
	public static final int CATEGORY_ALL = 0;
	public static final int CATEGORY_ARTIST = 1;
	public static final int CATEGORY_FOLDER = 2;
	
	List<CategoryInfo> mAllCategoryInfos;
	List<CategoryInfo> mArtistCategoryInfos;
	List<CategoryInfo> mFolderCategoryInfos;
	
	boolean mScanFinished;
	boolean mLoadFinished;
	
	MediaScanner mMediaScanner;
	IMediaStoreDevice mMediaStoreDevice;
	
	
	private static MediaStore mInstance = new MediaStore();
	public static MediaStore getInstance() {
		return mInstance;
	}
	
	private MediaStore() {
		mAllCategoryInfos = new ArrayList<CategoryInfo>();
		mArtistCategoryInfos = new ArrayList<CategoryInfo>();
		mFolderCategoryInfos = new ArrayList<CategoryInfo>();
		
		mMediaScanner = new MediaScanner();
		mMediaStoreDevice = MediaStoreDeviceBuilder.getMediaStoreDevice();
		mMediaScanner.registerMediaScanListener(mMediaStoreDevice);
	}
	

	public void startScan() {
		mMediaScanner.startScan();
		mScanFinished = true;
	}
	

	public boolean scanFinished() {
		return mScanFinished;
	}
	

	public void startLoad() {
		mMediaStoreDevice.startLoad();
		mLoadFinished = true;
	}
	

	public boolean loadFinished() {
		return mLoadFinished;
	}
	

	public List<CategoryInfo> getCategoryInfos(int category) {
		List<CategoryInfo> ret = null;
		switch (category) {
		case CATEGORY_ALL:
			ret = mAllCategoryInfos;
			break;
		case CATEGORY_ARTIST:
			ret = mArtistCategoryInfos;
			break;
		case CATEGORY_FOLDER:
			ret = mFolderCategoryInfos;
			break;
		default:
			break;
		}
		return ret;
	}


	public IMediaStoreDevice getMediaStoreDevice() {
		return mMediaStoreDevice;
	}
	
	public MediaScanner getMediaScanner() {
		return mMediaScanner;
	}

	@Override
	public void onScanFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScanOccur(File mediaFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadOccur(File mediaFile) {
		// TODO Auto-generated method stub
		
	}
}
