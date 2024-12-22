package pl.zak.component30.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDTO {
    private Integer id;
    private String item;
    private Float normalPrice;
    private Integer requiredQuantity;
    private Float specialPrice;
}
