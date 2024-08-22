package com.xedlab.fecaitvacancyapp.rest;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyDto;
import com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/vacancies")
public class VacancyController {

  private final VacancyService vacancyService;

  public VacancyController(
          VacancyService vacancyService
  ) {
    this.vacancyService = vacancyService;
  }

  @GetMapping
  public Page<VacancyDto> getAll(Pageable pageable) {
    return vacancyService.getAll(pageable);
  }

  @GetMapping("/top-10")
  public List<VacancyDto> getTop10() {
    return vacancyService.getTop10();
  }

  @GetMapping("/statistic/location")
  public Page<VacancyLocationStatisticDto> getStatisticLocation(Pageable pageable) {
    return vacancyService.getLocationStatistic(pageable);
  }
}
