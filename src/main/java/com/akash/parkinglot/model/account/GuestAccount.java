package com.akash.parkinglot.model.account;

import java.util.List;

public class GuestAccount extends Account{
    public GuestAccount(String name, List<Role> roles) {
        super(name, roles);
    }
}
