package com.example.demo.dao;

import com.example.demo.model.Ride;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class MapBasedRideDao implements RideDao {

    private final HashMap<String, Ride> rideDetails;

    public MapBasedRideDao() {
        rideDetails = new HashMap<>();
    }
    @Override
    public Optional<Ride> getRideDetails(String rideid) {
        if (!rideDetails.containsKey(rideid)) {
            return Optional.empty();
        }
        return Optional.of(rideDetails.get(rideid));
    }

    @Override
    public void addRide(Ride ride) {
        rideDetails.put(ride.getRideId(), ride);
    }
}
