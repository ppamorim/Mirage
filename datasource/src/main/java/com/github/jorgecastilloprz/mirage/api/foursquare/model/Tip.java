
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Tip {

    @Expose
    private String id;
    @Expose
    private Integer createdAt;
    @Expose
    private String text;
    @Expose
    private String type;
    @Expose
    private String url;
    @Expose
    private String canonicalUrl;
    @Expose
    private Likes likes;
    @Expose
    private Boolean logView;
    @Expose
    private Todo todo;
    @Expose
    private User__ user;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The createdAt
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * 
     * @param canonicalUrl
     *     The canonicalUrl
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * 
     * @return
     *     The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The logView
     */
    public Boolean getLogView() {
        return logView;
    }

    /**
     * 
     * @param logView
     *     The logView
     */
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    /**
     * 
     * @return
     *     The todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * 
     * @param todo
     *     The todo
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User__ getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User__ user) {
        this.user = user;
    }

}
