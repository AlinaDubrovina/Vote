package by.it_academy.vote.web.controller;

import by.it_academy.vote.core.dto.*;
import by.it_academy.vote.service.api.IStatisticsService;
import by.it_academy.vote.service.fabrics.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/statistics")
public class StatisticsServlet extends HttpServlet {
    private IStatisticsService statisticsService;

    public StatisticsServlet() throws PropertyVetoException {
        this.statisticsService = StatisticsServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        ResultDTO result = statisticsService.getResult();

        PrintWriter writer = resp.getWriter();

        List<ResultRow<ArtistDTO>> topArtist = result.getTopArtist();
        topArtist.forEach(i -> writer.write("<p>" + i.getItem().getName() + " - " + i.getCount() + "</p>"));

        List<ResultRow<GenreDTO>> topGenre = result.getTopGenre();
        topGenre.forEach(i -> writer.write("<p>" + i.getItem().getName() + " - " + i.getCount() + "</p>"));

        List<AboutRow> aboutRows = result.getAboutRows();
        aboutRows.forEach(i -> writer.write("<p>" + i.getDtCreate() + " - " + i.getAbout()+ "</p>"));

    }
}
