package com.skypro.shop_sale.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 @Entity
 @Table(name = "buckets")
 public class Bucket {
     private static final String SEQ_NAME= "bucket_seq";
    //наименование нашей последовательности
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
//генерим конкретные табл
     @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    //генератор
     private Long id;
    //и все к лонг ай ди
     @OneToOne
     @JoinColumn(name = "user_id")
     private User user;
     @ManyToMany
    //в одной корзине может быть куча товаров, и один товар в куче корзин
     @JoinTable(name = "backets_products",
             joinColumns = @JoinColumn(name = "bucket_id"),
             inverseJoinColumns = @JoinColumn(name = "products_id"))
     private List<Product> products;

 }
