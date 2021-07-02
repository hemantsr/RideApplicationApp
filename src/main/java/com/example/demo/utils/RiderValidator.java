package com.example.demo.utils;

import com.example.demo.model.Rider;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class RiderValidator {

    public static boolean validateRider(Rider rider) {

        if (Objects.isNull(rider)) {
            return false;
        }

        if (StringUtils.isEmpty(rider.getId())) {
            return false;
        }

        if (Objects.isNull(rider.getName()) || StringUtils.isEmpty(rider.getName().getFirstName())) {
            return false;
        }
        return true;
    }
}
