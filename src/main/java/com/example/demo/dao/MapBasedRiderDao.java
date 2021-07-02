package com.example.demo.dao;

import com.example.demo.model.Ride;
import com.example.demo.model.Rider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MapBasedRiderDao implements RiderDao {

    private final HashMap<String, Rider> riderDetails;
    private final HashMap<String, List<String>> rideMap;

    public MapBasedRiderDao() {
        riderDetails = new HashMap<>();
        rideMap = new HashMap<>();
    }

    @Override
    public void addRider(Rider rider) {
        riderDetails.put(rider.getId(), rider);
    }

    public void addRideToRider(Ride ride) {
        if (rideMap.containsKey(ride.getRiderId())) {
            rideMap.get(ride.getRideId()).add(ride.getRideId());
        } else {
            List<String> list = new ArrayList();
            list.add(ride.getRideId());
            rideMap.put(ride.getRideId(),list);
        }
    }

    public List<String> getUserRideIds(String riderId) {
        if (!rideMap.containsKey(riderId)) {
            return new ArrayList<>();
        }
        return rideMap.get(riderId);
    }
}
