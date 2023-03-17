package by.it_academy.vote.controller;

import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.service.api.IVoteService;
import by.it_academy.vote.service.fabrics.VoteServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final String ARTIST_NAME_PARAMETER = "artist";
    private final String GENRE_NAME_PARAMETER = "genre";
    private final String ABOUT_NAME_PARAMETER = "about";
    private final IVoteService voteService;

    public VoteServlet() {
        this.voteService = VoteServiceSingleton.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] artists = parameterMap.get(ARTIST_NAME_PARAMETER);
        String artist = (artists == null) ? null : artists[0];
        if (artists == null || artists.length > 1){
            throw new IllegalArgumentException("1 artist must be listed");
        }

        String[] genres = parameterMap.get(GENRE_NAME_PARAMETER);

        String[] abouts = parameterMap.get(ARTIST_NAME_PARAMETER);
        String about = (abouts == null) ? null : abouts[0];

        VoteDTO vote = new VoteDTO(artist, genres, about);
        this.voteService.save(vote);
    }
}

