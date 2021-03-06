package com.digdes.school.app.service.impl;

import com.digdes.school.app.model.Forecast;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 *  Testing parser.
 *
 *  @author Ilya Ashikhmin (ashikhmin.ilya@gmail.com)
 */
public class ForecastParserImplTest {
    @Test
    public void testParser() throws IOException {
        ForecastParserImpl parser = new ForecastParserImpl();

        String xml = IOUtils.toString(this.getClass()
                .getResourceAsStream("/weather.xml"), "utf8");
        List<Forecast> forecasts = parser.parse(xml);
        assertNotNull(forecasts);
        assertEquals(forecasts.size(), 4);
        for (Forecast forecast : forecasts) {
            assertNotNull(forecast.getDate());
            assertTrue(forecast.getTemperatureMax() > forecast.getTemperatureMin());
        }
    }
}