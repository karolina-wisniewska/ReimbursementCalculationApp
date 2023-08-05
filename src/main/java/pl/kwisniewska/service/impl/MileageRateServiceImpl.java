package pl.kwisniewska.service.impl;

import lombok.NoArgsConstructor;
import pl.kwisniewska.model.MileageRate;
import pl.kwisniewska.service.MileageRateService;

@NoArgsConstructor
public class MileageRateServiceImpl implements MileageRateService {
    private final MileageRate mileageRate = new MileageRate(0.3);

    @Override
    public MileageRate getMileageRate() {
        return this.mileageRate;
    }

    @Override
    public void updateMileageRate(MileageRate updatedMileageRate) {
        this.mileageRate.setValue(updatedMileageRate.getValue());
    }
}
