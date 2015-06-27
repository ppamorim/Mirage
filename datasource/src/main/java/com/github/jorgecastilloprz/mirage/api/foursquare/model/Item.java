
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Item {

    @Expose
    private Integer unreadCount;

    /**
     * 
     * @return
     *     The unreadCount
     */
    public Integer getUnreadCount() {
        return unreadCount;
    }

    /**
     * 
     * @param unreadCount
     *     The unreadCount
     */
    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

}
