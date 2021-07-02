package com.example.demo.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    private  String rideId;
    private  String riderId;
    private  String cabId;
    private  Location startLocation;
    private  Location endLocation;
    private  long startTime;
    private  long endTime;
}
