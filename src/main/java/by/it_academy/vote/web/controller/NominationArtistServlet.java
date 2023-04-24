package by.it_academy.vote.web.controller;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.service.api.IArtistService;
import by.it_academy.vote.service.fabrics.ArtistServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "NominationArtistServlet", urlPatterns = "/artists")
public class NominationArtistServlet extends HttpServlet {
    private static final String BR = "<br>";
    private static final String HEADER = "<p><b>Choose one performer:</b></p>";
    private static final String FOOTER = "<p><b>Thanks for your vote!</b></p>";
    private final String CREATE = "create";
    private final String UPDATE = "update";
    private final String DELETE = "delete";
    private final IArtistService artistService;

    public NominationArtistServlet() {
        this.artistService = ArtistServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        List<ArtistEntity> artists = artistService.readAll();
        StringBuilder str = new StringBuilder();
        for (ArtistEntity artist : artists) {
            str.append(artist.getId()).append(" - ").append(artist.getName()).append(BR);
        }
        String result = HEADER + str + FOOTER;

        writer.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        String artistName = parameterMap.get(CREATE)[0];
        artistService.create(new ArtistDTO(null, artistName));
        resp.sendRedirect(req.getContextPath() + "/artists");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Long artistId = Long.valueOf((parameterMap.get(UPDATE)[0]));
        String artistName = parameterMap.get("name")[0];
        artistService.update(new ArtistDTO(artistId, artistName));
        resp.sendRedirect(req.getContextPath() + "/artists");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Long artistId = Long.valueOf((parameterMap.get(DELETE)[0]));
        artistService.delete(artistId);
        resp.sendRedirect(req.getContextPath() + "/artists");
    }
}
