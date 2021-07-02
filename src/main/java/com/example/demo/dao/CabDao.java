package com.example.demo.dao;

import com.example.demo.model.Cab;
import com.example.demo.model.Location;

import java.util.Optional;
import java.util.Set;

public interface CabDao {

    public void addCab(final Cab cab);
    public Optional<Cab> getCabDetails(final String cabId);
    public void updateCabLocation(final Location location,
                                  final String cabId);

    public Location getCabLocation(final String cabId);

    public void bookCab(final String cabId);
    public Set<String> getFreeCabs();
    public void deActivcateCab(String cabId);
}
