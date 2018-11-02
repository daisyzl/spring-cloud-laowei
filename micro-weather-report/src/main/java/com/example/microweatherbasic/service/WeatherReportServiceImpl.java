package com.example.microweatherbasic.service;

import com.example.microweatherbasic.vo.Weather;
import com.example.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataServiceImpl;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse result = weatherDataServiceImpl.getDataByCityId(cityId);
        return result.getData();
    }
}
