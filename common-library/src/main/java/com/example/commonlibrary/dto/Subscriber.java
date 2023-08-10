
package com.example.commonlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber {

    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("MEM_ID")
    private String memId;
    @JsonProperty("MEM_FIRST_NAME")
    private String memFirstName;
    @JsonProperty("MEM_MIDDLE_NAME")
    private String memMiddleName;
    @JsonProperty("MEM_LAST_NAME")
    private String memLastName;
    @JsonProperty("MEM_ADD_1")
    private String memAdd1;
    @JsonProperty("MEM_ADD_2")
    private String memAdd2;
    @JsonProperty("MEM_CITY")
    private String memCity;
    @JsonProperty("MEM_PIN")
    private String memPin;

}
