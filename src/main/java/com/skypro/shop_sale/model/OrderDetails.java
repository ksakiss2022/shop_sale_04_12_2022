package com.skypro.shop_sale.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 @Entity
 @Table(name = "orders_details")
 public class OrderDetails {
     private static final String SEQ_NAME = "order_details_seq";
    //наименование нашей последовательности
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
//генерим конкретные табл
     @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    //генератор
     private Long id;
     @ManyToOne
     @JoinColumn(name = "order_id")
     private Order order;
     @ManyToOne
     @JoinColumn(name = "product_id")
     private Product product;
     private BigDecimal amount;
     private BigDecimal price;
 }
