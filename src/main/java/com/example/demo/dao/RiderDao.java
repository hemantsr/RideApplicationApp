package com.example.demo.dao;

import com.example.demo.model.Ride;
import com.example.demo.model.Rider;

import java.util.List;

public interface RiderDao {

    public void addRider(Rider rider);

    public void addRideToRider(Ride ride);

    public List<String> getUserRideIds(String riderId);
}
