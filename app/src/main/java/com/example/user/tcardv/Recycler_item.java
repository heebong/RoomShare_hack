package com.example.user.tcardv;

/**
 * Created by USER on 2016-07-24.
 */
public class Recycler_item {
    int image;
    String title;
    String place;
    String price;
    String personnel;

    int getImage(){
        return this.image;
    }
    String getTitle(){
        return this.title;
    }
    String getPlace() { return this.place;}
    String getPrice() { return this.price;}
    String getPersonnel() { return this.personnel;}

    Recycler_item(int image, String title, String place, String price, String personnel){
        this.image=image;
        this.title=title;
        this.place=place;
        this.price=price;
        this.personnel=personnel;
    }
}
