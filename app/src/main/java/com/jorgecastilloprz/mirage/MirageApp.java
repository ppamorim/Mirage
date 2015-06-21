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

import android.app.Application;
import com.jorgecastilloprz.mirage.di.component.ApplicationComponent;
import com.jorgecastilloprz.mirage.di.component.DaggerApplicationComponent;
import com.jorgecastilloprz.mirage.di.modules.ApplicationModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * This is the Mirage application class, and handles app component and app typography
 * initialization.
 *
 * @author Jorge Castillo Pérez
 */
public class MirageApp extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    initTypography();
    setupAppComponent();
  }

  private void initTypography() {
    CalligraphyConfig.initDefault(
        new CalligraphyConfig.Builder().setDefaultFontPath("fonts/MuseoSans_500.otf")
            .setFontAttrId(R.attr.fontPath)
            .build());
  }

  private void setupAppComponent() {
    applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent component() {
    return applicationComponent;
  }
}
