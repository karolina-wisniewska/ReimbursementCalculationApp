package pl.kwisniewska.service;

import pl.kwisniewska.model.ReceiptType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReceiptTypeServiceImpl implements ReceiptTypeService{

    private List<ReceiptType> list;

    private static Long nextId = 0L;
    public ReceiptTypeServiceImpl() {
        list = new ArrayList<>();

        addReceiptType(ReceiptType.builder()
                .name("taxi")
                .build());

        addReceiptType(ReceiptType.builder()
                .name("hotel")
                .build());

        addReceiptType(ReceiptType.builder()
                .name("air ticket")
                .build());

        addReceiptType(ReceiptType.builder()
                .name("train")
                .build());
    }

    @Override
    public List<ReceiptType> getAllReceiptTypes() {
        return this.list;
    }

    @Override
    public ReceiptType getReceiptTypeById(Long index) {
        return list.stream()
                .filter(n -> n.getId().equals(index))
                .findAny()
                .orElse(null);
    }

    @Override
    public void addReceiptType(ReceiptType type) {
        Optional.ofNullable(type)
                .ifPresent(t -> {
                    list.add(ReceiptType.builder()
                            .id(next())
                            .name(t.getName())
                            .build());
                });
    }

    @Override
    public void updateReceiptType(Long receiptTypeId, ReceiptType receiptType) {
        Optional.ofNullable(receiptType)
                .filter(t -> receiptTypeId > 0)
                .map(t -> getReceiptTypeById(receiptTypeId))
                .map(t -> list.indexOf(t))
                .ifPresent(t -> list.set(t, receiptType));
    }

    @Override
    public void deleteReceiptType(Long index) {
        Optional.ofNullable(getReceiptTypeById(index))
                .ifPresent(t -> list.remove(t));
    }

    private long next() {
        return ++nextId;
    }
}
