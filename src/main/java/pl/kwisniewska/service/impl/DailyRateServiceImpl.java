package pl.kwisniewska.service.impl;

import lombok.AllArgsConstructor;
import pl.kwisniewska.model.DailyRate;
import pl.kwisniewska.service.DailyRateService;

@AllArgsConstructor
public class DailyRateServiceImpl implements DailyRateService {
    private final DailyRate dailyRate = new DailyRate(15d);

    @Override
    public DailyRate getDailyRate() {
        return this.dailyRate;
    }

    @Override
    public void updateDailyRate(DailyRate updatedDailyRate) {
        this.dailyRate.setValue(updatedDailyRate.getValue());
    }
}
