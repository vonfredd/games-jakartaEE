package org.example.gamesjakartaee.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@NamedQuery(name = "GameEntity.findAll", query = "SELECT g FROM Game g")
@NamedQuery(name = "GameEntity.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
public class Game {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int releaseYear;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseDate) {
        this.releaseYear = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getId() != null && Objects.equals(getId(), game.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
