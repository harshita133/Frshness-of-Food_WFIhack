package com.developer.harshi.teamarjuna;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final int CAMERA_REQUEST = 1888;
        Button btnSensor = (Button) findViewById(R.id.btnSensor);
        Button btnDip = (Button) findViewById(R.id.btnDIP);
        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SensorDataInput.class);
                startActivity(i);
            }
        });

        btnDip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Intent i = new Intent (MainActivity.this,CameraActivity.class);
//                startActivity(i);
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
           // imageView.setImageBitmap(photo);
        }
    }
}
