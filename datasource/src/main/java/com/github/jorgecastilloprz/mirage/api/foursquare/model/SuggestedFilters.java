
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class SuggestedFilters {

    @Expose
    private String header;
    @Expose
    private List<Filter> filters = new ArrayList<Filter>();

    /**
     * 
     * @return
     *     The header
     */
    public String getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
