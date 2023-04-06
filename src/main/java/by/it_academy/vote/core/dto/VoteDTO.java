package by.it_academy.vote.core.dto;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private int artist;
    private int[] genres;
    private String about;

    public VoteDTO(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public int getArtist() {
        return artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
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

    public static class VoteDTOBuilder{
        private int artist;
        private int[] genres = new int[0];
        private String about;

        private VoteDTOBuilder(){}

        public static VoteDTOBuilder create(){
            return new VoteDTOBuilder();
        }

        public VoteDTOBuilder setArtist(int artist) {
            this.artist = artist;
            return this;
        }

        public VoteDTOBuilder setGenres(int[] genres) {
            this.genres = genres;
            return this;
        }

        public VoteDTOBuilder setAbout(String about) {
            this.about = about;
            return this;
        }

        public VoteDTO build() {
            return new VoteDTO(artist, genres, about);
        }
    }
}
