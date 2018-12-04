package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(JUnit4.class)
@LargeTest

public class AsyncTaskTest {

    private static final String initJoke = "I poured root beer in a square glass.\n" +
            "Now I just have beer.";

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asynctaskTest(){
        onView(withId(R.id.get_joke_btn))
                .perform(click());

        onView(withId(R.id.joke_tv))
                .check(matches(withText(initJoke)));
    }

}
