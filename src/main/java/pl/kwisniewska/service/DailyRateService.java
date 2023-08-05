package pl.kwisniewska.service;

import pl.kwisniewska.model.DailyRate;

public interface DailyRateService {
    DailyRate getDailyRate();

    void updateDailyRate(DailyRate dailyRate);
}
