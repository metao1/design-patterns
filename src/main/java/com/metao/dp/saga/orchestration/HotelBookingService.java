package com.metao.dp.saga.orchestration;

public class HotelBookingService extends Service<String> {

  @Override
  public String getName() {
    return "booking a Hotel";
  }


  @Override
  public ChapterResult<String> rollback(String value) {
    if (value.equals("crashed_order")) {
      System.out.printf("The Rollback for a chapter '%s' has been started. "
              + "The data %s has been failed.The saga has been crashed.%n",
          getName(), value);

      return ChapterResult.failure(value);
    }

    System.out.printf("The Rollback for a chapter '%s' has been started. "
            + "The data '%s' has been rollbacked successfully.%n",
        getName(), value);

    return super.rollback(value);
  }
}
