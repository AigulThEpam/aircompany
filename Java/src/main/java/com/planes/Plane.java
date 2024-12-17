package com.planes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Plane {
    public String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;
}