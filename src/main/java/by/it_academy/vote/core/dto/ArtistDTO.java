package by.it_academy.vote.core.dto;

import by.it_academy.vote.core.entity.ArtistEntity;

import java.util.Objects;

public class ArtistDTO {
    private Long id;
    private String name;

    public ArtistDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistDTO(ArtistEntity artistEntity) {
        this.id = artistEntity.getId();
        this.name = artistEntity.getName();
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
        ArtistDTO artistDTO = (ArtistDTO) o;
        return Objects.equals(id, artistDTO.id) && Objects.equals(name, artistDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
