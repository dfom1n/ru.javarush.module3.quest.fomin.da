package services;

import controller.GameServlet;
import model.Answer;
import model.Question;
import reposytory.AnswerRepository;
import reposytory.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GameService {
    Settings settings;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

//    Иницилизация квещен и ансвер репозиториев
    public GameService() {
        this.settings = new Settings(GameServlet.class.getClassLoader().getResourceAsStream("Settings.yaml"));
        this.questionRepository = settings.getCreaturesQuestionRepository();
        this.answerRepository = settings.getCreaturesAnswerRepository();
    }

    @Override
    public String toString() {
        return "GameService{" +
                "settings=" + settings +
                ", questionRepository=" + questionRepository +
                ", answerRepository=" + answerRepository +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameService that = (GameService) o;
        return settings.equals(that.settings) && questionRepository.equals(that.questionRepository) && answerRepository.equals(that.answerRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(settings, questionRepository, answerRepository);
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public AnswerRepository getAnswerRepository() {
        return answerRepository;
    }

    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    //    Формирование Шага игры из вопроса и ответов, на вход получаем id вопроса
    public StepGame findStepsGame(Long nextQuestionId){
        Question question = questionRepository.findById(nextQuestionId);
        List<Answer> answers = answerRepository.findById(question.getUsеAnswerId());
        return new StepGame(question, answers);
    }
////    Формирование лист ответов в виде текста
//    public List<String> findAnswerPhrase(StepGame stepGame){
//        List<String> answerList = new ArrayList<>();
//        for (Answer answer : stepGame.getAnswers()) {
//            answerList.add(answer.getAnswerText());
//        }
//        return answerList;
//    }
//
//    //    Поик лист ответов в виде текста
//    public List<Long> findNextQuestionId(StepGame stepGame){
//        List<Long> nextQuestionID = new ArrayList<>();
//        for (Answer answer : stepGame.getAnswers()) {
//            nextQuestionID.add(answer.getNextQuestionId());
//        }
//        return nextQuestionID;
//    }
////
//    public Answer selectAnswer(StepGame stepGame) {
//        int selectAnswerId = ThreadLocalRandom.current().nextInt(stepGame.getAnswers().size());
//        System.out.println(stepGame.getAnswers().size());
//        Answer selectAnswer = stepGame.getAnswers().get(selectAnswerId);
//        return selectAnswer;
//    }
//
//    public StepGame findNextQuestion(Answer answer){
//        Long nextQuestionId = answer.getNextQuestionId();
//        return findStepsGame(nextQuestionId);
//    }





//    class QuestionDto {
//        private Long id;
//        private String text;
//        private List<AnswerDto> answers;
//    }
//
//    class AnswerDto {
//        private Long id;
//        private String text;
//        private boolean isLast;
//        private QuestionDto questionDto; // id
//    }

//    public QuestionDto findQuestionById(Long id) {
//        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException());
//        List<Answer> answers = answerRepository.findByIds(question.getAnswersId());
//
//        // List<Answer> answers ---->  List<AnswerDto> answers
//
//        // questionId =
//        return new QuestionDto();
//    }
}
