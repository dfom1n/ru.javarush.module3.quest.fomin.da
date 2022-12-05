package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.javarush.module3.quest.fomin.da.model.Answer;
import ru.javarush.module3.quest.fomin.da.model.Question;
import ru.javarush.module3.quest.fomin.da.services.GameService;
import ru.javarush.module3.quest.fomin.da.services.Settings;
import ru.javarush.module3.quest.fomin.da.services.StepGame;


import java.util.List;

class GameServiceTest {
    GameService gameService = new GameService();

    @Test
    void getSettingsTest() {
        Settings expectedSettings = new Settings(GameServiceTest.class.getClassLoader().getResourceAsStream("Settings.yaml"));
        Assertions.assertEquals(expectedSettings, gameService.getSettings());
    }

    @Test
    void findStepsGameTest() {
        StepGame expectedStepGame = new StepGame(
                new Question(2L, "What will you choose ball or TV show?", false, List.of(3L, 4L)),
                List.of(
                        new Answer(3L, "Ball!", 4L),
                        new Answer(4L, "TV!", 3L)));
        Assertions.assertEquals(expectedStepGame, gameService.findStepsGame(2L));
    }

}