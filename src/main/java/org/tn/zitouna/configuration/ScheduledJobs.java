package org.tn.zitouna.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledJobs {
  @Value("${jobs.menseul.value}")
  private boolean isEnabled;

  @Scheduled(fixedDelay = 60000)
  public void cleanTempDirectory() {
    if(isEnabled) {
      // do work here
    	System.out.println("ok"+isEnabled);
    }else {
    	System.out.println(" test s7i7"+isEnabled);
    }
  }
}
