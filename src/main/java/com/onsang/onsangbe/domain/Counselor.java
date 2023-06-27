package com.onsang.onsangbe.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Counselor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private String field;

    private String introduce;

    @Builder
    public Counselor(long id, String name, int age, String field, String introduce) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.field = field;
        this.introduce = introduce;
    }

    public void update(CounselorDto counselorDto) {
        this.name = counselorDto.getName();
        this.age = counselorDto.getAge();
        this.field = counselorDto.getField();
        this.introduce = counselorDto.getIntroduce();
    }
}
