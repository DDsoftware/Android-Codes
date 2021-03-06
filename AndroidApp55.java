<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
� � xmlns:tools="http://schemas.android.com/tools"
� � android:layout_width="match_parent"
� � android:layout_height="match_parent"
� � tools:context=".MainActivity">

� � <VideoView
� � � � android:layout_width="wrap_content"
� � � � android:layout_height="wrap_content"
� � � � android:id="@+id/buckysVideoView" />
</RelativeLayout>


MainActivity.java
package com.thenewboston.videoplayer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends ActionBarActivity {

� � @Override
� � protected void onCreate(Bundle savedInstanceState) {
� � � � super.onCreate(savedInstanceState);
� � � � setContentView(R.layout.activity_main);

� � � � final VideoView buckysVideoView = (VideoView) findViewById(R.id.buckysVideoView);
� � � � buckysVideoView.setVideoPath("https://www.thenewboston.com/forum/project_files/006_testVideo.mp4");

� � � � //Player controls(play, pause, stop, etc...)
� � � � MediaController mediaController = new MediaController(this);
� � � � mediaController.setAnchorView(buckysVideoView);
� � � � buckysVideoView.setMediaController(mediaController);

� � � � buckysVideoView.start();
� � }

}