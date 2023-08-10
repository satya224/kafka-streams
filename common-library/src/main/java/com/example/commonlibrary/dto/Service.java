
package com.example.commonlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("SVC_ID")
    private String svcId;
    @JsonProperty("SVC_TYPE")
    private String svcType;
    @JsonProperty("SVC_CODE")
    private String svcCode;
    @JsonProperty("SVC_FACE_ID")
    private String svcFaceId;
    @JsonProperty("SVC_FACE_NAME")
    private String svcFaceName;
    @JsonProperty("SVC_PHY_ID")
    private String svcPhyId;
    @JsonProperty("SVC_PHY_NAME")
    private String svcPhyName;

}
