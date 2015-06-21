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
package com.jorgecastilloprz.mirage.di.component;

import android.app.Activity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import com.jorgecastilloprz.mirage.di.modules.ActivityModule;
import dagger.Component;

/**
 * A base component upon which fragment's components may depend.  Activity-level components
 * should extend this component.
 */
@PerActivity // Subtypes of ActivityComponent should be decorated with @PerActivity.
@Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class
}) public interface AbstractActivityComponent {

  Activity activity();

  GoogleApiClient googleApiClient();
}
