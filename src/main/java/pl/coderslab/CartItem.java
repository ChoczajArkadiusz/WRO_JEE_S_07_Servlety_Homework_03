package pl.coderslab;

public class CartItem {
    private String name;
    private Integer quantity;
    private Double price;


    public CartItem(String name, int quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public CartItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}