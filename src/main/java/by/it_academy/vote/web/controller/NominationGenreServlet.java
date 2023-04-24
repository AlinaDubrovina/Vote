package by.it_academy.vote.web.controller;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.core.entity.GenreEntity;
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
import java.util.Map;

@WebServlet(name = "NominationGenreServlet", urlPatterns = "/genres")
public class NominationGenreServlet extends HttpServlet {

    private static final String BR = "<br>";
    private static final String HEADER = "<p><b>Choose 3-5 genres:</b></p>";
    private static final String FOOTER = "<p><b>Also write few words in about section...</b></p>";
    private final String CREATE = "create";
    private final String UPDATE = "update";
    private final String DELETE = "delete";
    private final IGenreService genreService;

    public NominationGenreServlet() {
        this.genreService = GenreServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<GenreEntity> genres = genreService.readAll();
        StringBuilder str = new StringBuilder();
        for(GenreEntity genre : genres){
            str.append(genre.getId()).append(" - ").append(genre.getName()).append(BR);
        }
        String result = HEADER + str + FOOTER;
        writer.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        String genreName = parameterMap.get(CREATE)[0];
        genreService.create(new GenreDTO(null, genreName));
        resp.sendRedirect(req.getContextPath() + "/genres");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Long genreId = Long.valueOf((parameterMap.get(UPDATE)[0]));
        String genreName = parameterMap.get("name")[0];
        genreService.update(new GenreDTO(genreId, genreName));
        resp.sendRedirect(req.getContextPath() + "/genres");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Long genreId = Long.valueOf((parameterMap.get(DELETE)[0]));
        genreService.delete(genreId);
        resp.sendRedirect(req.getContextPath() + "/genres");
    }
}