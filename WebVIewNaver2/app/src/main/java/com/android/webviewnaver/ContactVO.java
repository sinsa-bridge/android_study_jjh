package com.android.webviewnaver;

public class ContactVO {
    long photoid;
    String phonenum;
    String name;

    public ContactVO() {}

    public ContactVO(long photoid, String phonenum, String name) {
        this.photoid = photoid;
        this.phonenum = phonenum;
        this.name = name;
    }

    public long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(long photoid) {
        this.photoid = photoid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
