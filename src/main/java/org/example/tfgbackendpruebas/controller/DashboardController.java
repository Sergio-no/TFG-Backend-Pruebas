package org.example.tfgbackendpruebas.controller;

import org.example.tfgbackendpruebas.dto.response.DashboardResponse;
import org.example.tfgbackendpruebas.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboard() {
        return ResponseEntity.ok(dashboardService.getDashboard());
    }
}