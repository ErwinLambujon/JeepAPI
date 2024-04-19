package com.JeepCode.jeepcode.Controller;

import com.JeepCode.jeepcode.Entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.JeepCode.jeepcode.Service.JeepService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/endpoint")
public class JeepRoutesController {

    @Autowired
    private JeepService jeepService;

    @GetMapping("jeep")
    public ResponseEntity<?> getWaypointsByRouteCodes(@RequestParam List<String> routeCodes) {
        Map<String, List<Map<String, Object>>> routeTable = new HashMap<>();

        for (String routeCode : routeCodes) {
            List<Waypoint> waypointsList = jeepService.getWaypointsByRouteCode(routeCode);
            List<Map<String, Object>> waypointsData = new ArrayList<>();

            for (Waypoint waypoint : waypointsList) {
                Map<String, Object> waypointData = new HashMap<>();
                waypointData.put("id", waypoint.getId());
                waypointData.put("name", waypoint.getName());
                waypointsData.add(waypointData);
            }

            routeTable.put(routeCode, waypointsData);
        }

        if (routeTable.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(routeTable);
        }
    }
}