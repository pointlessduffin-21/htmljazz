package xyz.yeems214.fblogin.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/distance")
public class DistanceMatrix {
    private final String API_KEY = "AIzaSyBKwt4NuTqH__0QG_rq7MYeVFCNnvX4tVc";

    @GetMapping("/{origin}/{destination}")
    public String getDistance(@PathVariable String origin, @PathVariable String destination) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + origin + "&destinations=" + destination + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Error retrieving distance";
        }
    }
}
