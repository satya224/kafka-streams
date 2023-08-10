
package com.example.commonlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("PAT_ID")
    private String patId;
    @JsonProperty("PAT_FIRST_NAME")
    private String patFirstName;
    @JsonProperty("PAT_MIDDLE_NAME")
    private String patMiddleName;
    @JsonProperty("PAT_LAST_NAME")
    private String patLastName;
    @JsonProperty("PAT_SEX")
    private String patSex;
    @JsonProperty("PAT_DOB")
    private String patDob;
    @JsonProperty("PAT_PLAN_TYPE")
    private String patPlanType;
    @JsonProperty("PAT_PLAN_NAME")
    private String patPlanName;

}
