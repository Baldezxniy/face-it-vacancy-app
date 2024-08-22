package com.xedlab.fecaitvacancyapp.scheduler.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "scheduler.config")
public class SchedulerConfigProperties {

  private int firstPage;
  private int lastPage;
  private int delayOnMinutes;

  public int getFirstPage() {
    return firstPage;
  }

  public void setFirstPage(int firstPage) {
    this.firstPage = firstPage;
  }

  public int getLastPage() {
    return lastPage;
  }

  public void setLastPage(int lastPage) {
    this.lastPage = lastPage;
  }

  public int getDelayOnMinutes() {
    return delayOnMinutes;
  }

  public void setDelayOnMinutes(int delayOnMinutes) {
    this.delayOnMinutes = delayOnMinutes;
  }
}
