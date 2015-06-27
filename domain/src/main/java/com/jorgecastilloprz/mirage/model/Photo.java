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
public class Photo {

  private String id;
  private long creationDate;
  private String url;
  private int width;
  private int height;
  private UserData authorData;

  public Photo(String id, long creationDate, String url, int width, int height,
      UserData authorData) {
    this.id = id;
    this.creationDate = creationDate;
    this.url = url;
    this.width = width;
    this.height = height;
    this.authorData = authorData;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(long creationDate) {
    this.creationDate = creationDate;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public UserData getAuthorData() {
    return authorData;
  }

  public void setAuthorData(UserData authorData) {
    this.authorData = authorData;
  }
}
