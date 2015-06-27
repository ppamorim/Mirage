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
package com.github.jorgecastilloprz.mirage.api.foursquare;

import com.github.jorgecastilloprz.mirage.api.foursquare.model.NearPlacesFoursquareResponse;
import com.jorgecastilloprz.mirage.datasources.PlacesNetworkDataSource;
import com.jorgecastilloprz.mirage.datasources.exceptions.ObtainPlacesNetworkException;
import com.jorgecastilloprz.mirage.model.Place;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class PlacesNetworkDataSourceImpl implements PlacesNetworkDataSource {

  private FoursquareRetrofitService service;
  private final String CATEGORY_ID = "4d4b7105d754a06377d81259";
  private final int RESULT_COUNT = 1000;
  private final int RADIUS = 100000;
  private final String API_COMPAT_DATE = "20150627";
  private final String CLIENT_ID = "E5MVMUAUJEAUAKVEUM3VVUL3EHCBWSVHK4KPJCOJSILAOML1";
  private final String CLIENT_SECRET = "3GFMAW2EDQP1WTHRUIJI3ESJINW4FB0P2N2FBWXS55HED3AG";

  @Inject PlacesNetworkDataSourceImpl(FoursquareRetrofitService service) {
    this.service = service;
  }

  @Override public List<Place> obtainPlacesAround(double lat, double lng, int limit, int radius)
      throws ObtainPlacesNetworkException {

    NearPlacesFoursquareResponse response =
        service.obtainPlacesAround(lat + "," + lng, CATEGORY_ID, RESULT_COUNT, RADIUS, 1,
            API_COMPAT_DATE, CLIENT_ID, CLIENT_SECRET);

    return null;
  }
}
