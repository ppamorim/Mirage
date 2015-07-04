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
import com.jorgecastilloprz.mirage.bus.events.OnRefreshStarted;
import com.jorgecastilloprz.mirage.interactor.GetPlacesAround;
import com.jorgecastilloprz.mirage.model.Place;
import com.squareup.otto.Subscribe;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class MainPresenterImpl implements MainPresenter, GetPlacesAround.Callback {

  private View view;

  private GetPlacesAround getPlacesAround;
  private EventBus bus;
  private int lastLoadedPage;

  @Inject MainPresenterImpl(GetPlacesAround getPlacesAround, EventBus bus) {
    this.getPlacesAround = getPlacesAround;
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

  @Override public void onSignOutButtonClick() {
    view.signOutAccount();
    view.storeUserLogedOutInPreferences();
    view.exitToSignInActivity();
  }

  @Subscribe public void onRefreshStartedEvent(OnRefreshStarted event) {
    getPlacesAround.execute(this, 37.992360, -1.121461, 0);
  }

  @Subscribe public void onLoadMoreNeeded(OnLoadMoreNeeded event) {
    getPlacesAround.execute(this, 37.992360, -1.121461, lastLoadedPage++);
  }

  @Override public void onPlacesLoaded(List<Place> places) {
    bus.post(new OnPlacesLoaded(places));
  }

  @Override public void onLoadingPlacesError() {
    view.displayError("Loading places error. Check your connection.");
  }
}
