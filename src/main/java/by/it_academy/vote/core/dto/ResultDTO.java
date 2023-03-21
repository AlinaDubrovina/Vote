package by.it_academy.vote.core.dto;

import java.util.List;

public class ResultDTO {
    private List<ResultRow<ArtistDTO>> topArtist;
    private List<ResultRow<GenreDTO>> topGenre;
    private List<AboutRow> aboutRows;

    public ResultDTO(List<ResultRow<ArtistDTO>> topArtist, List<ResultRow<GenreDTO>> topGenre, List<AboutRow> aboutRows) {
        this.topArtist = topArtist;
        this.topGenre = topGenre;
        this.aboutRows = aboutRows;
    }

    public List<ResultRow<ArtistDTO>> getTopArtist() {
        return topArtist;
    }

    public List<ResultRow<GenreDTO>> getTopGenre() {
        return topGenre;
    }

    public List<AboutRow> getAboutRows() {
        return aboutRows;
    }
}
