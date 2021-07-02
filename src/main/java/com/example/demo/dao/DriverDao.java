package com.example.demo.dao;

import com.example.demo.model.Driver;

import java.util.Optional;

public interface DriverDao {

    public void addDriver(final Driver driver);
    public Optional<Driver> getDriver(final String driverId);
    public void mapCabToDriver(String driverId,
                               String cabId);
    public void driverLogOff(String driverId);
}
