package org.example.gamesjakartaee.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = "GameEntity.findAll", query = "SELECT g FROM Game g")
@NamedQuery(name = "GameEntity.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
