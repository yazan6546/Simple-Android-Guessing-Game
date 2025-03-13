package com.example.a1210145_yazan_abualown;

public class Player {

    public static Player currentPlayer;
    private String firstName;
    private String lastName;
    private String gender;

    public Player(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }
}
