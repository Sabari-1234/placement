package org.example.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    int productId;
    int buyerId;
    int quantity;
    long price;

    public Cart(int productId, int buyerId, int quantity, long price) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productId=" + productId +
                ", buyerId=" + buyerId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
    

}
