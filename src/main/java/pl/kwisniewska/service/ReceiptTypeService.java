package pl.kwisniewska.service;

import pl.kwisniewska.model.ReceiptType;

import java.util.List;

public interface ReceiptTypeService {

    List<ReceiptType> getAllReceiptTypes();
    ReceiptType getReceiptTypeById(Long index);
    ReceiptType getReceiptTypeByName(String name);
    void addReceiptType(ReceiptType receiptType);
    void updateReceiptType(Long receiptTypeId, ReceiptType receiptType);
    void deleteReceiptType(Long index);
}
