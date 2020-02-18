package com.aaa.firebaseproject;

public class Upload {

    private String title;
    private String image;
    private String desc;

    public Upload(String title, String image, String desc) {
        this.title = title;
        this.image = image;
        this.desc = desc;
    }

    public Upload() {
        //empty constructor needed
    }

    public String getTitle(){ return title; }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage(){ return image; }
    public void setimage(String image) {
        this.image = image;
    }

    public String getDesc(){
        return desc;
    }
    public void setdesc(String desc) {
        this.desc = desc;
    }
}
