package com.akash.parkinglot.model.account;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Account {
    private String name;
    private List<Role> roles;


}
