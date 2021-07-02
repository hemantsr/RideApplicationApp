package com.example.demo.finder;

import com.example.demo.model.Cab;
import com.example.demo.model.Location;

import java.util.List;

public interface RideFinder {

    public List<Cab> findRides(final Location userLocation);
}
