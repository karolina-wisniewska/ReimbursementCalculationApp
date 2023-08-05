package pl.kwisniewska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Claim {
    private List<Receipt> receipts;
    private int numberOfDaysInTravel;
    private int numberOfKilometers;

}
