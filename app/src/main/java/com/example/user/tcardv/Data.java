package com.example.user.tcardv;

import java.io.Serializable;

public class Data implements Serializable {

    public String title;
    public String address;
    public String price;
    public String living_people;
    public String recruit_people;
    public String content;

    public Data() {}

    public Data(String title, String address, String price, String living_people, String recruit_people, String content) {

        this.title = title;
        this.address = address;
        this.price = price;
        this.living_people = living_people;
        this.recruit_people = recruit_people;
        this.content = content;
    }

    public void setData(String title, String address, String price, String living_people, String recruit_people, String content) {
        this.title = title;
        this.address = address;
        this.price = price;
        this.living_people = living_people;
        this.recruit_people = recruit_people;
        this.content = content;
    }
}
