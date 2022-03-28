package com.app.mystudies.msstudent.models;

import java.io.Serializable;
import java.util.Objects;

public class Teatcher implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Teatcher() {
    }

    public Teatcher(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Teatcher)) {
            return false;
        }
        Teatcher teatcher = (Teatcher) o;
        return Objects.equals(id, teatcher.id) && Objects.equals(name, teatcher.name)
                && Objects.equals(email, teatcher.email) && Objects.equals(phone, teatcher.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }
}
