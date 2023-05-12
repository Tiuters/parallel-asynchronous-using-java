package com.learnjava.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @NonNull
    private String productId;
    @NonNull
    private ProductInfo productInfo;
    @NonNull
    private Review review;

    @Override
    public String toString() {
        return "\nProduct{" +
                "\nproductId='" + productId + '\'' +
                ", \nproductInfo=" + productInfo +
                ", \nreview=" + review +
                '}';
    }
}
