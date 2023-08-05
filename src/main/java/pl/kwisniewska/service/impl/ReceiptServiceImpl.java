package pl.kwisniewska.service.impl;

import pl.kwisniewska.model.Receipt;
import pl.kwisniewska.model.ReceiptType;
import pl.kwisniewska.service.ReceiptService;
import pl.kwisniewska.service.ReceiptTypeService;

import java.util.ArrayList;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptTypeService receiptTypeService = new ReceiptTypeServiceImpl();
    @Override
    public List<Receipt> parseFormFieldsToReceiptList(String[] types, String[] amounts){
        List<Receipt> receipts = new ArrayList<>();
        for(int i = 0; i < types.length; i++) {
            ReceiptType receiptType = receiptTypeService. getReceiptTypeByName(types[i]);
            Double amount = Double.parseDouble(amounts[i]);

            receipts.add(new Receipt(receiptType,amount));
        }
        return receipts;
    }
}
