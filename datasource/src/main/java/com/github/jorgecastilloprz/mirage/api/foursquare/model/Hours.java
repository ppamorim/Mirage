
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Hours {

    @Expose
    private String status;
    @Expose
    private Boolean isOpen;

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The isOpen
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 
     * @param isOpen
     *     The isOpen
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

}
