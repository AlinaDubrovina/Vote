package by.it_academy.vote.web.controller;

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

        List<GenreDTO> genres = genreService.getContent();
        StringBuilder str = new StringBuilder();
        for(GenreDTO genre : genres){
            str.append(genre.getId()).append(" - ").append(genre.getName()).append(BR);
        }
        String result = HEADER + str + FOOTER;
        writer.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, String[]> parameterMap = req.getParameterMap();
        PostAction postAction = extractPostAction(parameterMap);
        switch (postAction) {
            case CREATE: {
                String genreName = parameterMap.get(CREATE)[0];
                genreService.create(new GenreDTO(0, genreName));
                break;
            }
            case UPDATE: {
                int genreId = Integer.parseInt(parameterMap.get(UPDATE)[0]);
                String genreName = parameterMap.get("name")[0];
                genreService.update(new GenreDTO(genreId, genreName));
                break;
            }
            case DELETE: {
                int genreId = Integer.parseInt(parameterMap.get(DELETE)[0]);
                boolean delete = genreService.delete(genreId);
                if(delete){
                    writer.write("Genre deleted successfully");
                }else {
                    writer.write("This genre has already been voted for");
                }
                break;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/genres");
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