package com.example.microweatherbasic.job;

import com.example.microweatherbasic.service.CityDataService;
import com.example.microweatherbasic.service.WeatherDataService;
import com.example.microweatherbasic.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/*
天气数据同步任务
 */

public class WeatherDataSyncJob extends QuartzJobBean {


    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataServiceImpl;

    @Autowired
    private WeatherDataService weatherDataServiceImpl;

    /* (non-Javadoc)
     * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Start 天气数据同步任务");

        // 读取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataServiceImpl.listCity();
        } catch (Exception e) {
            logger.error("获取城市信息异常！", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("天气数据同步任务中，cityId:" + cityId);

            // 根据城市ID获取天气
            weatherDataServiceImpl.syncDataByCityId(cityId);
        }

        logger.info("End 天气数据同步任务");
    }
}
