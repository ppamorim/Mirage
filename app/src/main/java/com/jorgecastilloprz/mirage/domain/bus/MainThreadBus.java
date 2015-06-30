package com.jorgecastilloprz.mirage.domain.bus;

import android.os.Handler;
import android.os.Looper;
import com.jorgecastilloprz.mirage.bus.EventBus;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import javax.inject.Inject;

/**
 * @author jorgecastillo
 * @since 22/06/15
 */
public class MainThreadBus extends Bus implements EventBus {
  private final Handler mainThread = new Handler(Looper.getMainLooper());

  @Inject MainThreadBus() {
    super(ThreadEnforcer.ANY);
  }

  @Override public void post(final Object event) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      super.post(event);
    } else {
      mainThread.post(new Runnable() {
        @Override public void run() {
          post(event);
        }
      });
    }
  }
}
