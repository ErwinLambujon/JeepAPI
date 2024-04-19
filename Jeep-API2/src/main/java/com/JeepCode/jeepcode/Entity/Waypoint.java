package com.JeepCode.jeepcode.Entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Waypoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "waypoint")
    private List<RouteWaypoint> routeWaypointsList = new ArrayList<>();

}