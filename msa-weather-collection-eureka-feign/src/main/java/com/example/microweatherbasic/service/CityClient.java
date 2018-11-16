package com.example.microweatherbasic.service;

import com.example.microweatherbasic.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 访问城市信息的客户端.
 *
 * @since 1.0.0 2017年11月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
    @GetMapping("/cities")
    List<City> listCity();
}
