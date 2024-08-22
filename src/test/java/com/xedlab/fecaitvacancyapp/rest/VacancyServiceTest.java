package com.xedlab.fecaitvacancyapp.rest;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyDto;
import com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto;
import com.xedlab.fecaitvacancyapp.utils.mapper.VacancyMapper;
import com.xedlab.fecaitvacancyapp.vacancyStorage.VacancyEntity;
import com.xedlab.fecaitvacancyapp.vacancyStorage.VacancyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VacancyServiceTest {

  private static final VacancyEntity VACANCY_ENTITY = new VacancyEntity("random-slug", "company-name", "title", "description", true, "url", "location");

  private static final VacancyDto VACANCY_DTO = new VacancyDto(VACANCY_ENTITY.slug(), VACANCY_ENTITY.companyName(), VACANCY_ENTITY.title(), VACANCY_ENTITY.description(), VACANCY_ENTITY.isRemote(), VACANCY_ENTITY.url(), VACANCY_ENTITY.location());

  @InjectMocks
  private VacancyServiceImpl vacancyService;

  @Mock
  private VacancyRepository vacancyRepository;

  @Mock
  private VacancyMapper vacancyMapper;

  @Test
  void getAll_shouldReturnPageOfVacancy_whenVacanciesExist() {
    // Arrange
    Pageable pageable = PageRequest.of(0, 10);

    Page<VacancyEntity> vacancyPage = new PageImpl<>(List.of(VACANCY_ENTITY));

    when(vacancyRepository.findAll(pageable)).thenReturn(vacancyPage);
    when(vacancyMapper.toDto(VACANCY_ENTITY)).thenReturn(VACANCY_DTO);

    // Act
    Page<VacancyDto> result = vacancyService.getAll(pageable);

    // Assert
    assertThat(result.getContent()).hasSize(1);
    assertThat(result.getContent().get(0)).isEqualTo(VACANCY_DTO);
  }

  @Test
  void getTop10_shouldReturnListOfVacancy_whenTop10VacanciesExist() {
    // Arrange
    when(vacancyRepository.findTop10()).thenReturn(List.of(VACANCY_ENTITY));
    when(vacancyMapper.toDto(VACANCY_ENTITY)).thenReturn(VACANCY_DTO);

    // Act
    List<VacancyDto> result = vacancyService.getTop10();

    // Assert
    assertThat(result).hasSize(1);
    assertThat(result.get(0)).isEqualTo(VACANCY_DTO);
  }

  @Test
  void getLocationStatistic_shouldReturnPageOfVacancyLocationStatistic_whenStatisticsExist() {
    // Arrange
    Pageable pageable = PageRequest.of(0, 10);
    VacancyLocationStatisticDto statisticDto = new VacancyLocationStatisticDto("location name", 101);
    Page<VacancyLocationStatisticDto> statisticPage = new PageImpl<>(List.of(statisticDto));

    when(vacancyRepository.findStatisticLocation(pageable)).thenReturn(statisticPage);

    // Act
    Page<VacancyLocationStatisticDto> result = vacancyService.getLocationStatistic(pageable);

    // Assert
    assertThat(result.getContent()).hasSize(1);
    assertThat(result.getContent().get(0)).isEqualTo(statisticDto);
  }

}