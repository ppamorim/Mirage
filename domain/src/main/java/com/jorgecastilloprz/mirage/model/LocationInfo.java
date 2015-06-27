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

/**
 * @author Jorge Castillo Pérez
 */
public class LocationInfo {

  private String crossStreet;
  private double lat;
  private double lng;
  private int distance;
  private String postalCode;
  private String cc;
  private String city;
  private String state;
  private String country;
  private String address;

  public LocationInfo(String crossStreet, double lat, double lng, int distance, String postalCode,
      String cc, String city, String state, String country, String address) {
    this.crossStreet = crossStreet;
    this.lat = lat;
    this.lng = lng;
    this.distance = distance;
    this.postalCode = postalCode;
    this.cc = cc;
    this.city = city;
    this.state = state;
    this.country = country;
    this.address = address;
  }

  public String getCrossStreet() {
    return crossStreet;
  }

  public void setCrossStreet(String crossStreet) {
    this.crossStreet = crossStreet;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCc() {
    return cc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
