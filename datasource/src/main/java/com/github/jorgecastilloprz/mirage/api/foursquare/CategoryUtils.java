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

/**
 * @author Jorge Castillo Pérez
 */
public class CategoryUtils {

  public static final String OUTDOORS_AND_RECREATION = "4d4b7105d754a06377d81259";
  public static final String TRAVEL_AND_TRANSPORT = "4d4b7105d754a06379d81259";
  public static final String TRAVEL_AGENCY = "4f04b08c2fb6e1c99f3db0bd";
  public static final String ARTS_AND_ENTERTAINMENT = "4d4b7104d754a06370d81259";
  public static final String TANNING_SALOON = "4d1cf8421a97d635ce361c31";
  public static final String SPA = "4bf58dd8d48988d1ed941735";
  public static final String SOUVENIR_SHOP = "52f2ab2ebcbc57f1066b8b1b";
  public static final String OUTDOOR_SHOP = "52f2ab2ebcbc57f1066b8b22";
  public static final String MUSIC_STORE = "4bf58dd8d48988d1fe941735";
  public static final String YOGA_STUDIO = "4bf58dd8d48988d102941735";
  public static final String MARTIAL_ARTS_DOJO = "4bf58dd8d48988d101941735";
  public static final String DIVE_SHOP = "52f2ab2ebcbc57f1066b8b1a";
  public static final String CONSTRUCTION_AND_LANDSCAPING = "5454144b498ec1f095bff2f2";
  public static final String BOARD_SHOP = "4bf58dd8d48988d1f1941735";
  public static final String BIKE_SHOP = "4bf58dd8d48988d115951735";
  public static final String SPIRITUAL_CENTER = "4bf58dd8d48988d131941735";
  public static final String SOCIAL_CLUB = "52e81612bcbc57f1066b7a33";
  public static final String GOVERNMENT =
      "4bf58dd8d48988d12a941735,4bf58dd8d48988d129941735,4bf58dd8d48988d12b941735,"
          + "4bf58dd8d48988d12c951735,4bf58dd8d48988d12d941735,52e81612bcbc57f1066b7a38";
  public static final String FAIR = "4eb1daf44b900d56c88a4600";
  public static final String EVENT_SPACE = "4bf58dd8d48988d171941735";
  public static final String CULTURAL_CENTER = "52e81612bcbc57f1066b7a32";
  public static final String CONVENTION_CENTER = "4bf58dd8d48988d1ff931735";
  public static final String COMMUNITY_CENTER = "52e81612bcbc57f1066b7a34";
  public static final String CLUB_HOUSE = "52e81612bcbc57f1066b7a35";
  public static final String AUDITORIUM = "4bf58dd8d48988d173941735";
  public static final String EVENT = "4d4b7105d754a06373d81259";
  public static final String UNIVERSITY = "4bf58dd8d48988d1ae941735";
  public static final String COLLEGE_THEATER = "4bf58dd8d48988d1ac941735";
  public static final String COLLEGE_STADIUM = "4bf58dd8d48988d1b4941735";

  public static String getCategories() {
    return OUTDOORS_AND_RECREATION + "," + TRAVEL_AND_TRANSPORT + "," + TRAVEL_AGENCY + "," +
        ARTS_AND_ENTERTAINMENT + "," + TANNING_SALOON + "," + SPA + "," + SOUVENIR_SHOP + "," +
        OUTDOOR_SHOP + "," + MUSIC_STORE + "," + YOGA_STUDIO + "," + DIVE_SHOP + "," +
        MARTIAL_ARTS_DOJO + "," + CONSTRUCTION_AND_LANDSCAPING + "," + BOARD_SHOP + "," +
        BIKE_SHOP + "," + SPIRITUAL_CENTER + "," + SOCIAL_CLUB + "," + GOVERNMENT + "," +
        FAIR + "," + EVENT_SPACE + "," + CULTURAL_CENTER + "," + CONVENTION_CENTER + "," +
        COMMUNITY_CENTER + "," + CLUB_HOUSE + "," + AUDITORIUM + "," + EVENT + "," + UNIVERSITY +
        "," + COLLEGE_THEATER + "," + COLLEGE_STADIUM;
  }
}
