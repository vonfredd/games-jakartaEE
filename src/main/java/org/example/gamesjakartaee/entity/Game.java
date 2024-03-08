package org.example.gamesjakartaee.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "Game")
@NamedQuery(name = "GameEntity.findAll", query = "SELECT g FROM Game g")
@NamedQuery(name = "GameEntity.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int releaseDate;

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

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
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
