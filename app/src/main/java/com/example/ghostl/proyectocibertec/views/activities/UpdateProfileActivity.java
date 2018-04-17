package com.example.ghostl.proyectocibertec.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.ghostl.proyectocibertec.BuildConfig;
import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.utils.ScaleUtilities;
import com.example.ghostl.proyectocibertec.utils.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateProfileActivity extends AppCompatActivity {

    
    private int REQUEST_CAMERA = 200;
    private int SELECT_FILE = 300;
    private String imageUri = "imageUri";
    private String mCurrentPhotopath = "";
    CircleImageView mPhotoPicker;
    Toolbar mToolbar;
    Button mButtonOk, mButtonCancel;
    SharedPreferences permissionStatus;
    boolean sentToSettings = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        initObject();

        mPhotoPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Util.checkPermission(UpdateProfileActivity.this, permissionStatus, sentToSettings)){
                    cameraIntent();
                }

            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void cameraIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri imageUri;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            imageUri = new FileProvider().getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", createImageFile());
        }else{
            imageUri = Uri.fromFile(createImageFile());
        }

        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, REQUEST_CAMERA);

    }

    private File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String imageFilename = timeStamp;

        File directory = new File(Environment.getExternalStorageDirectory(), getString(R.string.folder_name));
        if(!directory.exists()){
            directory.mkdirs();
        }
        File storageDir = Environment.getExternalStoragePublicDirectory(getString(R.string.folder_name));

        File image = null;
        try {
            image = File.createTempFile(imageFilename, /*Prefix*/
                    ".jpg", /*suffix */
                    storageDir);/*Directory*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        mCurrentPhotopath = image.getAbsolutePath();

        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CAMERA){
                onCaptureImageResult();
            }
        }
    }

    private void onCaptureImageResult() {

        Options bmOptions = new Options();
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inPurgeable = false;
        Log.d("Image Path", mCurrentPhotopath);
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotopath, bmOptions);

        Bitmap scaledBitmap = ScaleUtilities.createScaleBitmap(bitmap, 800, 600, ScaleUtilities.ScalingLogic.CROP.CROP);

        saveAndDeleteImageResize(scaledBitmap);

        Glide.with(this)
                .load(scaledBitmap)
                .thumbnail(0.1f)
                .into(mPhotoPicker);


    }

    private void saveAndDeleteImageResize(Bitmap scaledBitmap) {
        File file = new File(mCurrentPhotopath);

        if(file.exists()){
            file.delete();
        }
        try{
            FileOutputStream out = new FileOutputStream(file);
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        }catch (Exception ex){
            Log.e("Error", "/"+ ex.getMessage());
        }


    }

    private void initObject() {
        mPhotoPicker = findViewById(R.id.photoPicker);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mButtonCancel = findViewById(R.id.bCancel);
        mButtonOk = findViewById(R.id.bConfirm);
        permissionStatus = getSharedPreferences("permissionStatus", MODE_PRIVATE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
