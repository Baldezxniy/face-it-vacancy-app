package com.xedlab.fecaitvacancyapp.rest.dto;

public record VacancyDto(
        String slug,

        String companyName,

        String title,

        String description,

        boolean remote,

        String url,

        String location
) {

}
