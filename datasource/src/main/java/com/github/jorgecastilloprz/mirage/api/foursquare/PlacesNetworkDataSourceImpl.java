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
import com.github.jorgecastilloprz.mirage.mapper.PlaceMapper;
import com.jorgecastilloprz.mirage.datasources.PlacesNetworkDataSource;
import com.jorgecastilloprz.mirage.datasources.exceptions.NetworkMapperException;
import com.jorgecastilloprz.mirage.datasources.exceptions.ObtainPlacesNetworkException;
import com.jorgecastilloprz.mirage.model.Place;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class PlacesNetworkDataSourceImpl implements PlacesNetworkDataSource {

  private FoursquareRetrofitService service;
  private PlaceMapper placeMapper;

  private final int RESULT_COUNT = 50;
  private final int RADIUS = 100000;
  private final String API_COMPAT_DATE = "20150627";
  private final String CLIENT_ID = "E5MVMUAUJEAUAKVEUM3VVUL3EHCBWSVHK4KPJCOJSILAOML1";
  private final String CLIENT_SECRET = "3GFMAW2EDQP1WTHRUIJI3ESJINW4FB0P2N2FBWXS55HED3AG";

  @Inject PlacesNetworkDataSourceImpl(FoursquareRetrofitService service, PlaceMapper placeMapper) {
    this.service = service;
    this.placeMapper = placeMapper;
  }

  @Override public List<Place> obtainPlacesAround(double lat, double lng, int limit, int radius)
      throws ObtainPlacesNetworkException, NetworkMapperException {

    NearPlacesFoursquareResponse response =
        service.obtainPlacesAround(lat + "," + lng, CategoryUtils.getCategories(), RESULT_COUNT,
            RADIUS, 1, API_COMPAT_DATE, CLIENT_ID, CLIENT_SECRET, "any", "any");

    try {
      return placeMapper.map(response);
    } catch (Exception e) {
      throw new NetworkMapperException();
    }
  }
}
