package com.dbdperks.api.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perks implements Parcelable{

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

    protected Perks(Parcel in) {
        id = in.readString();
        role = in.readString();
        name = in.readString();
        nameTag = in.readString();
        perkName = in.readString();
        perkTag = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            teachLevel = null;
        } else {
            teachLevel = in.readInt();
        }
        byte tmpIsPtb = in.readByte();
        isPtb = tmpIsPtb == 0 ? null : tmpIsPtb == 1;
        lang = in.readString();
        icon = in.readString();
    }

    public static final Creator<Perks> CREATOR = new Creator<Perks>() {
        @Override
        public Perks createFromParcel(Parcel in) {
            return new Perks(in);
        }

        @Override
        public Perks[] newArray(int size) {
            return new Perks[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(role);
        parcel.writeString(name);
        parcel.writeString(nameTag);
        parcel.writeString(perkName);
        parcel.writeString(perkTag);
        parcel.writeString(description);
        if (teachLevel == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(teachLevel);
        }
        parcel.writeByte((byte) (isPtb == null ? 0 : isPtb ? 1 : 2));
        parcel.writeString(lang);
        parcel.writeString(icon);
    }
}