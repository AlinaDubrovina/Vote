package by.it_academy.vote.web.controller;

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
        List<ArtistDTO> artists = artistService.getArtists();
        StringBuilder str = new StringBuilder();
        for (ArtistDTO artist : artists) {
            str.append(artist.getId()).append(" - ").append(artist.getName()).append(BR);
        }
        String result = HEADER + str + FOOTER;

        writer.write(result);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, String[]> parameterMap = req.getParameterMap();
        PostAction postAction = extractPostAction(parameterMap);
        switch (postAction) {
            case CREATE: {
                String artistName = parameterMap.get(CREATE)[0];
                artistService.create(new ArtistDTO(0, artistName));
                break;
            }
            case UPDATE: {
                int artistId = Integer.parseInt(parameterMap.get(UPDATE)[0]);
                String artistName = parameterMap.get("name")[0];
                artistService.update(new ArtistDTO(artistId, artistName));
                break;
            }
            case DELETE: {
                int artistId = Integer.parseInt(parameterMap.get(DELETE)[0]);
                boolean delete = artistService.delete(artistId);
                if(delete){
                    writer.write("Performer deleted successfully");
                }else {
                    writer.write("This performer has already been voted for");
                }
                break;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/artists");
    }

    private PostAction extractPostAction(Map<String, String[]> parameterMap) {

        String[] createArray = parameterMap.get(CREATE);
        boolean create = createArray != null && !createArray[0].isBlank();
        if (create) {
            return PostAction.CREATE;
        }

        String[] updateArray = parameterMap.get(UPDATE);
        boolean update = updateArray != null && !updateArray[0].isBlank();
        if (update) {
            return PostAction.UPDATE;
        }
        String[] deleteArray = parameterMap.get(DELETE);
        boolean delete = deleteArray != null && !deleteArray[0].isBlank();
        if (delete) {
            return PostAction.DELETE;
        }
        throw new IllegalStateException();
    }
}
