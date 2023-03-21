package by.it_academy.vote.core.dto;

import java.time.LocalDateTime;

public class AboutRow {
    private LocalDateTime dtCreate;
    private String about;

    public AboutRow(LocalDateTime dtCreate, String about) {
        this.dtCreate = dtCreate;
        this.about = about;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public String getAbout() {
        return about;
    }
}
