package com.JeepCode.jeepcode.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class JeepRoutes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String routeCodes;

    @OneToMany(mappedBy = "jeepRoutes")
    private List<RouteWaypoint> routeWaypointsList = new ArrayList<>();

}
