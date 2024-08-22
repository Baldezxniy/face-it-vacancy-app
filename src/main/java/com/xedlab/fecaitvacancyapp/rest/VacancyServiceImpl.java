package com.xedlab.fecaitvacancyapp.rest;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyDto;
import com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto;
import com.xedlab.fecaitvacancyapp.utils.mapper.VacancyMapper;
import com.xedlab.fecaitvacancyapp.vacancyStorage.VacancyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

  private final VacancyRepository vacancyRepository;
  private final VacancyMapper vacancyMapper;

  public VacancyServiceImpl(
          VacancyRepository vacancyRepository,
          VacancyMapper vacancyMapper
  ) {
    this.vacancyRepository = vacancyRepository;
    this.vacancyMapper = vacancyMapper;
  }

  @Override
  public Page<VacancyDto> getAll(Pageable pageable) {
    return vacancyRepository.findAll(pageable)
            .map(vacancyMapper::toDto);
  }

  @Override
  public List<VacancyDto> getTop10() {
    return vacancyRepository.findTop10().stream()
            .map(vacancyMapper::toDto)
            .toList();
  }

  @Override
  public Page<VacancyLocationStatisticDto> getLocationStatistic(Pageable pageable) {
    return vacancyRepository.findStatisticLocation(pageable);
  }
}
