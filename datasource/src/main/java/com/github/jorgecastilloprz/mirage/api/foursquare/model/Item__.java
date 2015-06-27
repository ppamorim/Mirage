
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Item__ {

    @Expose
    private String summary;
    @Expose
    private String type;
    @Expose
    private String reasonName;

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
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
     *     The reasonName
     */
    public String getReasonName() {
        return reasonName;
    }

    /**
     * 
     * @param reasonName
     *     The reasonName
     */
    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

}
