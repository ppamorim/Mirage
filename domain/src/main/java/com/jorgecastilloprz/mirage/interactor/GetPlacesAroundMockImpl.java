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
package com.jorgecastilloprz.mirage.interactor;

import com.jorgecastilloprz.mirage.executor.InteractorExecutor;
import com.jorgecastilloprz.mirage.executor.MainThread;
import com.jorgecastilloprz.mirage.interactor.exceptions.ObtainPlacesException;
import com.jorgecastilloprz.mirage.model.Place;
import com.jorgecastilloprz.mirage.repository.PlacesRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class GetPlacesAroundMockImpl implements GetPlacesAround {

  private InteractorExecutor executor;
  private MainThread mainThread;
  private PlacesRepository repository;
  private double lat;
  private double lng;
  private Callback callback;

  @Inject GetPlacesAroundMockImpl(InteractorExecutor executor, MainThread mainThread,
      PlacesRepository repository) {
    this.executor = executor;
    this.mainThread = mainThread;
    this.repository = repository;
  }

  @Override public void execute(Callback callback, double lat, double lng) {
    this.callback = callback;
    this.lat = lat;
    this.lng = lng;
    this.executor.run(this);
  }

  @Override public void run() {
    try {
      List<Place> placesAround = repository.obtainPlacesAround(lat, lng, 200, 100000);
      notifyGamesLoaded(placesAround);
    } catch (ObtainPlacesException e) {
      notifyLoadingGamesError();
    }
  }

  private void notifyLoadingGamesError() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onLoadingPlacesError();
      }
    });
  }

  private void notifyGamesLoaded(final List<Place> places) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onPlacesLoaded(places);
      }
    });
  }
}
