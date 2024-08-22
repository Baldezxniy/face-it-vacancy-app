package com.xedlab.fecaitvacancyapp.vacancyImporter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VacanciesMeta(

        @JsonProperty("current_page")
        int currentPage,

        @JsonProperty("from")
        int from,

        @JsonProperty("path")
        String path,

        @JsonProperty("per_page")
        int perPage,

        @JsonProperty("to")
        int to,

        @JsonProperty("terms")
        String terms,

        @JsonProperty("info")
        String info
) {

}
