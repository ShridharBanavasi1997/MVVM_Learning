package com.example.mvvm_java;

import androidx.annotation.Nullable;

public class DataModel {
    @Nullable
    String email,password;

    // constructor
    public DataModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    //get and set Fun
    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

}
