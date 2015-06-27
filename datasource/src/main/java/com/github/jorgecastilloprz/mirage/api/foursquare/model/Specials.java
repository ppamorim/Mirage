
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Specials {

    @Expose
    private Integer count;
    @Expose
    private List<Object> items = new ArrayList<Object>();

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
     *     The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

}
