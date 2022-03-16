
package com.dbdperks.api.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Survivor {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private Object fullName;
    @SerializedName("name_tag")
    @Expose
    private String nameTag;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("voice_actor")
    @Expose
    private String voiceActor;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("lore")
    @Expose
    private String lore;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("dlc")
    @Expose
    private String dlc;
    @SerializedName("dlc_id")
    @Expose
    private Integer dlcId;
    @SerializedName("is_free")
    @Expose
    private Boolean isFree;
    @SerializedName("is_ptb")
    @Expose
    private Boolean isPtb;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("perks")
    @Expose
    private List<String> perks = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getFullName() {
        return fullName;
    }

    public void setFullName(Object fullName) {
        this.fullName = fullName;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVoiceActor() {
        return voiceActor;
    }

    public void setVoiceActor(String voiceActor) {
        this.voiceActor = voiceActor;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDlc() {
        return dlc;
    }

    public void setDlc(String dlc) {
        this.dlc = dlc;
    }

    public Integer getDlcId() {
        return dlcId;
    }

    public void setDlcId(Integer dlcId) {
        this.dlcId = dlcId;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Boolean getIsPtb() {
        return isPtb;
    }

    public void setIsPtb(Boolean isPtb) {
        this.isPtb = isPtb;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public List<String> getPerks() {
        return perks;
    }

    public void setPerks(List<String> perks) {
        this.perks = perks;
    }

}
