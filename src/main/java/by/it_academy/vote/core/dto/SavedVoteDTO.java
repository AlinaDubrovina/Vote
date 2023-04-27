package by.it_academy.vote.core.dto;


import java.time.LocalDateTime;
import java.util.Objects;

public class SavedVoteDTO {
    private VoteDTO voteDTO;
    private LocalDateTime dtCreate;

    public SavedVoteDTO(VoteDTO voteDTO, LocalDateTime localDateTime) {
        this.voteDTO = voteDTO;
        this.dtCreate = localDateTime;
    }

    public SavedVoteDTO(VoteDTO voteDTO) {
        this.voteDTO = voteDTO;
        dtCreate = LocalDateTime.now();
    }

    public VoteDTO getVoteDTO() {
        return voteDTO;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedVoteDTO that = (SavedVoteDTO) o;
        return Objects.equals(voteDTO, that.voteDTO) && Objects.equals(dtCreate, that.dtCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteDTO, dtCreate);
    }

    @Override
    public String toString() {
        return "SavedVoteDTO{" +
                "voteDTO=" + voteDTO +
                ", dtCreate=" + dtCreate +
                '}';
    }
}
