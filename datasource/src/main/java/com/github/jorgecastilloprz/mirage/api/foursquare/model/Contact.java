
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Contact {

    @Expose
    private String phone;
    @Expose
    private String formattedPhone;
    @Expose
    private String twitter;
    @Expose
    private String facebook;
    @Expose
    private String facebookUsername;
    @Expose
    private String facebookName;

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The formattedPhone
     */
    public String getFormattedPhone() {
        return formattedPhone;
    }

    /**
     * 
     * @param formattedPhone
     *     The formattedPhone
     */
    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    /**
     * 
     * @return
     *     The twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * 
     * @param twitter
     *     The twitter
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * 
     * @return
     *     The facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * 
     * @param facebook
     *     The facebook
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * 
     * @return
     *     The facebookUsername
     */
    public String getFacebookUsername() {
        return facebookUsername;
    }

    /**
     * 
     * @param facebookUsername
     *     The facebookUsername
     */
    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    /**
     * 
     * @return
     *     The facebookName
     */
    public String getFacebookName() {
        return facebookName;
    }

    /**
     * 
     * @param facebookName
     *     The facebookName
     */
    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

}
