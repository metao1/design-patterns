package com.metao.dp.saga.orchestration;

import java.util.Random;

public class WithdrawMoneyService extends Service<String> {
  @Override
  public String getName() {
    return "withdrawing Money";
  }

  @Override
  public ChapterResult<String> process(String value) {
    if (value.equals("bad_order") || value.equals("crashed_order")) {
      System.out.printf("The chapter '%s', val: '%s' has been started. But the exception has been raised."
              + "The rollback is about to start", getName(), value);
      return ChapterResult.failure(value);
    }
    return super.process(value);
  }
}
