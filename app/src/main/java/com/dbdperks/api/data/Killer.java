
package com.dbdperks.api.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Killer {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_tag")
    @Expose
    private String nameTag;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("realm")
    @Expose
    private String realm;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("weapon")
    @Expose
    private String weapon;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("terror_radius")
    @Expose
    private String terrorRadius;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("voice_actor")
    @Expose
    private String voiceActor;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("lore")
    @Expose
    private String lore;
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

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTerrorRadius() {
        return terrorRadius;
    }

    public void setTerrorRadius(String terrorRadius) {
        this.terrorRadius = terrorRadius;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getVoiceActor() {
        return voiceActor;
    }

    public void setVoiceActor(String voiceActor) {
        this.voiceActor = voiceActor;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
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
