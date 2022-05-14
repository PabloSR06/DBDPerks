package com.dbdperks.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Build {

    @SerializedName("id_Build")
    @Expose
    private Integer idBuild;
    @SerializedName("infoBuild")
    @Expose
    private String infoBuild;
    @SerializedName("nameBuild")
    @Expose
    private String nameBuild;
    @SerializedName("perk1_id")
    @Expose
    private String perk1Id;
    @SerializedName("perk2_id")
    @Expose
    private String perk2Id;
    @SerializedName("perk3_id")
    @Expose
    private String perk3Id;
    @SerializedName("perk4_id")
    @Expose
    private String perk4Id;
    @SerializedName("tipeBuild")
    @Expose
    private String tipeBuild;

    public Integer getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(Integer idBuild) {
        this.idBuild = idBuild;
    }

    public String getInfoBuild() {
        return infoBuild;
    }

    public void setInfoBuild(String infoBuild) {
        this.infoBuild = infoBuild;
    }

    public String getNameBuild() {
        return nameBuild;
    }

    public void setNameBuild(String nameBuild) {
        this.nameBuild = nameBuild;
    }

    public String getPerk1Id() {
        return perk1Id;
    }

    public void setPerk1Id(String perk1Id) {
        this.perk1Id = perk1Id;
    }

    public String getPerk2Id() {
        return perk2Id;
    }

    public void setPerk2Id(String perk2Id) {
        this.perk2Id = perk2Id;
    }

    public String getPerk3Id() {
        return perk3Id;
    }

    public void setPerk3Id(String perk3Id) {
        this.perk3Id = perk3Id;
    }

    public String getPerk4Id() {
        return perk4Id;
    }

    public void setPerk4Id(String perk4Id) {
        this.perk4Id = perk4Id;
    }

    public String getTipeBuild() {
        return tipeBuild;
    }

    public void setTipeBuild(String tipeBuild) {
        this.tipeBuild = tipeBuild;
    }
}
