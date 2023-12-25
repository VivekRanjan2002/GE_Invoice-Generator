package com.bridgeLabz.service;
import com.bridgeLabz.service.entity.Rider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiderService {
    public RiderService(){};
    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO};
    private List<Rider> riderList;
    RiderDBService riderDBService= new RiderDBService();
    // read data of the rideRepository table
    public List<Rider> readRidersList(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.riderList= riderDBService.readData();
        return riderList;
    }
   // read Invoice generated of all the rides
    public Map<String, Object> retriveRidersInvoice() throws Exception {
        Map<String,Object> riderMap= new HashMap<>();
        riderMap= riderDBService.retrieveRidersDBInvoice();
    return riderMap;
    }
}
