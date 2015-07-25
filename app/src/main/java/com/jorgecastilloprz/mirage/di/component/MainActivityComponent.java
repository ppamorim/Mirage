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

import com.github.jorgecastilloprz.mirage.api.foursquare.FoursquareRetrofitService;
import com.github.jorgecastilloprz.mirage.mapper.PlaceMapper;
import com.jorgecastilloprz.mirage.MainPresenter;
import com.jorgecastilloprz.mirage.NearPlacesListPresenter;
import com.jorgecastilloprz.mirage.datasources.PlacesNetworkDataSource;
import com.jorgecastilloprz.mirage.di.RepositoryModule;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import com.jorgecastilloprz.mirage.di.modules.ActivityModule;
import com.github.jorgecastilloprz.mirage.di.ApiModule;
import com.jorgecastilloprz.mirage.di.modules.InteractorModule;
import com.jorgecastilloprz.mirage.di.modules.PresentationModule;
import com.jorgecastilloprz.mirage.interactor.GetPlacesAround;
import com.jorgecastilloprz.mirage.repository.PlacesRepository;
import com.jorgecastilloprz.mirage.ui.activity.MainActivity;
import com.jorgecastilloprz.mirage.ui.fragment.MockFragment;
import com.jorgecastilloprz.mirage.ui.fragment.NearPlacesListFragment;
import dagger.Component;

/**
 * @author Jorge Castillo Pérez
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, PresentationModule.class, InteractorModule.class, RepositoryModule.class,
    ApiModule.class
}) public interface MainActivityComponent extends AbstractActivityComponent {

  void inject(MainActivity mainActivity);

  void inject(NearPlacesListFragment nearPlacesListFragment);

  void inject(MockFragment mockFragment);

  MainPresenter mainPresenter();

  NearPlacesListPresenter nearPlacesListPresenter();

  GetPlacesAround getPlacesAround();

  PlacesRepository placesRepository();

  PlacesNetworkDataSource placesNetworkDataSource();

  FoursquareRetrofitService foursquareRetrofitService();

  PlaceMapper placeMapper();
}
