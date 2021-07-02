package com.example.demo.dao;

import com.example.demo.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;

@Component
public class MapBasedDriverDao implements DriverDao {

    private final HashMap<String, Driver> dirverDetails;
    private final HashMap<String, String> driverToCabMap;
    private final CabDao cabDao;

    @Autowired
    public MapBasedDriverDao(MapBasedCabDao mapBasedCabDao) {
        dirverDetails = new HashMap<>();
        driverToCabMap = new HashMap<>();
        this.cabDao = mapBasedCabDao;
    }
    @Override
    public void addDriver(Driver driver) {
        dirverDetails.put(driver.getId(), driver);
    }

    @Override
    public Optional<Driver> getDriver(String driverId) {
        if (!dirverDetails.containsKey(driverId)) {
            return Optional.empty();
        }
        return Optional.of(dirverDetails.get(driverId));
    }

    @Override
    public void mapCabToDriver(String driverId, String cabId) {
        driverToCabMap.put(driverId, cabId);
    }

    @Override
    public void driverLogOff(String driverId) {
        final String cabId = driverToCabMap.get(driverId);
        cabDao.deActivcateCab(cabId);
    }
}
