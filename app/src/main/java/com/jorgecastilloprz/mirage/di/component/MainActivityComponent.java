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

import com.jorgecastilloprz.mirage.MainPresenter;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import com.jorgecastilloprz.mirage.di.modules.ActivityModule;
import com.jorgecastilloprz.mirage.di.modules.PlacesModule;
import com.jorgecastilloprz.mirage.di.modules.PresentationModule;
import com.jorgecastilloprz.mirage.ui.activity.MainActivity;
import com.jorgecastilloprz.mirage.ui.fragment.MockFragment;
import dagger.Component;

/**
 * @author Jorge Castillo Pérez
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, PresentationModule.class, PlacesModule.class
}) public interface MainActivityComponent extends AbstractActivityComponent {

  void inject(MainActivity mainActivity);

  void inject(MockFragment lucasGameListFragment);

  MainPresenter mainPresenter();
}