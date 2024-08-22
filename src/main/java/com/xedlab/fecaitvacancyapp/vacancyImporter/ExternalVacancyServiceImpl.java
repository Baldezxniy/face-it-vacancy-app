package com.xedlab.fecaitvacancyapp.vacancyImporter;

import com.xedlab.fecaitvacancyapp.vacancyImporter.dto.Vacancies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class ExternalVacancyServiceImpl implements ExternalVacancyService {

  private static final Logger LOG = LoggerFactory.getLogger(ExternalVacancyServiceImpl.class);

  private final String URI;
  private final RestTemplate restTemplate;

  public ExternalVacancyServiceImpl(
          RestTemplate restTemplate,
          @Value("${vacancy-importer.api.url}") String uri
  ) {
    this.restTemplate = restTemplate;
    this.URI = uri;
  }

  @Override
  public Optional<Vacancies> getVacanciesByNumberPage(int pageNumber) {

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(URI)
            .queryParam("page", pageNumber);

    try {
      ResponseEntity<Vacancies> responseEntity =
              restTemplate.getForEntity(uriBuilder.toUriString(), Vacancies.class);

      Vacancies vacancies = responseEntity.getBody();

      return Optional.ofNullable(vacancies);

    } catch (HttpClientErrorException.BadRequest e) {
      LOG.debug(e.getMessage());
      throw new RuntimeException("BadRequest");
    } catch (HttpClientErrorException.Forbidden e) {
      LOG.debug(e.getMessage());
      throw new RuntimeException("Forbidden");
    } catch (Exception e) {
      LOG.debug(e.getMessage());
      throw new RuntimeException("Something happen");
    }
  }
}
