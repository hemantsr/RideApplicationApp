package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MapCabToDriverRequest {
    private String driverId;
    private String cabId;
}
