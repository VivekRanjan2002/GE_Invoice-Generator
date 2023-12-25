package com.bridgeLabz;
import com.bridgeLabz.service.RiderService;
import com.bridgeLabz.service.entity.Rider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bridgeLabz.service.RiderService.IOService.DB_IO;

class RideTest {
    // UC1 and UC 2
    @Test
    public void givenTable_WhenRetrieved_shouldMatchProper(){
    RiderService riderService= new RiderService();
    List<Rider> riderList= riderService.readRidersList(DB_IO);
    Assertions.assertEquals(7,riderList.size());
    }

    //UC3
    @Test
    public void givenInvoice_WhenRetrieved_ShouldMatchProper() throws Exception {
        RiderService riderService= new RiderService();
        Map<String,Object> riderMap= new HashMap<>();
        riderMap= riderService.retriveRidersInvoice();
        Assertions.assertEquals(7,riderMap.get("TotalRideNo"));
        Assertions.assertEquals(34.714285714285715,riderMap.get("AvgFare"));
        Assertions.assertEquals(243.0,riderMap.get("TotalFare"));
    }

}