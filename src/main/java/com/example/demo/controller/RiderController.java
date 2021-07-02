package com.example.demo.controller;

import com.example.demo.dao.MapBasedRideDao;
import com.example.demo.dao.MapBasedRiderDao;
import com.example.demo.dao.RideDao;
import com.example.demo.dao.RiderDao;
import com.example.demo.model.Ride;
import com.example.demo.model.Rider;
import com.example.demo.utils.RiderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class RiderController {

    private final RiderDao riderDao;
    private final RideDao rideDao;

    @Autowired
    public RiderController(MapBasedRideDao mapBasedRideDao,
                           MapBasedRiderDao mapBasedRiderDao) {
        this.riderDao = mapBasedRiderDao;
        this.rideDao = mapBasedRideDao;
    }

    @PostMapping("/rider/register")
    public void registerRider(@RequestBody Rider rider) {
        if (RiderValidator.validateRider(rider)) {
            //log.info("Rider is not valid");
            System.out.println("Rider is not valid");
            return;
        }
        riderDao.addRider(rider);
    }

    @GetMapping("/rider/getrides")
    public List<Ride> getUserRides(String riderId) {
        if (StringUtils.isEmpty(riderId)) {
            //log.info("RiderId is not valid");
            System.out.println("RiderId is not valid");
            return new ArrayList<>();
        }
        List<String> rideIds = riderDao.getUserRideIds(riderId);
        return getAllUserRides(rideIds);
    }

    private List<Ride> getAllUserRides(List<String> rideIds) {
        List<Ride> userRides = new ArrayList<>();
        for (String rideId : rideIds) {
            Optional<Ride> ride = rideDao.getRideDetails(rideId);
            ride.ifPresent(userRides::add);
        }
        return userRides;
    }
}
