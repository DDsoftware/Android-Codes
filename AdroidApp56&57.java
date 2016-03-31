//activity_main.xml

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
� � xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
� � android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
� � android:paddingRight="@dimen/activity_horizontal_margin"
� � android:paddingTop="@dimen/activity_vertical_margin"
� � android:paddingBottom="@dimen/activity_vertical_margin" tools:context=".MainActivity">

� � <Button
� � � � android:layout_width="wrap_content"
� � � � android:layout_height="wrap_content"
� � � � android:text="Take Photo"
� � � � android:id="@+id/buckysButton"
� � � � android:layout_alignParentBottom="true"
� � � � android:layout_centerHorizontal="true"
� � � � android:layout_marginBottom="72dp"
� � � � android:onClick="launchCamera" />

� � <ImageView
� � � � android:layout_width="wrap_content"
� � � � android:layout_height="wrap_content"
� � � � android:id="@+id/buckysImageView"
� � � � android:layout_alignParentTop="true"
� � � � android:layout_centerHorizontal="true"
� � � � android:layout_marginTop="50dp"
� � � � android:minHeight="300dp"
� � � � android:minWidth="300dp" />
</RelativeLayout>


//MainActivity.java
package com.thenewboston.takephoto;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

� � static final int REQUEST_IMAGE_CAPTURE = 1;
� � ImageView buckysImageView;

� � @Override
� � protected void onCreate(Bundle savedInstanceState) {
� � � � super.onCreate(savedInstanceState);
� � � � setContentView(R.layout.activity_main);

� � � � Button buckyButton = (Button) findViewById(R.id.buckysButton);
� � � � buckysImageView = (ImageView) findViewById(R.id.buckysImageView);

� � � � //Disable the button if the user has no camera
� � � � if(!hasCamera())
� � � � � � buckyButton.setEnabled(false);
� � }

� � //Check if the user has a camera
� � private boolean hasCamera(){
� � � � return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
� � }

� � //Launching the camera
� � public void launchCamera(View view){
� � � � Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
� � � � //Take a picture and pass results along to onActivityResult
� � � � startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
� � }

� � //If you want to return the image taken
� � @Override
� � protected void onActivityResult(int requestCode, int resultCode, Intent data) {
� � � � if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
� � � � � � //Get the photo
� � � � � � Bundle extras = data.getExtras();
� � � � � � Bitmap photo = (Bitmap) extras.get("data");
� � � � � � buckysImageView.setImageBitmap(photo);
� � � � }
� � }

}