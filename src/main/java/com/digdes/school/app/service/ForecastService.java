package com.digdes.school.app.service;

import com.digdes.school.app.model.Forecast;

import java.util.List;

/**
 * Interface for Forecast Service
 *
 * @author Ilya Ashikhmin (ashikhmin.i@digdes.com)
 */
public interface ForecastService {
    List<Forecast> receiveForecasts(Long cityId);

    List<Forecast> savedForecasts(Long cityId);

    void updateForecast(Long cityId);
}
