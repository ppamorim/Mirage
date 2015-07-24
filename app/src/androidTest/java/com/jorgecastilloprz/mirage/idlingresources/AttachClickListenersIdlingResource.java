package com.jorgecastilloprz.mirage.idlingresources;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.test.espresso.IdlingResource;
import android.view.View;

/**
 * @author jorge
 * @since 21/07/15
 */
public class AttachClickListenersIdlingResource implements IdlingResource {

  private ResourceCallback resourceCallback;
  private View viewToMonitor;

  public AttachClickListenersIdlingResource(View view) {
    this.viewToMonitor = view;
  }

  @Override public String getName() {
    return AttachClickListenersIdlingResource.class.getName();
  }

  @Override public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
    this.resourceCallback = resourceCallback;
  }

  @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) @Override public boolean isIdleNow() {
    boolean idle = !viewToMonitor.hasOnClickListeners();
    if (idle && resourceCallback != null) {
      resourceCallback.onTransitionToIdle();
    }
    return idle;
  }
}
