package com.example.user.infoandpicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String MAIN_ACTIVITY_EXTRA ="com.example.user.infoandpicture.MAIN_ACTIVITY_EXTRA";
    ImageView imageV;
    EditText  name;
    EditText lastName;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         imageV = (ImageView)findViewById(R.id.imageView);
         name = (EditText) findViewById(R.id.nameId);
         lastName = (EditText)findViewById(R.id.lastNameId);

    }


    public void takeAPics(View view) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageV.setImageBitmap(imageBitmap);
        }
    }

    public void sendInfo(View view) {


        String nameValue = name.getText().toString();
        String lastNameValue = lastName.getText().toString();

        Entry user = new Entry(nameValue,lastNameValue, imageBitmap);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, user);
        startActivity(intent);

    }
}
