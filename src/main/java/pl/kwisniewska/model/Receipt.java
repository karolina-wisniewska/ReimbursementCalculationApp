package pl.kwisniewska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Receipt {
    private ReceiptType receiptType;
    private Double amount;
}
