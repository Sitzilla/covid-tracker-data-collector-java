package com.evansitzes.coviddatacollector.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CdcCovidGeo {

    private String caseMonth;

    private String resState;

    private String stateFipsCode;

    private String resCounty;

    private String countyFipsCode;

    private String ageGroup;

    private String sex;

    private String race;

    private String ethnicity;

    private String process;

    private String exposureYn;

    private String currentStatus;

    private String symptomStatus;

    private String hospYn;

    private String icuYn;

    private String deathYn;
}
