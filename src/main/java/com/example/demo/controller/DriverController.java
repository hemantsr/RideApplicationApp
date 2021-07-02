package com.example.demo.controller;

import com.example.demo.dao.DriverDao;
import com.example.demo.dao.MapBasedDriverDao;
import com.example.demo.model.Driver;
import com.example.demo.request.MapCabToDriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
public class DriverController {

    private final DriverDao driverDao;

    @Autowired
    public DriverController(final MapBasedDriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @PostMapping("/driver/register")
    public void addDriver(@RequestBody final Driver driver) {
        //TODO: add validation.
        driverDao.addDriver(driver);
    }

    @GetMapping("/driver/getDetails")
    public Driver getDriverDetails(String driverId) {
        Optional<Driver> driver = driverDao.getDriver(driverId);
        return driver.orElse(null);
    }

    @PutMapping("driver/mapCab")
    public void mapCabToDriver(@RequestBody MapCabToDriverRequest request) {
        driverDao.mapCabToDriver(request.getDriverId(), request.getCabId());
    }

    @PutMapping("driver/logOff")
    public void driverLogOff(String driverId) {
        driverDao.driverLogOff(driverId);
    }
}
