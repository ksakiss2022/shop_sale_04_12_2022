package com.skypro.shop_sale.model;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    private static final String SEQ_NAME = "order_seq";
    //наименование нашей последовательности
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
//генерим конкретные табл
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    //генератор
    private Long id;
    //и все к лонг ай ди\
    @Timestamp
    //дата создания будет записываться в поле
    private LocalDate create;
    @ManyToOne
    //много заказов у одного пользователя
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    private String adress;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> details;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
