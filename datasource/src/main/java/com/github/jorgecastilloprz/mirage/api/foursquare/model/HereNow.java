
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class HereNow {

    @Expose
    private Integer count;
    @Expose
    private String summary;
    @Expose
    private List<Object> groups = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

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
     *     The groups
     */
    public List<Object> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

}
