package com.example.microweathereurekaserver.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
        @GetMapping("/cities")
        String listCity();
    }


