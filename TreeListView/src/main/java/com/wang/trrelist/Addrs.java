package com.wang.trrelist;

public class Addrs {
    private long id;
    private String name;


    public Addrs(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Addrs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
