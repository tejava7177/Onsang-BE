package com.onsang.onsangbe.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class CounselorDto{
    private String name;
    private int age;
    private String field;
    private String introduce;

    public static Counselor counselorMapper(CounselorDto counselorDto) {
        return Counselor.builder()
                .name(counselorDto.getName())
                .age(counselorDto.getAge())
                .field(counselorDto.getField())
                .introduce(counselorDto.getIntroduce())
                .build();
    }

}
