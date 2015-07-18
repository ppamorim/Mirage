package com.jorgecastilloprz.mirage;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import com.jorgecastilloprz.mirage.ui.activity.MainActivity;
import com.jorgecastilloprz.mirage.ui.activity.MirageSignInActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author jorge
 * @since 18/07/15
 */
@RunWith(AndroidJUnit4.class) public class MirageSignInActivityTest {

  @Rule public final ActivityRule<MirageSignInActivity> main =
      new ActivityRule<>(MirageSignInActivity.class);

  @Test public void videoShouldBePlaying() {
    onView(withId(R.id.textureView)).check(ViewAssertions.matches(isDisplayed()));
  }
}
