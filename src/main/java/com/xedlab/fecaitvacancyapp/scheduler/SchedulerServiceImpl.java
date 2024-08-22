package com.xedlab.fecaitvacancyapp.scheduler;

import com.xedlab.fecaitvacancyapp.scheduler.props.SchedulerConfigProperties;
import com.xedlab.fecaitvacancyapp.vacancyImporter.ExternalVacancyService;
import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancies;
import com.xedlab.fecaitvacancyapp.vacancyStorage.VacancyStorageService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SchedulerServiceImpl implements SchedulerService {

  private final ScheduledExecutorService executorService;
  private final SchedulerConfigProperties schedulerConfig;

  private final ExternalVacancyService vacancyImporter;
  private final VacancyStorageService vacancyStorageService;

  public SchedulerServiceImpl(
          ScheduledExecutorService executorService,
          SchedulerConfigProperties schedulerConfig,

          ExternalVacancyService vacancyImporter,
          VacancyStorageService vacancyStorageService
  ) {
    this.executorService = executorService;
    this.schedulerConfig = schedulerConfig;

    this.vacancyImporter = vacancyImporter;
    this.vacancyStorageService = vacancyStorageService;
  }

  @PostConstruct
  private void init() {
    initVacancies();
    scheduleVacancies();
  }

  private void initVacancies() {
    for (int i = schedulerConfig.getFirstPage(); i <= schedulerConfig.getLastPage(); i++) {
      Optional<Vacancies> vacancies = vacancyImporter.getVacanciesByNumberPage(i);
      vacancies.ifPresent(vacancyStorageService::saveVacancy);
    }
  }

  @Override
  public void scheduleVacancies() {
    executorService.scheduleWithFixedDelay(() -> {
      Optional<Vacancies> vacancies = vacancyImporter.getVacanciesByNumberPage(1);
      vacancies.ifPresent(vacancyStorageService::saveVacancy);
    }, schedulerConfig.getDelayOnMinutes(), schedulerConfig.getDelayOnMinutes(), TimeUnit.MINUTES);
  }

}
