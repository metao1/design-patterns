package com.metao.dp.saga.orchestration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The class representing a service discovery pattern.
 */
public class ServiceDiscoveryService {
  private final Map<String, OrchestrationChapter<?>> services;

  public Optional<OrchestrationChapter> find(String service) {
    return Optional.ofNullable(services.getOrDefault(service, null));
  }

  public ServiceDiscoveryService discover(OrchestrationChapter<?> orchestrationChapterService) {
    services.put(orchestrationChapterService.getName(), orchestrationChapterService);
    return this;
  }

  public ServiceDiscoveryService() {
    this.services = new HashMap<>();
  }


}
