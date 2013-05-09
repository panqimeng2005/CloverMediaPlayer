package com.cloverstudio.mediaplayer;

import com.cloverstudio.mediaplayer.store.MediaStore;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MediaListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_list_activity);
        
        initView();
    }
    
    private void initView() {
    	Button scanBtn = (Button)findViewById(R.id.scan_btn);
    	scanBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						MediaStore mediaStore = MediaStore.getInstance();
						if (!mediaStore.scanFinished()) {
							mediaStore.startScan();
						}
					}
				}).start();
			}
		});
    }
}
