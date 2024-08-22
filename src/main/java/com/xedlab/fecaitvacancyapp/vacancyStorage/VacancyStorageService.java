package com.xedlab.fecaitvacancyapp.vacancyStorage;

import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancies;

public interface VacancyStorageService {

  void saveVacancy(Vacancies vacancies);
}
