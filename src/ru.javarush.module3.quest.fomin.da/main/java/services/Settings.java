package services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Answer;
import model.Question;
import reposytory.AnswerRepository;
import reposytory.QuestionRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class Settings {

//    public static final String INIT_FILE_SETTINGS = "Settings.yaml";

    private static volatile Settings SETTINGS;
    private String description;
    private Integer gameId;
    private Integer firstQuestionId;
    private List<Question> creaturesQuestions;

    private List<Answer> creaturesAnswer;

    public Settings() {}

    public Settings(InputStream resource) {
        try {
            ObjectReader objectReader = new YAMLMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readerForUpdating(this);
            if (Objects.nonNull(resource)) {
                objectReader.readValue(resource);
            }
        } catch (IOException e) {
            System.out.printf("Ошибка при чтении файла настроек init.yml: %s", e);
        }
    }


    public QuestionRepository getCreaturesQuestionRepository() {
        QuestionRepository creaturesQuestionRepository = null;
        if (creaturesQuestions != null) {
            creaturesQuestionRepository = new QuestionRepository(creaturesQuestions);
        }
        return creaturesQuestionRepository;
    }

    public AnswerRepository getCreaturesAnswerRepository() {
        AnswerRepository creatureAnswerRepository = null;
        if (creaturesQuestions != null) {
            creatureAnswerRepository = new AnswerRepository(creaturesAnswer);
        }
        return creatureAnswerRepository;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getFirstQuestionId() {
        return firstQuestionId;
    }

    public List<Question> getCreaturesQuestions() {
        return creaturesQuestions;
    }

    public List<Answer> getCreaturesAnswer() {
        return creaturesAnswer;
    }

//    public static Settings get() {
//        Settings settings = SETTINGS;
//
//        if (Objects.isNull(settings)) {
//            synchronized (Settings.class) {
//                if (Objects.isNull(settings = SETTINGS)) {
//                    settings = SETTINGS = new Settings(Settings.class.getClassLoader().getResourceAsStream("Settings.yaml"));
//                }
//            }
//        }
//        return settings;
//    }
}


