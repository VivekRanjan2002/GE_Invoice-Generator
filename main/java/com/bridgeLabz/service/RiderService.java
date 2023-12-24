package com.bridgeLabz.service;

import com.bridgeLabz.service.entity.Rider;

import java.util.List;

public class RiderService {
    /*
    @desc: calculate fare with  max of (Rs 5, Rs 10 per km plus total time spent)
    @oarams: distance as double, time as double
    @return: fare price as double
     */
    public static double  calculateFare(double distance, double time) {
    double fare= 10.0*distance+time;
    fare= Math.max(fare,5.0);
    return fare;
    }
    /*
    @desc: calculate total fare of the list containing various Rider object
     @params: List containing Rider object
     @return: total fare
     */
    public static double calculateFareMultipleRides(List<Rider> riders) {
        double fare = 0;
        for (Rider rider : riders) {
            fare +=  Math.max(5.0,10.0 * rider.distance + rider.time);
        }
        return fare;
    }
}
