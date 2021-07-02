package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.finder.DistanceBasedRideFinder;
import com.example.demo.finder.RideFinder;
import com.example.demo.model.Cab;
import com.example.demo.model.Location;
import com.example.demo.model.Ride;
import com.example.demo.request.RideBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class RideController {

    private final CabDao cabDao;
    private final RideDao rideDao;
    private final RideFinder rideFinder;
    private final RiderDao riderDao;

    @Autowired
    public RideController(final MapBasedCabDao mapBasedCabDao,
                          final MapBasedRideDao mapBasedRideDao,
                          final DistanceBasedRideFinder rideFinder,
                          final MapBasedRiderDao riderDao) {
        this.cabDao = mapBasedCabDao;
        this.rideDao = mapBasedRideDao;
        this.rideFinder = rideFinder;
        this.riderDao = riderDao;
    }

    @PostMapping("/ride/getFreeCabs")
    public @ResponseBody List<Cab> getFreeCabs(@RequestBody final Location location) {
        return rideFinder.findRides(location);
    }

    @PostMapping("/ride/bookRide")
    public String bookRide(@RequestBody RideBookingRequest request) {
       Ride ride =  buildRide(request.getRiderId(), request.getCabId(), request.getStart(), request.getEnd());
        rideDao.addRide(ride);
        riderDao.addRideToRider(ride);
        return ride.getRideId();
    }

    @PostMapping("/ride/endRide")
    public void endRide(String rideId) {
        Optional<Ride> ride = rideDao.getRideDetails(rideId);
        if (ride.isPresent()) {
            ride.get().setEndTime(Instant.now().toEpochMilli());
        }

    }

    private Ride buildRide(String riderId,
                           String cabId,
                           final Location start,
                           final Location end) {
        return Ride.builder()
                .riderId(riderId)
                .rideId(UUID.randomUUID().toString())
                .cabId(cabId)
                .startLocation(start)
                .endLocation(end)
                .startTime(Instant.now().toEpochMilli())
                .build();
    }

}
