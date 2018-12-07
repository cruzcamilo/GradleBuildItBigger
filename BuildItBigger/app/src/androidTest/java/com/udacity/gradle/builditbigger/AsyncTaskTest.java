package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import com.example.android.sillyjokes.Jokes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.not;


@RunWith(JUnit4.class)
public class AsyncTaskTest {

    private String jokeReturned = "";
    final CountDownLatch signal = new CountDownLatch(1);

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asynctaskTest() throws InterruptedException {

        String [] jokes = new Jokes().getAllJokes();

        new EndpointsAsyncTask(new EndpointsAsyncTask.
                OnFetchFinishedListener() {
            @Override
            public void onFetchFinished(String result) {
                jokeReturned = result;
                signal.countDown();
            }
        }).execute(mActivityActivityTestRule.getActivity().getBaseContext());

        // Taken from: https://stackoverflow.com/questions/2321829/
        signal.await(30, TimeUnit.SECONDS);

        // Compares with empty string and the exception of AsyncTask doInBackgroundMethod
        assertThat(jokeReturned, not(equalTo("")));
        assertThat(jokes, hasItemInArray(jokeReturned));
    }
}
