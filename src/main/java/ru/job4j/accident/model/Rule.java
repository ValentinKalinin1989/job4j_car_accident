package ru.job4j.accident.model;

import java.util.Objects;

public class Rule {
    private Long id;
    private String name;

    public static Rule of(Long id, String name) {
        Rule rule = new Rule();
        rule.id = id;
        rule.name = name;
        return rule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return id.equals(rule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
