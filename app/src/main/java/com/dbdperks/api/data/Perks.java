package com.dbdperks.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perks {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("role")
@Expose
private String role;
@SerializedName("name")
@Expose
private String name;
@SerializedName("name_tag")
@Expose
private String nameTag;
@SerializedName("perk_name")
@Expose
private String perkName;
@SerializedName("perk_tag")
@Expose
private String perkTag;
@SerializedName("description")
@Expose
private String description;
@SerializedName("teach_level")
@Expose
private Integer teachLevel;
@SerializedName("is_ptb")
@Expose
private Boolean isPtb;
@SerializedName("lang")
@Expose
private String lang;
@SerializedName("icon")
@Expose
private String icon;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getRole() {
return role;
}

public void setRole(String role) {
this.role = role;
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

public String getPerkName() {
return perkName;
}

public void setPerkName(String perkName) {
this.perkName = perkName;
}

public String getPerkTag() {
return perkTag;
}

public void setPerkTag(String perkTag) {
this.perkTag = perkTag;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getTeachLevel() {
return teachLevel;
}

public void setTeachLevel(Integer teachLevel) {
this.teachLevel = teachLevel;
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

public String getIcon() {
return icon;
}

public void setIcon(String icon) {
this.icon = icon;
}

}