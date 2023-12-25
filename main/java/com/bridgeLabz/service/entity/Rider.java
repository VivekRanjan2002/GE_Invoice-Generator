package com.bridgeLabz.service.entity;

public class Rider {
    public int UserID;
    public double distance;
    public double time;
    public double Fare;

    public Rider(int UserID,double distance, double time){
        this.UserID=UserID;
        this.distance=distance;
        this.time=time;
    }
    public Rider(int UserID,double distance,double time, double Fare){
        this(UserID,distance,time);
        this.Fare=Fare;
    }
    
}
