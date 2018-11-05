package com.example.microweatherbasic.service;

import com.example.microweatherbasic.vo.City;

import java.util.List;

public interface CityDataService {
    /**
     * 获取城市列表.
     *
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;

}
