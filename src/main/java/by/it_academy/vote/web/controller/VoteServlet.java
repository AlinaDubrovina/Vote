package by.it_academy.vote.web.controller;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.core.entity.VoteEntity;
import by.it_academy.vote.service.api.IVoteService;
import by.it_academy.vote.service.fabrics.VoteServiceSingleton;
import by.it_academy.vote.web.util.RequestParamHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final IVoteService voteService;

    public VoteServlet() {
        this.voteService = VoteServiceSingleton.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");


        String id = RequestParamHandler.getRequestParam(req,
                RequestParamHandler.ARTIST_PARAM_NAME);
        Long artistId = RequestParamHandler.getID(id);
        List<Long> genreIds = RequestParamHandler.getID(req,
                RequestParamHandler.GENRE_PARAM_NAME);
        String about = RequestParamHandler.getRequestParam(req,
                RequestParamHandler.ABOUT_PARAM_NAME);

        VoteDTO vote = new VoteDTO(artistId, genreIds, about);

        SavedVoteDTO savedVoteDTO = new SavedVoteDTO(vote);
        voteService.save(savedVoteDTO);
    }
}

