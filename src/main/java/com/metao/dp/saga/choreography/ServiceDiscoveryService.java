package com.metao.dp.saga.choreography;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ServiceDiscoveryService {
  private final Map<String, ChoreographyChapter> services;

  /**
   * find any service.
   *
   * @return any service
   * @throws NoSuchElementException if no elements further
   */
  public ChoreographyChapter findAny() {
    return services.values().iterator().next();
  }

  public Optional<ChoreographyChapter> find(String service) {
    return Optional.ofNullable(services.getOrDefault(service, null));
  }

  public ServiceDiscoveryService discover(ChoreographyChapter chapterService) {
    services.put(chapterService.getName(), chapterService);
    return this;
  }

  public ServiceDiscoveryService() {
    this.services = new HashMap<>();
  }


}
