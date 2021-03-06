package com.akash.parkinglot.model.account;

import java.util.ArrayList;
import java.util.List;


public class AdminAccount extends Account{

    public AdminAccount(String name, List<Role> roles) {
        super(name, roles);
    }
}
