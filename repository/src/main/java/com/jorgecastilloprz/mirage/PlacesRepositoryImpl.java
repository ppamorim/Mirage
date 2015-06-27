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

import com.jorgecastilloprz.mirage.datasources.PlacesNetworkDataSource;
import com.jorgecastilloprz.mirage.datasources.exceptions.ObtainPlacesNetworkException;
import com.jorgecastilloprz.mirage.interactor.exceptions.ObtainPlacesException;
import com.jorgecastilloprz.mirage.model.Place;
import com.jorgecastilloprz.mirage.repository.PlacesRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class PlacesRepositoryImpl implements PlacesRepository {

  private PlacesNetworkDataSource dataSource;

  @Inject PlacesRepositoryImpl(PlacesNetworkDataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override public List<Place> obtainPlacesAround(double lat, double lng, int limit, int radius)
      throws ObtainPlacesException {
    try {
      return dataSource.obtainPlacesAround(lat, lng, limit, radius);
    } catch (ObtainPlacesNetworkException e) {
      throw new ObtainPlacesException();
    }
  }
}