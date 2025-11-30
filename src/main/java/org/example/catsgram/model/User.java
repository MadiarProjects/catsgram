package org.example.catsgram.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private final String email;
    private String nickname;
    private LocalDate birthdate;
    User(String email){
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
