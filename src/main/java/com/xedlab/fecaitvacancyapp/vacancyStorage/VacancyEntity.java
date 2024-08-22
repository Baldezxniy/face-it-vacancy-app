package com.xedlab.fecaitvacancyapp.vacancyStorage;


import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
@Table(name = "vacancies", schema = "schema_vacancies")
public class VacancyEntity {

  @Id
  private String slug;

  private String companyName;

  private String title;

  private String description;

  private boolean remote;

  private String url;

  private String location;

  public VacancyEntity(
          String slug,
          String companyName,
          String title,
          String description,
          boolean remote,
          String url,
          String location
  ) {
    Assert.notNull(slug, "Slug must not be null");
    Assert.notNull(companyName, "Company name must not be null");
    Assert.notNull(title, "Title must not be null");
    Assert.notNull(description, "Description must not be null");
    Assert.notNull(url, "Url must not be null");
    Assert.notNull(location, "Location must not be null");

    this.slug = slug;
    this.companyName = companyName;
    this.title = title;
    this.description = description;
    this.remote = remote;
    this.url = url;
    this.location = location;
  }

  public String slug() {
    return slug;
  }

  public String companyName() {
    return companyName;
  }

  public String title() {
    return title;
  }

  public String description() {
    return description;
  }

  public boolean isRemote() {
    return remote;
  }

  public String url() {
    return url;
  }

  public String location() {
    return location;
  }

  protected VacancyEntity() {
    // Needed by Hibernate
  }

}
