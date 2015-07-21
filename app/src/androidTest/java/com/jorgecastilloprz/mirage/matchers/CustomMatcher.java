package com.jorgecastilloprz.mirage.matchers;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import com.jorgecastilloprz.mirage.ui.components.SignInButtonBox;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.is;

/**
 * @author jorge
 * @since 19/07/15
 */
public class CustomMatcher {

  public static Matcher<View> withAlpha(Float expectedAlpha) {
    checkArgument(expectedAlpha > 0);
    return withAlpha(is(expectedAlpha));
  }

  public static Matcher<View> withAlpha(final Matcher<Float> matcherAlphaValue) {
    checkNotNull(matcherAlphaValue);
    return new BoundedMatcher<View, SignInButtonBox>(SignInButtonBox.class) {

      @Override public void describeTo(Description description) {
        description.appendText("Alpha expected: " + matcherAlphaValue);
      }

      @Override protected boolean matchesSafely(SignInButtonBox signInButtonBox) {
        return matcherAlphaValue.matches(signInButtonBox.getAlpha());
      }
    };
  }
}