package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;


@RunWith(JUnit4.class)
public class AsyncTaskTestFreeVersion {

    private static final String initJoke = "I poured root beer in a square glass.\n" +
            "Now I just have beer.";
    private String jokeReturned = "";
    final CountDownLatch signal = new CountDownLatch(1);

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asynctaskTest() throws InterruptedException {

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

        assertEquals(initJoke, jokeReturned);
    }
}
