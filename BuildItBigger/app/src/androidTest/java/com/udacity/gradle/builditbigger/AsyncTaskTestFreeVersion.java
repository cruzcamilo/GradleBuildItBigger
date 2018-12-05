package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


@RunWith(JUnit4.class)
@LargeTest

public class AsyncTaskTestFreeVersion {

    private static final String initJoke = "I poured root beer in a square glass.\n" +
            "Now I just have beer.";

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;


    @Before
    public void registerIdlingResource(){
        //mIdlingResource = mActivityActivityTestRule.getActivity().getIdlingResource();
        //Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void asynctaskTest(){
        onView(withId(R.id.get_joke_btn))
                .perform(click());


        mActivityActivityTestRule.getActivity().findViewById(R.id.get_joke_btn);
        // Taken from: https://stackoverflow.com/questions/37843039/

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Interstitial close button"), isDisplayed()));

        imageButton.perform(click());


        onView(withId(R.id.joke_tv))
                .check(matches(withText(initJoke)));
    }

    @After
    public void unregisterIdlingResource(){
        if (mIdlingResource!=null){
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }

}
