package com.evansitzes.coviddatacollector.client;

import com.evansitzes.coviddatacollector.config.FeignClientConfig;
import com.evansitzes.coviddatacollector.model.CdcCovidGeo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "cdc-data", configuration = FeignClientConfig.class, url = "https://data.cdc.gov/resource/n8mc-b4w4.json")
public interface CdcCovidGeoClient {
    @GetMapping
    List <CdcCovidGeo> getAllData(@RequestParam(name = "$limit") int limit,
                                  @RequestParam(name = "$offset") int offset,
                                  @RequestParam(name = "$order") String order,
                                  @RequestParam(name = "case_month") String month);
}
