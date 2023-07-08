package com.evansitzes.coviddatacollector;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CovidDataDTO implements Serializable {
    private String caseMonth;
    private String resCounty;
    private String ageGroup;

}