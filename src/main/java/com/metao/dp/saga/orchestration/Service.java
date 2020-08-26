package com.metao.dp.saga.orchestration;

public abstract class Service<K> implements OrchestrationChapter<K> {

  @Override
  public abstract String getName();


  @Override
  public ChapterResult<K> process(K value) {
    System.out.printf("The chapter '%s' has been started. "
            + "The data %s has been stored or calculated successfully.%n", getName(), value);
    return ChapterResult.success(value);
  }

  @Override
  public ChapterResult<K> rollback(K value) {
    System.out.printf("The Rollback for a chapter '%s' has been started. "
                    + "The data '%s' has been rollbacked successfully.%n",
            getName(), value);
    return ChapterResult.success(value);
  }


}
