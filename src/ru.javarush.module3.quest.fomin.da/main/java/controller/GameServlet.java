package controller;

import model.Answer;
import model.Question;
import services.GameService;
import services.Settings;
import services.StepGame;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "gameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {
    GameService gameService;

    @Override
    public void init() throws ServletException {
//        settings = new Settings(GameServlet.class.getClassLoader().getResourceAsStream("Settings.yaml"));
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

//        GameService gameService = new GameService(settings);

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

//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("nextQuestionId: " + nextQuestionId);
//        printWriter.println("questionId: " + questionId);
//        printWriter.println("questionText: " + questionText);
//        printWriter.println("isLast: " + isLast);
//        for (Answer answer : answers) {
//            printWriter.println("getAnswerText: " + answer.getAnswerText());
//            printWriter.println("getNextQuestionId: " + answer.getNextQuestionId());
//        }

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
