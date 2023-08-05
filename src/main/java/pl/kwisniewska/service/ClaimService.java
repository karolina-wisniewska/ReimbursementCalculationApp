package pl.kwisniewska.service;

import pl.kwisniewska.model.Claim;

public interface ClaimService {

    Double calculateTotalReimbursement(Claim claim);
}
