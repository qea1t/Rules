package com.example.trafficrules;

public class Rule {
    private String title;
    private String text;

    public Rule() {
        // Порожній конструктор потрібен для Firebase
    }

    public Rule(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}