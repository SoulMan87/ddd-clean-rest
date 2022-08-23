package com.soultech.ddd.clean.core.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Greeting {

    String forWhom;

    String message;
}
