package com.crystall.smartlockprototype.beans.firebase;

import java.io.Serializable;

public class Door implements Serializable{

    private int id;

    public Door(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                '}';
    }
}
