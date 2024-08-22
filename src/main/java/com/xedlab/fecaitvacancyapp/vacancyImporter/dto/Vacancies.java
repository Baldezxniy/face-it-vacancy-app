package com.xedlab.fecaitvacancyapp.vacancyImporter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Vacancies(
        @JsonProperty("data")
        List<Vacancy> data,

        @JsonProperty("links")

        VacanciesLink links,

        @JsonProperty("meta")
        VacanciesMeta meta
) {
}
