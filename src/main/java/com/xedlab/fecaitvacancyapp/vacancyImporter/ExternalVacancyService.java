package com.xedlab.fecaitvacancyapp.vacancyImporter;

import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancies;

import java.util.Optional;

public interface ExternalVacancyService {

  Optional<Vacancies> getVacanciesByNumberPage(int pageNumber);
}
