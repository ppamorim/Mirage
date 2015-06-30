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

import com.github.jorgecastilloprz.mirage.api.foursquare.model.FeaturedPhoto;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.FoursquareCategory;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.FoursquareVenuePhotoItem;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.Location;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.NearPlacesFoursquareResponse;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.Venue;
import com.github.jorgecastilloprz.mirage.api.foursquare.model.VenueItem;
import com.github.jorgecastilloprz.mirage.mapper.PlaceMapper;
import com.jorgecastilloprz.mirage.model.Category;
import com.jorgecastilloprz.mirage.model.ContactInfo;
import com.jorgecastilloprz.mirage.model.LocationInfo;
import com.jorgecastilloprz.mirage.model.Photo;
import com.jorgecastilloprz.mirage.model.Place;
import com.jorgecastilloprz.mirage.model.RatingInfo;
import com.jorgecastilloprz.mirage.model.UserData;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Maps from a foursquare formatted response to a list of places from the domain model
 * By doing this we can allow the user to not break the dependency rule.
 *
 * @author Jorge Castillo Pérez
 */
public class FoursquarePlaceMapper implements PlaceMapper<NearPlacesFoursquareResponse> {

  @Inject FoursquarePlaceMapper() {
  }

  @Override public List<Place> map(NearPlacesFoursquareResponse source) {
    List<Place> places = new ArrayList<>();

    for (VenueItem venueItem : source.getResponse().getGroups().get(0).getItems()) {

      Venue venue = venueItem.getVenue();
      Location location = venue.getLocation();
      List<Category> categories = new ArrayList<>();

      for (FoursquareCategory category : venue.getCategories()) {
        categories.add(new Category(
            category.getIcon().getPrefix() + "original" + category.getIcon().getSuffix(),
            category.getName(), category.getId()));
      }

      List<Photo> photos = new ArrayList<>();
      if (venue.hasFeaturedPhotos()) {
        for (FeaturedPhoto featuredPhoto : venue.getFeaturedPhotos().getItems()) {
          Photo photo = new Photo(featuredPhoto.getId(), featuredPhoto.getCreatedAt(),
              featuredPhoto.getPrefix() + "original" + featuredPhoto.getSuffix(),
              featuredPhoto.getWidth(), featuredPhoto.getHeight(),
              new UserData(featuredPhoto.getUser().getId(),
                  featuredPhoto.getUser().getFirstName() + " " + featuredPhoto.getUser()
                      .getLastName(), featuredPhoto.getUser().getPhoto().getPrefix()
                  + "original"
                  + featuredPhoto.getUser().getPhoto().getSuffix()));

          photos.add(photo);
        }
      }

      if (venue.hasPhotos()) {
        for (FoursquareVenuePhotoItem photoItem : venue.getPhotos().getGroups().get(0).getItems()) {
          Photo photo = new Photo(photoItem.getId(), photoItem.getCreatedAt(),
              photoItem.getPrefix() + "original" + photoItem.getSuffix(), photoItem.getWidth(),
              photoItem.getHeight(), new UserData(photoItem.getUser().getId(),
              photoItem.getUser().getFirstName() + " " + photoItem.getUser().getLastName(),
              photoItem.getUser().getPhoto().getPrefix() + "original" + photoItem.getUser()
                  .getPhoto()
                  .getSuffix()));

          photos.add(photo);
        }
      }

      RatingInfo currentVenueRatingInfo = null;
      if (venue.getRating() != null) {
        currentVenueRatingInfo =
            new RatingInfo(venue.getRating(), venue.getRatingColor(), venue.getRatingSignals());
      }

      Place currentPlace = new Place(venue.getName(), venue.getUrl(),
          new ContactInfo(venue.getContact().getTwitter(), venue.getContact().getFacebook(),
              venue.getContact().getFacebookUsername(), venue.getContact().getFacebookName()),
          new LocationInfo(location.getCrossStreet(), location.getLat(), location.getLng(),
              location.getDistance(), location.getPostalCode(), location.getCc(),
              location.getCity(), location.getState(), location.getCountry(),
              location.getAddress()), categories, currentVenueRatingInfo, photos);

      places.add(currentPlace);
    }

    return places;
  }
}
