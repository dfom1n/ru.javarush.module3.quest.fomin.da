package ru.javarush.module3.quest.fomin.da.controller;


import ru.javarush.module3.quest.fomin.da.model.Answer;
import ru.javarush.module3.quest.fomin.da.model.Question;
import ru.javarush.module3.quest.fomin.da.services.GameService;
import ru.javarush.module3.quest.fomin.da.services.StepGame;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "gameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {
    GameService gameService;

    @Override
    public void init() throws ServletException {
        gameService = new GameService();

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long nextQuestionId = 1L;

        if ((request.getParameter("nextQuestionId") != null)) {
            try {
                nextQuestionId = Long.parseLong(request.getParameter("nextQuestionId"));
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        } else nextQuestionId =  gameService.getSettings().getFirstQuestionId();

        StepGame stepGame = gameService.findStepsGame(nextQuestionId);

        Question question = stepGame.getQuestion();
        Long questionId = question.getId();
        String questionText = question.getQuestionText();
        boolean isLast = question.getIsLast();
        List<Answer> answers = stepGame.getAnswers();


        request.setAttribute("questionId", questionId);
        request.setAttribute("questionText", questionText);
        request.setAttribute("isLast", isLast);
        request.setAttribute("answers", answers);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        try {
            dispatcher.forward(request, response);
        }  catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        String name = request.getParameter("name");

        if (name != null) {
            session.setAttribute("name", name);
        } else {
            try {
                response.sendRedirect("game.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}
