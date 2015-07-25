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
package com.github.jorgecastilloprz.mirage.di;

import com.github.jorgecastilloprz.mirage.api.foursquare.FoursquarePlaceMapper;
import com.github.jorgecastilloprz.mirage.api.foursquare.FoursquareRetrofitService;
import com.github.jorgecastilloprz.mirage.api.foursquare.PlacesNetworkDataSourceImpl;
import com.github.jorgecastilloprz.mirage.mapper.PlaceMapper;
import com.jorgecastilloprz.mirage.datasources.PlacesNetworkDataSource;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import retrofit.RestAdapter;

/**
 * @author Jorge Castillo Pérez
 */
@Module public class TestApiModule {

  private final MockWebServer mMockWebServer;

  public TestApiModule() {
    mMockWebServer = new MockWebServer();
    try {
      mMockWebServer.play();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public MockWebServer getMockWebServer() {
    return mMockWebServer;
  }

  @Provides @PerActivity PlacesNetworkDataSource provideNetworkDatasource(
      PlacesNetworkDataSourceImpl dataSource) {
    return dataSource;
  }

  @Provides @PerActivity FoursquareRetrofitService provideApiService() {
    return new RestAdapter.Builder().setEndpoint(mMockWebServer.getUrl("/").toString())
        .build()
        .create(FoursquareRetrofitService.class);
  }

  @Provides @PerActivity PlaceMapper providePlaceMapper(FoursquarePlaceMapper mapper) {
    return mapper;
  }
}
