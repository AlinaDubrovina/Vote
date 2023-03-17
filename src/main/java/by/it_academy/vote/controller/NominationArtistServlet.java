package by.it_academy.vote.controller;

import by.it_academy.vote.core.dto.ArtistDTO;
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

@WebServlet(name = "NominationArtistServlet", urlPatterns = "nominations/artists")
public class NominationArtistServlet extends HttpServlet {
    private final IArtistService artistService;

    public NominationArtistServlet() {
        this.artistService = ArtistServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<ArtistDTO> artistDTOS = artistService.get();

        PrintWriter writer = resp.getWriter();
        for (ArtistDTO artistDTO : artistDTOS) {
            writer.write("<p>" + artistDTO.getName() + "</p>");
        }
    }
}
