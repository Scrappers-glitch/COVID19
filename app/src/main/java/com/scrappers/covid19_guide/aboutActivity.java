package com.scrappers.covid19_guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class aboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
    }

    public void runSocials(String socialLink){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(socialLink)));
    }

    public void gmail(View view){
        runSocials("https://mail.google.com/mail/u/0/#inbox");
    }


    public void facebook_fady(View view){
        runSocials("https://www.facebook.com/fady.nashat126");
    }
    public void facebook_pavly(View view){
        runSocials("https://www.facebook.com/JavaScrappers");
    }
    public void facebook_Thomas(View view){
        runSocials("https://www.facebook.com/2Math.toto");
    }



}
