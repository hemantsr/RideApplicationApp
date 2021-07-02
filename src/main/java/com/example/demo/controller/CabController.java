package com.example.demo.controller;

import com.example.demo.dao.CabDao;
import com.example.demo.dao.MapBasedCabDao;
import com.example.demo.model.Cab;
import com.example.demo.request.UpdateCabLocationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CabController {

    private final CabDao cabDao;

    @Autowired
    public CabController(final MapBasedCabDao cabDao) {
        this.cabDao = cabDao;
    }

    @PostMapping("/cab/register")
    public void registerCab(@RequestBody final Cab cab) {
        // TODO: add cab validation/.
        cabDao.addCab(cab);
    }

    @PostMapping("cab/updateLocation")
    public void updateCabLocation(@RequestBody UpdateCabLocationRequest request) {
        cabDao.updateCabLocation(request.getLocation(), request.getCabId());
    }
}
