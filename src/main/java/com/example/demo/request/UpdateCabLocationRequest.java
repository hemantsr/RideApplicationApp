package com.example.demo.request;

import com.example.demo.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateCabLocationRequest {

    final Location location;
    final String cabId;
}
