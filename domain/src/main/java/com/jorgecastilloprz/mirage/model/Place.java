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
package com.jorgecastilloprz.mirage.model;

import java.util.List;

/**
 * @author Jorge Castillo Pérez
 */
public class Place {

  private String name;
  private String infoUrl;
  private ContactInfo contactInfo;
  private LocationInfo locationInfo;
  private List<Category> categories;
  private RatingInfo ratingInfo;
  private List<Photo> photos;
  private List<UserTip> tips;

  public Place(String name, String infoUrl, ContactInfo contactInfo, LocationInfo locationInfo,
      List<Category> categories, RatingInfo ratingInfo, List<Photo> photos, List<UserTip> tips) {
    this.name = name;
    this.infoUrl = infoUrl;
    this.contactInfo = contactInfo;
    this.locationInfo = locationInfo;
    this.categories = categories;
    this.ratingInfo = ratingInfo;
    this.photos = photos;
    this.tips = tips;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfoUrl() {
    return infoUrl;
  }

  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  public LocationInfo getLocationInfo() {
    return locationInfo;
  }

  public void setLocationInfo(LocationInfo locationInfo) {
    this.locationInfo = locationInfo;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public RatingInfo getRatingInfo() {
    return ratingInfo;
  }

  public void setRatingInfo(RatingInfo ratingInfo) {
    this.ratingInfo = ratingInfo;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }

  public List<UserTip> getTips() {
    return tips;
  }

  public void setTips(List<UserTip> tips) {
    this.tips = tips;
  }
}
