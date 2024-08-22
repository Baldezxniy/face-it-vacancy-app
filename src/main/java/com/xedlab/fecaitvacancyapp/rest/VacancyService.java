package com.xedlab.fecaitvacancyapp.rest;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyDto;
import com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacancyService {

  Page<VacancyDto> getAll(Pageable pageable);

  List<VacancyDto> getTop10();

  Page<VacancyLocationStatisticDto> getLocationStatistic(Pageable pageable);
}
