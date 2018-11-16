package com.example.microweatherbasic.service;

import com.example.microweatherbasic.vo.Forecast;
import com.example.microweatherbasic.vo.Weather;
import com.example.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
// TODO 改为由天气数据API微服务来提供数据

       WeatherResponse response=dataClient.getDataByCityId(cityId);

       return response.getData();
    }
}
