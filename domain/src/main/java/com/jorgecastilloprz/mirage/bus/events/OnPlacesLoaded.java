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
package com.jorgecastilloprz.mirage.bus.events;

import com.jorgecastilloprz.mirage.model.Place;
import java.util.List;

public class OnPlacesLoaded {

  private List<Place> places;

  public OnPlacesLoaded(List<Place> places) {
    this.places = places;
  }

  public List<Place> getPlaces() {
    return places;
  }
}
