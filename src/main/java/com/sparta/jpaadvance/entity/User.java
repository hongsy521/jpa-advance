package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 양방향 지정
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Food> foodList = new ArrayList<>();  // 객체를 저장하기 위한 하나의 방법일 뿐 데이터베이스 테이블에 영향을 미치지 않음

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this);  // 외래키 설정
    }
}