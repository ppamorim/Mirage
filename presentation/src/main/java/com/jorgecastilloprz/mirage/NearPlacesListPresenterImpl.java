/*
 * Copyright (C) 2015 Jorge Castillo Pérez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jorgecastilloprz.mirage;

import com.jorgecastilloprz.mirage.bus.EventBus;
import com.jorgecastilloprz.mirage.bus.events.OnLoadMoreNeeded;
import com.jorgecastilloprz.mirage.bus.events.OnPlacesLoaded;
import com.squareup.otto.Subscribe;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class NearPlacesListPresenterImpl implements NearPlacesListPresenter {

  private View view;
  private EventBus bus;
  private boolean allPlacesAlreadyLoaded = false;

  @Inject NearPlacesListPresenterImpl(EventBus bus) {
    this.bus = bus;
  }

  @Override public void setView(View view) {
    if (view == null) {
      throw new IllegalArgumentException("The view must not be null.");
    }

    this.view = view;
  }

  @Override public void initialize() {
  }

  @Override public void resume() {
    bus.register(this);
  }

  @Override public void pause() {
    bus.unregister(this);
  }

  @Override public void onLoadMoreScrollPositionReached() {
    if (!allPlacesAlreadyLoaded) {
      bus.post(new OnLoadMoreNeeded());
    }
  }

  @Subscribe public void onPlacesLoadedEvent(OnPlacesLoaded event) {
    if (event.getPlaces().size() > 0) {
      view.drawPlaces(event.getPlaces());
    } else {
      allPlacesAlreadyLoaded = true;
    }
  }
}
