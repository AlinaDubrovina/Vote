package by.it_academy.vote.core.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class SavedVoteDTO {
    private LocalDateTime dtCreate;
    private VoteDTO vote;

    public SavedVoteDTO(LocalDateTime dtCreate, VoteDTO vote) {
        this.dtCreate = dtCreate;
        this.vote = vote;
    }

    public SavedVoteDTO(VoteDTO vote) {
        this.dtCreate = LocalDateTime.now();
        this.vote = vote;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public VoteDTO getVote() {
        return vote;
    }

    public void setVote(VoteDTO vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedVoteDTO that = (SavedVoteDTO) o;
        return Objects.equals(dtCreate, that.dtCreate) && Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtCreate, vote);
    }

    @Override
    public String toString() {
        return "SavedVoteDTO{" +
                "dtCreate=" + dtCreate +
                ", vote=" + vote +
                '}';
    }
}
