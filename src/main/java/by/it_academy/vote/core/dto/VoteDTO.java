package by.it_academy.vote.core.dto;

import java.util.Collections;
import java.util.List;

public class VoteDTO {
    private final Long artistId;
    private final List<Long> genreIds;
    private final String about;

    public VoteDTO(Long artistId, List<Long> genreIds, String about) {
        this.artistId = artistId;
        this.genreIds = genreIds;
        this.about = about;
    }

    public long getArtistId() {
        return artistId;
    }

    public List<Long> getGenreIds() {
        return Collections.unmodifiableList(genreIds);
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                ", artistId=" + artistId +
                ", genreIds=" + genreIds +
                ", about='" + about + '\'' +
                '}';
    }
}
