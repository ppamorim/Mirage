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
package com.jorgecastilloprz.mirage.di.modules;

import android.app.Activity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.plus.Plus;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  /**
   * Expose the activity to dependents in the graph.
   */
  @Provides @PerActivity Activity activity() {
    return activity;
  }

  @Provides GoogleApiClient provideGoogleApiClient() {
    return new GoogleApiClient.Builder(activity).addConnectionCallbacks(
        (GoogleApiClient.ConnectionCallbacks) activity)
        .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) activity)
        .addApi(Plus.API)
        .addScope(new Scope("profile"))
        .addApi(Places.GEO_DATA_API)
        .addApi(Places.PLACE_DETECTION_API)
        .build();
  }
}
