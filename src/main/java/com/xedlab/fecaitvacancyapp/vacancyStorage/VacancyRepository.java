package com.xedlab.fecaitvacancyapp.vacancyStorage;

import com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacancyRepository extends JpaRepository<VacancyEntity, Long> {

  Page<VacancyEntity> findAll(Pageable pageable);

  @Query(value = """
          SELECT * FROM schema_vacancies.vacancies v
          LIMIT(10)
          """, nativeQuery = true)
  List<VacancyEntity> findTop10();

  @Query(value = """
          SELECT new com.xedlab.fecaitvacancyapp.rest.dto.VacancyLocationStatisticDto(v.location, COUNT(*))
          FROM VacancyEntity v
          GROUP BY v.location
          """,
          countQuery = """
                  SELECT COUNT(DISTINCT v.location)
                  FROM VacancyEntity v
                  """)
  Page<VacancyLocationStatisticDto> findStatisticLocation(Pageable pageable);

}
