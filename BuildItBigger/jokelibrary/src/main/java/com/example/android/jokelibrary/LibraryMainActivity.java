package com.example.android.jokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.sillyjokes.Jokes;

public class LibraryMainActivity extends AppCompatActivity {


    Jokes jokeGenerator = new Jokes();
    String joke;
    TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);

        String joke = getIntent().getStringExtra("joke");
        jokeTv = (TextView) findViewById(R.id.joke_tv);
        jokeTv.setText(joke);
    }

    public void tellJoke(View view) {
        joke = jokeGenerator.getRandomJoke();
        jokeTv.setText(joke);
    }
}
