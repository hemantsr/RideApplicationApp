package com.example.demo.dao;

import com.example.demo.model.Ride;

import java.util.Optional;

public interface RideDao {

    public Optional<Ride> getRideDetails(String rideid);
    public void addRide(Ride ride);
}
