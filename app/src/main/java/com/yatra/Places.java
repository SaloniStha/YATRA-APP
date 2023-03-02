package com.yatra;

import java.util.jar.Attributes;

public class Places {
    int pic;
    String text;
    String desc;

//    public Places(int pic,String text) {
//        this.pic = pic;
//        this.text = text;
//    }

    public Places(int pic, String text, String desc) {
        this.pic = pic;
        this.text = text;
        this.desc = desc;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}