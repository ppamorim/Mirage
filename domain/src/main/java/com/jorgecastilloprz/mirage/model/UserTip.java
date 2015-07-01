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
public class UserTip {

  private String id;
  private String creationDate;
  private String text;
  private UserData userData;

  public UserTip(String id, String creationDate, String text, UserData userData) {
    this.id = id;
    this.creationDate = creationDate;
    this.text = text;
    this.userData = userData;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public UserData getUserData() {
    return userData;
  }

  public void setUserData(UserData userData) {
    this.userData = userData;
  }
}
