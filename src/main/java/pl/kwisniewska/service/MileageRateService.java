package pl.kwisniewska.service;

import pl.kwisniewska.model.MileageRate;

public interface MileageRateService {
    MileageRate getMileageRate();

    void updateMileageRate(MileageRate mileageRate);
}
