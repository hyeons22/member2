package com.example.memberpractice2.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String name;
    private final Integer age;

    public MemberResponseDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
