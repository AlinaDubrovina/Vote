package by.it_academy.vote.controller;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.service.api.IGenreService;
import by.it_academy.vote.service.fabrics.GenreServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NominationGenreServlet", urlPatterns = "/genres")
public class NominationGenreServlet extends HttpServlet {
    private final IGenreService genreService;

    public NominationGenreServlet() {
        this.genreService = GenreServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<GenreDTO> genreDTOS = genreService.get();

        PrintWriter writer = resp.getWriter();
        for (GenreDTO genreDTO : genreDTOS){
            writer.write("<p>" + genreDTO.getId() + " - " + genreDTO.getName() + "</p>");
        }
    }
}