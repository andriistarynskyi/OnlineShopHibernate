package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int code;
    private String producer;
    private LocalDate dateOfLastUpdate;
    private boolean primaryItem;
    private boolean candidateToRemove;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public LocalDate getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDate dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public boolean isPrimaryItem() {
        return primaryItem;
    }

    public void setPrimaryItem(boolean primaryItem) {
        this.primaryItem = primaryItem;
    }

    public boolean isCandidateToRemove() {
        return candidateToRemove;
    }

    public void setCandidateToRemove(boolean candidateToRemove) {
        this.candidateToRemove = candidateToRemove;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code=" + code +
                ", producer='" + producer + '\'' +
                ", dateOfLastUpdate=" + dateOfLastUpdate +
                ", primaryItem=" + primaryItem +
                ", candidateToRemove=" + candidateToRemove +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() && getCode() == item.getCode() && isPrimaryItem() == item.isPrimaryItem() && isCandidateToRemove() == item.isCandidateToRemove() && getTitle().equals(item.getTitle()) && getProducer().equals(item.getProducer()) && getDateOfLastUpdate().equals(item.getDateOfLastUpdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getCode(), getProducer(), getDateOfLastUpdate(), isPrimaryItem(), isCandidateToRemove());
    }
}