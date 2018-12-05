package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.jokelibrary.LibraryMainActivity;

public class MainActivity extends AppCompatActivity {

    public String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new EndpointsAsyncTask(new EndpointsAsyncTask.OnFetchFinishedListener() {
            @Override
            public void onFetchFinished(String result) {
                joke = result;
            }
        }).execute(getBaseContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkJoke(View view) {
        if(!joke.equals("")) {
            tellJoke();
        } else {
            Toast.makeText(this, R.string.please_wait, Toast.LENGTH_SHORT).show();
        }
    }

    public void tellJoke(){
        Intent intent = new Intent(this, LibraryMainActivity.class);
        intent.putExtra("joke", joke);
        Log.v("Main Activity", "working");
        startActivity(intent);
    }
}