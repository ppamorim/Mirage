
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Photos {

    @Expose
    private Integer count;
    @Expose
    private List<Group_> groups = new ArrayList<Group_>();

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
     *     The groups
     */
    public List<Group_> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Group_> groups) {
        this.groups = groups;
    }

}
