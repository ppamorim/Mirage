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

import com.jorgecastilloprz.mirage.interactor.GetPlacesAround;
import com.jorgecastilloprz.mirage.model.Place;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class MainPresenterImpl implements MainPresenter, GetPlacesAround.Callback {

  private View view;

  private GetPlacesAround getPlacesAround;

  @Inject MainPresenterImpl(GetPlacesAround getPlacesAround) {
    this.getPlacesAround = getPlacesAround;
  }

  @Override public void setView(View view) {
    if (view == null) {
      throw new IllegalArgumentException("The view must not be null.");
    }

    this.view = view;
  }

  @Override public void initialize() {
    getPlacesAround.execute(this, 37.992360, -1.121461);
  }

  @Override public void onResume() {

  }

  @Override public void onPause() {

  }

  @Override public void onSignOutButtonClick() {
    view.signOutAccount();
    view.storeUserLogedOutInPreferences();
    view.exitToSignInActivity();
  }

  @Override public void onPlacesLoaded(List<Place> places) {

  }

  @Override public void onLoadingPlacesError() {

  }
}
