
package com.github.jorgecastilloprz.mirage.api.foursquare.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class SuggestedBounds {

    @Expose
    private Ne ne;
    @Expose
    private Sw sw;

    /**
     * 
     * @return
     *     The ne
     */
    public Ne getNe() {
        return ne;
    }

    /**
     * 
     * @param ne
     *     The ne
     */
    public void setNe(Ne ne) {
        this.ne = ne;
    }

    /**
     * 
     * @return
     *     The sw
     */
    public Sw getSw() {
        return sw;
    }

    /**
     * 
     * @param sw
     *     The sw
     */
    public void setSw(Sw sw) {
        this.sw = sw;
    }

}
