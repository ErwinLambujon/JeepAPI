package com.JeepCode.jeepcode.Repository;

import com.JeepCode.jeepcode.Entity.JeepRoutes;
import com.JeepCode.jeepcode.Entity.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


public interface JeepRoutesRepo extends JpaRepository<JeepRoutes, Long> {
    List<JeepRoutes> findByRouteCodes(String routeCodes);
}