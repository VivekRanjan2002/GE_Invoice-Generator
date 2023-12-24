package com.bridgeLabz.service;
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
}
