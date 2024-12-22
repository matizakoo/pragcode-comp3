package pl.zak.component30.model;


import lombok.AllArgsConstructor;
public class ItemDTO {
    private String name;
    private Integer quantity;
    private Float finalPrice;

    public ItemDTO(String name, Integer quantity, Float finalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }
}
