package by.it_academy.vote.core.dto;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private String artist;
    private String[] genres;
    private String about;

    public VoteDTO(String artist, String[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return Objects.equals(artist, voteDTO.artist) && Arrays.equals(genres, voteDTO.genres) && Objects.equals(about, voteDTO.about);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(artist, about);
        result = 31 * result + Arrays.hashCode(genres);
        return result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "artist='" + artist + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", about='" + about + '\'' +
                '}';
    }
}
