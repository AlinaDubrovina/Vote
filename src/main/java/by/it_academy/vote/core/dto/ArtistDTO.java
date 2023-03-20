package by.it_academy.vote.core.dto;

import java.util.Objects;

public class ArtistDTO {
    private int id;
    private String name;

    public ArtistDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return id == artistDTO.id && Objects.equals(name, artistDTO.name);
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
