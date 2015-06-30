package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class Venue {

  @Expose private String id;
  @Expose private String name;
  @Expose private Contact contact;
  @Expose private Location location;
  @Expose private List<FoursquareCategory> categories = new ArrayList<FoursquareCategory>();
  @Expose private Boolean verified;
  @Expose private Stats stats;
  @Expose private String url;
  @Expose private Boolean like;
  @Expose private Double rating;
  @Expose private String ratingColor;
  @Expose private Integer ratingSignals;
  @Expose private Hours hours;
  @Expose private Specials specials;
  @Expose private Photos photos;
  @Expose private HereNow hereNow;
  @Expose private VenuePage venuePage;
  @Expose private String storeId;
  @Expose private FeaturedPhotos featuredPhotos;

  /**
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The contact
   */
  public Contact getContact() {
    return contact;
  }

  /**
   * @param contact The contact
   */
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  /**
   * @return The location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location The location
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return The categories
   */
  public List<FoursquareCategory> getCategories() {
    return categories;
  }

  /**
   * @param categories The categories
   */
  public void setCategories(List<FoursquareCategory> categories) {
    this.categories = categories;
  }

  /**
   * @return The verified
   */
  public Boolean getVerified() {
    return verified;
  }

  /**
   * @param verified The verified
   */
  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  /**
   * @return The stats
   */
  public Stats getStats() {
    return stats;
  }

  /**
   * @param stats The stats
   */
  public void setStats(Stats stats) {
    this.stats = stats;
  }

  /**
   * @return The url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url The url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return The like
   */
  public Boolean getLike() {
    return like;
  }

  /**
   * @param like The like
   */
  public void setLike(Boolean like) {
    this.like = like;
  }

  /**
   * @return The rating
   */
  public Double getRating() {
    return rating;
  }

  /**
   * @param rating The rating
   */
  public void setRating(Double rating) {
    this.rating = rating;
  }

  /**
   * @return The ratingColor
   */
  public String getRatingColor() {
    return ratingColor;
  }

  /**
   * @param ratingColor The ratingColor
   */
  public void setRatingColor(String ratingColor) {
    this.ratingColor = ratingColor;
  }

  /**
   * @return The ratingSignals
   */
  public Integer getRatingSignals() {
    return ratingSignals;
  }

  /**
   * @param ratingSignals The ratingSignals
   */
  public void setRatingSignals(Integer ratingSignals) {
    this.ratingSignals = ratingSignals;
  }

  /**
   * @return The hours
   */
  public Hours getHours() {
    return hours;
  }

  /**
   * @param hours The hours
   */
  public void setHours(Hours hours) {
    this.hours = hours;
  }

  /**
   * @return The specials
   */
  public Specials getSpecials() {
    return specials;
  }

  /**
   * @param specials The specials
   */
  public void setSpecials(Specials specials) {
    this.specials = specials;
  }

  /**
   * @return The photos
   */
  public Photos getPhotos() {
    return photos;
  }

  /**
   * @param photos The photos
   */
  public void setPhotos(Photos photos) {
    this.photos = photos;
  }

  /**
   * @return The hereNow
   */
  public HereNow getHereNow() {
    return hereNow;
  }

  /**
   * @param hereNow The hereNow
   */
  public void setHereNow(HereNow hereNow) {
    this.hereNow = hereNow;
  }

  /**
   * @return The venuePage
   */
  public VenuePage getVenuePage() {
    return venuePage;
  }

  /**
   * @param venuePage The venuePage
   */
  public void setVenuePage(VenuePage venuePage) {
    this.venuePage = venuePage;
  }

  /**
   * @return The storeId
   */
  public String getStoreId() {
    return storeId;
  }

  /**
   * @param storeId The storeId
   */
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  /**
   * @return The featuredPhotos
   */
  public FeaturedPhotos getFeaturedPhotos() {
    return featuredPhotos;
  }

  /**
   * @param featuredPhotos The featuredPhotos
   */
  public void setFeaturedPhotos(FeaturedPhotos featuredPhotos) {
    this.featuredPhotos = featuredPhotos;
  }

  public boolean hasPhotos() {
    return photos != null
        && photos.getGroups().size() > 0
        && photos.getGroups().get(0).getItems().size() > 0;
  }

  public boolean hasFeaturedPhotos() {
    return featuredPhotos != null && featuredPhotos.getItems().size() > 0;
  }
}
