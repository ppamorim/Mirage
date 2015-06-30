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
public class ContactInfo {

  private String twitterId;
  private String facebookId;
  private String facebookUsername;
  private String facebookName;

  public ContactInfo(String twitterId, String facebookId, String facebookUsername,
      String facebookName) {
    this.twitterId = twitterId != null ? twitterId : "";
    this.facebookId = facebookId != null ? facebookId : "";
    this.facebookUsername = facebookUsername != null ? facebookUsername : "";
    this.facebookName = facebookName != null ? facebookName : "";
  }

  public String getTwitterId() {
    return twitterId;
  }

  public void setTwitterId(String twitterId) {
    this.twitterId = twitterId;
  }

  public String getFacebookId() {
    return facebookId;
  }

  public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
  }

  public String getFacebookUsername() {
    return facebookUsername;
  }

  public void setFacebookUsername(String facebookUsername) {
    this.facebookUsername = facebookUsername;
  }

  public String getFacebookName() {
    return facebookName;
  }

  public void setFacebookName(String facebookName) {
    this.facebookName = facebookName;
  }
}
