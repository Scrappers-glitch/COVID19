package com.scrappers.covid19_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class COVID19_Maps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19__maps);
        LoadOurWebHTML("https://gisanddata.maps.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6");
    }
    public void LoadOurWebHTML(String location){
        WebView viewHTML=findViewById(R.id.webview);
        WebSettings webJS=viewHTML.getSettings();


        webJS.setJavaScriptEnabled(true);
        webJS.setAllowFileAccess(true);
        webJS.setDisplayZoomControls(true);
        webJS.setAllowContentAccess(true);
        webJS.setBuiltInZoomControls(true);
        webJS.setEnableSmoothTransition(true);

//        viewHTML.loadData(location,"text/html","UTF-8");
        viewHTML.setVerticalScrollBarEnabled(true);
        viewHTML.loadUrl(location);

    }

}
