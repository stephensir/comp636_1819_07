package com.stephensir.recyclerviewdemo;

public class ItemData {

    private String title;
    private int imageUrl;

    public ItemData(String title,int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
    }
    // getters & setters
    public void setTitle(String t){
        title = t;
    }

    public String getTitle(){
        return title;
    }

    public void setImageUrl(int i){
        imageUrl = i;
    }

    public int getImageUrl(){
        return imageUrl;
    }

}
