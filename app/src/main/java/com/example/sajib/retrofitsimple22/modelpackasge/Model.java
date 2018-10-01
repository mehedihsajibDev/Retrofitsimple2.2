package com.example.sajib.retrofitsimple22.modelpackasge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("lowest-price")
    @Expose
    private String lowestPrice;
    @SerializedName("medium-price")
    @Expose
    private String mediumPrice;
    @SerializedName("high-price")
    @Expose
    private String highPrice;

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(String mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }
}
