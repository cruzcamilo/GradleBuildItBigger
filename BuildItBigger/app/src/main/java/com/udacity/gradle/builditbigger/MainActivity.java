package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.jokelibrary.LibraryMainActivity;

import static com.example.android.jokelibrary.LibraryMainActivity.JOKE_KEY;

public class MainActivity extends AppCompatActivity {

    private String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkJoke(View view) {
        new EndpointsAsyncTask(new EndpointsAsyncTask.OnFetchFinishedListener() {
            @Override
            public void onFetchFinished(String result) {
                joke = result;
                    tellJoke(joke);
            }
        }).execute(getBaseContext());
    }

    public void tellJoke(String joke){
        Intent intent = new Intent(this, LibraryMainActivity.class);
        intent.putExtra(JOKE_KEY, joke);
        startActivity(intent);
    }
}