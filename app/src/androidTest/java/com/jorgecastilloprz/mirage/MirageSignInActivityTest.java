package com.jorgecastilloprz.mirage;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import com.jorgecastilloprz.mirage.matchers.AlphaMatcher;
import com.jorgecastilloprz.mirage.ui.activity.MirageSignInActivity;
import com.jorgecastilloprz.mirage.ui.components.TextureVideoView;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.fail;

/**
 * @author jorge
 * @since 18/07/15
 */
@RunWith(AndroidJUnit4.class) public class MirageSignInActivityTest {

  @Rule public final ActivityRule<MirageSignInActivity> main =
      new ActivityRule<>(MirageSignInActivity.class);

  @Test public void videoShouldBePlaying() {
    onView(withId(R.id.textureView)).check(new ViewAssertion() {
      @Override public void check(View view, NoMatchingViewException e) {
        if (!((TextureVideoView) view).isPlaying()) {
          fail("Video is not playing!");
        }
      }
    });
  }

  @Test public void socialButtonsShouldAppearOnSignInClick() {
    onView(withId(R.id.signButton)).perform(click());
    onView(withId(R.id.signInButtonBox)).check(matches(AlphaMatcher.withAlpha(1f)));
  }
}
