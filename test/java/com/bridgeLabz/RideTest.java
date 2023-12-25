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
    //UC4
    @Test
    public void givenUserIDretrieveInvoice_ShouldMatchProper() throws  Exception{
        RiderService riderService= new RiderService();
        List<Map<String,Object>> riderMapList= new ArrayList<>();
        riderMapList= riderService.retriveRidersInvoiceGroupByID();
        Assertions.assertEquals(3,riderMapList.size());
        // checking all the initials of userID 1
        Assertions.assertEquals(3,riderMapList.get(0).get("TotalRideNo"));
        Assertions.assertEquals(35.666666666666664,riderMapList.get(0).get("AvgFare"));
        Assertions.assertEquals(107.0,riderMapList.get(0).get("TotalFare"));
    }

}