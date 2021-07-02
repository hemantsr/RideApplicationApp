package com.example.demo.dao;

import com.example.demo.model.Cab;
import com.example.demo.model.Location;

import java.util.List;
import java.util.Optional;

public interface CabDao {

    public void addCab(final Cab cab);
    public Optional<Cab> getCabDetails(final String cabId);
    public void updateCabLocation(final Location location,
                                  final String cabId);

    public Location getCabLocation(final String cabId);

    public void bookCab(final String cabId);
    public List<String> getFreeCabs();
    public void deActivcateCab(String cabId);
}
