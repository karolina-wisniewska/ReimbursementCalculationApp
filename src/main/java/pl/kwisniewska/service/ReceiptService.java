package pl.kwisniewska.service;

import pl.kwisniewska.model.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> parseFormFieldsToReceiptList(String[] types, String[] amounts);
}
