package com.example.testcase;

import android.content.Intent;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void openWebPage_validUrl_opensBrowser() {
        onView(withId(R.id.etUrl)).perform(replaceText("https://www.google.com"));
        onView(withId(R.id.btnOpenWebPage)).perform(click());

        Intents.intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData("https://www.google.com")
        ));
    }

    @Test
    public void openWebPage_emptyUrl_showsToast() {
        onView(withId(R.id.etUrl)).perform(replaceText(""));
        onView(withId(R.id.btnOpenWebPage)).perform(click());
        onView(withText("Please enter a URL"))
                .inRoot(new ToastMatcher())
                .check(matches(withText("Please enter a URL")));
    }

    @Test
    public void sendEmail_validEmail_opensEmailClient() {
        onView(withId(R.id.etEmail)).perform(replaceText("example@example.com"));
        onView(withId(R.id.btnSendEmail)).perform(click());

        Intents.intended(allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasData("mailto:")
        ));
    }

    @Test
    public void sendEmail_emptyEmail_showsToast() {
        onView(withId(R.id.etEmail)).perform(replaceText(""));
        onView(withId(R.id.btnSendEmail)).perform(click());
        onView(withText("Please enter an email address"))
                .inRoot(new ToastMatcher())
                .check(matches(withText("Please enter an email address")));
    }
}
