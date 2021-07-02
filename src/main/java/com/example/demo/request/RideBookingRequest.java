package com.example.demo.request;

import com.example.demo.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RideBookingRequest {
    final String riderId;
    final String cabId;
    final Location start;
    final Location end;
}
