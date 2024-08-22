package com.xedlab.fecaitvacancyapp.vacancyImporter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Vacancy(

        @JsonProperty("slug")
        String slug,

        @JsonProperty("company_name")
        String companyName,

        @JsonProperty("title")
        String title,

        @JsonProperty("description")
        String description,

        @JsonProperty("remote")
        boolean remote,

        @JsonProperty("url")
        String url,

        @JsonProperty("tags")
        List<String> tags,

        @JsonProperty("job_types")
        List<String> jobTypes,

        @JsonProperty("location")
        String location
) {

}
