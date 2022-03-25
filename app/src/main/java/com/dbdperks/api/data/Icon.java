package com.dbdperks.api.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {

    @SerializedName("portrait")
    @Expose
    private String portrait;
    @SerializedName("preview_portrait")
    @Expose
    private String previewPortrait;
    @SerializedName("shop_background")
    @Expose
    private String shopBackground;

    public String getPortrait() {
        return portrait;
}

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPreviewPortrait() {
        return previewPortrait;
    }

    public void setPreviewPortrait(String previewPortrait) {
        this.previewPortrait = previewPortrait;
    }

    public String getShopBackground() {
        return shopBackground;
    }

    public void setShopBackground(String shopBackground) {
        this.shopBackground = shopBackground;
    }

}
