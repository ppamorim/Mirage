
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Stats {

    @Expose
    private Integer checkinsCount;
    @Expose
    private Integer usersCount;
    @Expose
    private Integer tipCount;

    /**
     * 
     * @return
     *     The checkinsCount
     */
    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    /**
     * 
     * @param checkinsCount
     *     The checkinsCount
     */
    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    /**
     * 
     * @return
     *     The usersCount
     */
    public Integer getUsersCount() {
        return usersCount;
    }

    /**
     * 
     * @param usersCount
     *     The usersCount
     */
    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    /**
     * 
     * @return
     *     The tipCount
     */
    public Integer getTipCount() {
        return tipCount;
    }

    /**
     * 
     * @param tipCount
     *     The tipCount
     */
    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

}
