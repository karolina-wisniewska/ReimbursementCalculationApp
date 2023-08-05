package pl.kwisniewska.service.impl;

import lombok.NoArgsConstructor;
import pl.kwisniewska.model.Claim;
import pl.kwisniewska.service.ClaimService;
import pl.kwisniewska.service.DailyRateService;
import pl.kwisniewska.service.MileageRateService;

@NoArgsConstructor
public class ClaimServiceImpl implements ClaimService {

    private final DailyRateService dailyRateService = new DailyRateServiceImpl();
    private final MileageRateService mileageRateService = new MileageRateServiceImpl();

    public Double calculateTotalReimbursement(Claim claim){
        Double dailyRate = dailyRateService.getDailyRate().getValue();
        Double mileageRate = mileageRateService.getMileageRate().getValue();
        Double totalReceiptsAmount = claim.getReceipts()
                .stream()
                .mapToDouble(r -> r.getAmount())
                .sum();
        Double total = dailyRate * claim.getNumberOfDaysInTravel() + claim.getNumberOfKilometers() * mileageRate;
        return totalReceiptsAmount + total;
    }

}
