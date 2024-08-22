package com.xedlab.fecaitvacancyapp.vacancyImporter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VacanciesLink(

        @JsonProperty("first")
        String first,

        @JsonProperty("last")
        String last,

        @JsonProperty("prev")
        String prev,

        @JsonProperty("next")
        String next
) {

}
