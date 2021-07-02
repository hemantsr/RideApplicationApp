package com.example.demo.dao;

import com.example.demo.model.Cab;
import com.example.demo.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class MapBasedCabDao implements CabDao {

    private final HashMap<String, Cab> cabDetails;
    private final HashMap<String, Location> cabLocation;
    private final List<String> freeCabs;
    private final List<String> occupiedCabs;

    public MapBasedCabDao() {
        this.cabDetails = new HashMap<>();
        cabLocation = new HashMap<>();
        freeCabs = new ArrayList<>();
        occupiedCabs = new ArrayList<>();
    }

    @Override
    public void addCab(final Cab cab) {
        cabDetails.put(cab.getId(), cab);
        freeCabs.add(cab.getId());
    }

    @Override
    public Optional<Cab> getCabDetails(String cabId) {
        if (!cabDetails.containsKey(cabId)) {
            return Optional.empty();
        }
        return Optional.of(cabDetails.get(cabId));
    }

    @Override
    public void updateCabLocation(Location location, String cabId) {
        cabLocation.put(cabId, location);
    }

    @Override
    public Location getCabLocation(String cabId) {
        return cabLocation.get(cabId);
    }

    @Override
    public void bookCab(String cabId) {
        occupiedCabs.add(cabId);
        freeCabs.remove(cabId);
    }

    @Override
    public List<String> getFreeCabs() {
        return freeCabs;
    }

    @Override
    public void deActivcateCab(String cabId) {
        occupiedCabs.add(cabId);
        freeCabs.remove(cabId);
    }

}
