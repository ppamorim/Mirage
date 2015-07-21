package com.jorgecastilloprz.mirage.idlingresources;

import android.support.test.espresso.IdlingResource;
import android.view.View;

/**
 * @author jorge
 * @since 21/07/15
 */
public class AlphaIdlingResource implements IdlingResource {

  private ResourceCallback resourceCallback;
  private View viewToMonitor;

  public AlphaIdlingResource(View view) {
    this.viewToMonitor = view;
  }

  @Override public String getName() {
    return AlphaIdlingResource.class.getName();
  }

  @Override public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
    this.resourceCallback = resourceCallback;
  }

  @Override public boolean isIdleNow() {
    boolean idle = !isFullAlphaOpacity();
    if (idle && resourceCallback != null) {
      resourceCallback.onTransitionToIdle();
    }
    return idle;
  }

  private boolean isFullAlphaOpacity() {
    return viewToMonitor.getAlpha() == 1.0;
  }
}
