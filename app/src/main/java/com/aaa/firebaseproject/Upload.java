package com.aaa.firebaseproject;

public class Upload {
    private String mTitle;
    private String mImageUrl;
    private String mDescription;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String title, String imageUrl, String description) {

        if (title.trim().equals("")) {
            title = "No Title";
        }

        mTitle = title;
        mImageUrl = imageUrl;
        mDescription = description;
    }
    public String getmTitle(){
        return mTitle;
    }
    public void setmTitle(String title) {
        mTitle = title;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }
    public void setmImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getmDescription(){
        return mDescription;
    }
    public void setmDescription(String description) {
        mDescription = description;
    }
}
