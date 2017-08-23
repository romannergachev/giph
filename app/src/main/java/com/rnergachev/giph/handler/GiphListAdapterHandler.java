package com.rnergachev.giph.handler;

import com.rnergachev.giph.data.model.GiphData;

/**
 * List on click handler
 */

public interface GiphListAdapterHandler {
    /**
     * Performs the giph selection
     *
     * @param giph that has been selected
     */
    void onClick(GiphData giph);
}
