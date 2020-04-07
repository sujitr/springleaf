package com.sujit.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long supplierId;
    private long itemId;
    private int itemQuantity;
    private Date purchaseDate;

    public Purchase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", supplierId=" + supplierId +
                ", itemId=" + itemId +
                ", itemQuantity=" + itemQuantity +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
