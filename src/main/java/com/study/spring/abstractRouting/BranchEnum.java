package com.study.spring.abstractRouting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BranchEnum {

    KOREA("korea"), JAPAN("japan");

    private final String name;

}
