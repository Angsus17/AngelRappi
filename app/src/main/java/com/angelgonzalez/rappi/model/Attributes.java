package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */

public class Attributes implements Serializable {


    private String label;


    private String imId;

    private String term;

    private String scheme;


    private String href;



    private String imBundleId;

    private String rel;
    private String type;

    private String amount;
    private String currency;


        private String height;

    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * The imId
     */
    public String getImId() {
        return imId;
    }

    /**
     *
     * @param imId
     * The im:id
     */
    public void setImId(String imId) {
        this.imId = imId;
    }

    /**
     *
     * @return
     * The term
     */
    public String getTerm() {
        return term;
    }

    /**
     *
     * @param term
     * The term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     *
     * @return
     * The scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     *
     * @param scheme
     * The scheme
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }


    /**
     *
     * @return
     * The href
     */
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href
     * The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     * @return
     * The imBundleId
     */
    public String getImBundleId() {
        return imBundleId;
    }

    /**
     *
     * @param imBundleId
     * The im:bundleId
     */
    public void setImBundleId(String imBundleId) {
        this.imBundleId = imBundleId;
    }

    /**
     *
     * @return
     * The rel
     */
    public String getRel() {
        return rel;
    }

    /**
     *
     * @param rel
     * The rel
     */
    public void setRel(String rel) {
        this.rel = rel;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     * The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     * The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     * The height
     */
    public String getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(String height) {
        this.height = height;
    }
}
