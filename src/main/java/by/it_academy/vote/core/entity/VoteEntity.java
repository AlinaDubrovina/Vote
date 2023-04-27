package by.it_academy.vote.core.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "votes", schema = "app")
public class VoteEntity {
    @Id
    @GeneratedValue(generator = "votes_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "votes_seq",sequenceName = "votes_id_seq",schema = "app",allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artistId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "votes_genres", schema = "app",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "vote_id"))
    private List<GenreEntity> genreIds = new ArrayList<>();
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    private String about;

    public VoteEntity(ArtistEntity artistId, List<GenreEntity> genreIds, String about, LocalDateTime dtCreate) {
        this.artistId = artistId;
        this.genreIds = genreIds;
        this.about = about;
        this.dtCreate = dtCreate;
    }

    public VoteEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistEntity getArtistId() {
        return artistId;
    }

    public void setArtistId(ArtistEntity artistId) {
        this.artistId = artistId;
    }

    public List<GenreEntity> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<GenreEntity> genreIds) {
        this.genreIds = genreIds;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntity that = (VoteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(artistId, that.artistId) && Objects.equals(genreIds, that.genreIds) && Objects.equals(dtCreate, that.dtCreate) && Objects.equals(about, that.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistId, genreIds, dtCreate, about);
    }
}