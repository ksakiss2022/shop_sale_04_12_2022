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
@Table(name = "users")

public class User {
    private static final String SEQ_NAME= "user_seq";
    //наименование нашей последовательности
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
//генерим конкретные табл
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    //генератор
    private Long id;
    //и все к лонг ай ди
    private String name;
    private String password;
    private String email;
    private boolean arhive;
    @Enumerated (EnumType.STRING)
    //роли через стринг
    private Acess acess;
    @OneToOne(cascade = CascadeType.REMOVE)
    // один пользователь-одна корзина, удаляем пользователя. и удаляем корзину
    private Bucket bucket;
    //  private static int counter;



    public User(String name, String password, String email, boolean arhive) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.arhive = arhive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isArhive() {
        return arhive;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", arhive=" + arhive +
                ", acess=" + acess +
                ", bucket=" + bucket +
                '}';
    }
}
