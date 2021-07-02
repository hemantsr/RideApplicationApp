package com.example.demo.finder;

import com.example.demo.dao.CabDao;
import com.example.demo.dao.MapBasedCabDao;
import com.example.demo.model.Cab;
import com.example.demo.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DistanceBasedRideFinder implements RideFinder {

    private CabDao cabDao;

    @Autowired
    public DistanceBasedRideFinder(final MapBasedCabDao cabDao) {
        this.cabDao = cabDao;
    }


    @Override
    public List<Cab> findRides(Location userLocation) {
        Set<String> freeCabs = cabDao.getFreeCabs();
        return getFreeRidesInCircle(userLocation, freeCabs);
    }

    private List<Cab> getFreeRidesInCircle(Location location,
                                           Set<String> freeCabs) {

        List<Cab> allowedCabs = new ArrayList<>();
        for (String cabId : freeCabs) {
            Location cabLocation = cabDao.getCabLocation(cabId);
            if (isInArea(location, cabLocation)) {
                allowedCabs.add(cabDao.getCabDetails(cabId).get());
            }
        }
        return allowedCabs;
    }

    private boolean isInArea(Location userLocation,
                             Location cabLocation) {
        double distance =  Math.sqrt(Math.pow(userLocation.getLatitude() - cabLocation.getLatitude(), 2)
                + Math.pow(userLocation.getLongitude() - cabLocation.getLongitude(), 2));

        return !(distance > 3.0);
    }
}
