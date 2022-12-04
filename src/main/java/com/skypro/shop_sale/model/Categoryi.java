package com.skypro.shop_sale.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 @Entity
 @Table(name = "categoryis")
 public class Categoryi {
     private static final String SEQ_NAME= "categoryi_seq";
    //наименование нашей последовательности
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
//генерим конкретные табл
     @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,allocationSize = 1)
    //генератор
     private Long id;
     private String title;

 }
