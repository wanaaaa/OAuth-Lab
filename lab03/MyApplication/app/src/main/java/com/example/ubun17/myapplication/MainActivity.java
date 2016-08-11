package com.example.ubun17.myapplication;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "asdfasf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doMyAuthentication();
    }

    public void doMyAuthentication() {
        String consumer_key = "O4sU0x3BtyfZoH1cjWU8HrM2G";
        String consumer_secret = "oO6qmxSvKXSGqG0NtkHY9IDUKVfaxM45rI9U0z776HbtDBJiTw";
        String encodedkey = consumer_key+":"+consumer_secret;

        String base64EncodedString = Base64.encodeToString(encodedkey.getBytes(), Base64.NO_WRAP);

        Log.i(TAG, base64EncodedString);

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();


        Request apiRequest = new Request.Builder()
                .addHeader("Authorization", "Basic " + base64EncodedString)
                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .post(requestBody)
                .url("https://api.twitter.com/oauth2/token")
                .build();

//        client.newCall(apiRequest).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.i(TAG, "fail");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    //cry
//                } else {
//                    Log.i(TAG, "Response: " + response.body().string());
//                }
//            }
//        });
        //////////////////////////////
        RequestBody requestBody1 = new FormBody.Builder().build();

        Request apiRequest2 = new Request.Builder()
                .addHeader("Authorization", "Bearer " +
                        "AAAAAAAAAAAAAAAAAAAAAPjFuAAAAAAAw4DhWE0PW1fC%2FNu9IqlACrmkceQ%3DAfrebWvQJeZg6ttJrEEMWod9Wa7qGSyTM05dsFzae39UE5W4ZW")
                .url("https://api.twitter.com/1.1/search/tweets.json?q=clinton")
                //.get(requestBody1)
                .build();//

        client.newCall(apiRequest2).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    //cry
                } else {
                    Log.i(TAG, "?????????: " + response.body().string());
                }
            }
        });


    }

}
