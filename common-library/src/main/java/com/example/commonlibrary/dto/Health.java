
package com.example.commonlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Health {

    @JsonProperty("Subscriber")
    private Subscriber subscriber;
    @JsonProperty("Patient")
    private Patient patient;
    @JsonProperty("Case")
    private Case _case;
    @JsonProperty("Service")
    private Service service;

}
