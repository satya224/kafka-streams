
package com.example.commonlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Case {

    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("CASE_TYPE")
    private String caseType;
    @JsonProperty("CASE_CODE")
    private String caseCode;
    @JsonProperty("CASE_START_DATE")
    private String caseStartDate;
    @JsonProperty("CASE_END_DATE")
    private String caseEndDate;
    @JsonProperty("CASE_AUTH_TYPE")
    private String caseAuthType;
    @JsonProperty("CASE_STATUS")
    private String caseStatus;

}
