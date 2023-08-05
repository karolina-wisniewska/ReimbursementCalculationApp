package pl.kwisniewska.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReceiptType {

    private Long id;
    private String name;
}
