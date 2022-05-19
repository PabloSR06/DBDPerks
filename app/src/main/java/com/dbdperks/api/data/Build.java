package com.dbdperks.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Build {

    @SerializedName("id_Build")
    @Expose
    private String idBuild;
    @SerializedName("perks")
    @Expose
    private String perks;
    @SerializedName("nameBuild")
    @Expose
    private String nameBuild;
    @SerializedName("infoBuild")
    @Expose
    private String infoBuild;
    @SerializedName("tipeBuild")
    @Expose
    private String tipeBuild;

    public String getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(String idBuild) {
        this.idBuild = idBuild;
    }

    public String getPerks() {
        return perks;
    }

    public void setPerks(String perks) {
        this.perks = perks;
    }

    public String getNameBuild() {
        return nameBuild;
    }

    public void setNameBuild(String nameBuild) {
        this.nameBuild = nameBuild;
    }

    public String getInfoBuild() {
        return infoBuild;
    }

    public void setInfoBuild(String infoBuild) {
        this.infoBuild = infoBuild;
    }

    public String getTipeBuild() {
        return tipeBuild;
    }

    public void setTipeBuild(String tipeBuild) {
        this.tipeBuild = tipeBuild;
    }
}
