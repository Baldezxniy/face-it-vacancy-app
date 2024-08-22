package com.xedlab.fecaitvacancyapp.vacancyStorage;

import com.xedlab.fecaitvacancyapp.utils.mapper.VacancyMapper;
import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyStorageServiceImpl implements VacancyStorageService {

  private final VacancyRepository vacancyRepository;
  private final VacancyMapper vacancyMapper;

  public VacancyStorageServiceImpl(
          VacancyRepository vacancyRepository,
          VacancyMapper vacancyMapper
  ) {
    this.vacancyRepository = vacancyRepository;
    this.vacancyMapper = vacancyMapper;
  }

  @Override
  public void saveVacancy(Vacancies vacancies) {
    List<VacancyEntity> entities = vacancies.data().stream()
            .map(vacancyMapper::toEntity)
            .toList();

    vacancyRepository.saveAll(entities);
  }
}
