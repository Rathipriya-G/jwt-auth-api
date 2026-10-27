
package com.rathipriya.jwt_auth_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user/profile")
    public Map<String, String> userProfile() {
        return Map.of(
                "message", "Welcome! You are authenticated as a USER."
        );
    }

    @GetMapping("/admin/dashboard")
    public Map<String, String> adminDashboard() {
        return Map.of(
                "message", "Welcome to the ADMIN dashboard."
        );
    }
}
