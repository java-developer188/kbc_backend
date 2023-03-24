package com.sts.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String quest;

    public Questions(long id, String quest) {
        this.id = id;
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", quest='" + quest + '\'' +
                '}';
    }

    public Questions() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }
}
