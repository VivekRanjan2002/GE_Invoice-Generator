package com.bridgeLabz.service.entity;

public class Rider {
    public int UserID;
    public String RideType;
    public double distance;
    public double time;
    public double Fare;

    public Rider(int UserID,String RideType,double distance,double time, double Fare){
        this.UserID=UserID;
        this.RideType=RideType;
        this.distance=distance;
        this.time=time;
        this.Fare=Fare;
    }
    
}
