package com.example.user.infoandpicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView name;
    TextView lastName;
    ImageView image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        if(intent != null){

            String nam, last;
            Bitmap image;

            Entry sameUser = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);

            name = (TextView) findViewById(R.id.nameId2);
            lastName = (TextView) findViewById(R.id.lastNameId2);
            image2 = (ImageView) findViewById(R.id.imagev2);


            nam = sameUser.getFirstName();
            last = sameUser.getLastName();
            image = sameUser.getPicture();

            name.setText(nam);
            lastName.setText(last);
            image2.setImageBitmap(image);


        }
    }
}
