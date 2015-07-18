package com.jorgecastilloprz.mirage;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import com.jorgecastilloprz.mirage.ui.activity.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author jorge
 * @since 18/07/15
 */
@RunWith(AndroidJUnit4.class) public class MainActivityTest {

  @Rule public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

  @Test public void shouldBeAbleToLaunchMainScreen() {
    onView(withText("Hello")).check(ViewAssertions.matches(isDisplayed()));
  }
}
