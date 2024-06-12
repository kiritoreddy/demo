package com.example.demo.enums;

public enum Badge {
    Code_Ninja("Code Ninja"),
    Code_Champ("Code Champ"),
    Code_Master("Code Master");

    private final String name;
    Badge(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
