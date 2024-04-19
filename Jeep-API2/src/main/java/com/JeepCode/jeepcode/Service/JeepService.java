package com.JeepCode.jeepcode.Service;

import com.JeepCode.jeepcode.Entity.JeepRoutes;
import com.JeepCode.jeepcode.Entity.RouteWaypoint;
import com.JeepCode.jeepcode.Entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JeepCode.jeepcode.Repository.JeepRoutesRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JeepService {

    @Autowired
    private JeepRoutesRepo jeepRepo;

    public List<Waypoint> getWaypointsByRouteCode(String routeCode) {
        List<JeepRoutes> routesList = jeepRepo.findByRouteCodes(routeCode);

        List<Waypoint> waypointsList = new ArrayList<>();
        for (JeepRoutes route : routesList) {
            List<RouteWaypoint> routeWaypoints = route.getRouteWaypointsList();
            for (RouteWaypoint routeWaypoint : routeWaypoints) {
                waypointsList.add(routeWaypoint.getWaypoint());
            }
        }
        return waypointsList;
    }

}