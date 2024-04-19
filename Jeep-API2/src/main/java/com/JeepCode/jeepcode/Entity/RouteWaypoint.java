package com.JeepCode.jeepcode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class RouteWaypoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private JeepRoutes jeepRoutes;

    @ManyToOne
    private Waypoint waypoint;
}