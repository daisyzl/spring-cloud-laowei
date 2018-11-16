package com.example.microweatherbasic.job;

import com.example.microweatherbasic.service.CityClient;
import com.example.microweatherbasic.service.WeatherDataCollectionService;
import com.example.microweatherbasic.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/*
天气数据同步任务
 */

public class WeatherDataSyncJob extends QuartzJobBean {


    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;


    @Autowired
    private CityClient cityClient;

    /* (non-Javadoc)
     * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Start 天气数据同步任务");

        // TODO 改为由城市数据API微服务来提供数据

        List<City> cityList = null;
        try {
            //TODO调用城市数据API
            cityList=cityClient.listCity();


        } catch (Exception e) {
            logger.error("获取城市信息异常！", e);
            throw new RuntimeException("获取城市信息异常！",e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("天气数据同步任务中，cityId:" + cityId);

            // 根据城市ID获取天气
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("End 天气数据同步任务");
    }
}
