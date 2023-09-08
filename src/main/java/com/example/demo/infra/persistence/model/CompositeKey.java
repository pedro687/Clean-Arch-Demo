package com.example.demo.infra.persistence.model;


import java.io.Serializable;

public class CompositeKey implements Comparable<CompositeKey>, Serializable {

    public static final String DELIMITER = "#";

    private String prefix;
    private String postfix;


    public CompositeKey(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    @Override
    public String toString() {
        return prefix + DELIMITER + postfix;
    }

    @Override
    public int compareTo(CompositeKey compositeKey) {
        return this.toString().compareTo(compositeKey.toString());
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }
}