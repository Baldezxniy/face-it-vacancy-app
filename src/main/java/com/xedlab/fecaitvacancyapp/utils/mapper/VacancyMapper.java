package com.xedlab.fecaitvacancyapp.utils.mapper;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyDto;
import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancy;
import com.xedlab.fecaitvacancyapp.vacancyStorage.VacancyEntity;
import org.springframework.stereotype.Component;

@Component
public class VacancyMapper {
  public VacancyEntity toEntity(Vacancy vacancy) {
    return new VacancyEntity(
            vacancy.slug(),
            vacancy.companyName(),
            vacancy.title(),
            vacancy.description(),
            vacancy.remote(),
            vacancy.url(),
            vacancy.location()
    );
  }

  public VacancyDto toDto(VacancyEntity entity) {
    return new VacancyDto(
            entity.slug(),
            entity.companyName(),
            entity.title(),
            entity.description(),
            entity.isRemote(),
            entity.url(),
            entity.location()
    );
  }
}
