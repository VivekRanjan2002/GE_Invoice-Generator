package com.bridgeLabz;
import com.bridgeLabz.service.RiderService;
import com.bridgeLabz.service.entity.Rider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class RideTest {
    // UC1
    @Test
    public void Km5_With_min5_should_return_totalFare_Rs15(){
        Rider rider= new Rider(1,5.0,5.0);
        Assertions.assertEquals(55.0, RiderService.calculateFare(rider.distance,rider.time));
    }
    @Test
    public void hundredmetre_With_one_min_should_return_totalFare_Rs5(){
        Rider rider= new Rider(1,0.1,1.0);
        Assertions.assertEquals(5.0, RiderService.calculateFare(rider.distance,rider.time));

    }


}