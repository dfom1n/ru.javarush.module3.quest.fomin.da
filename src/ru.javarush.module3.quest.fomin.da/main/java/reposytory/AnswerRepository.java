package reposytory;

import model.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerRepository {
    private Map<Integer, Answer> answerMap = new HashMap<>();

    public AnswerRepository(List<Answer> answerList) {
        Integer id;
        for (Answer answer : answerList) {
            id = answer.getId();
            this.answerMap.put(id, answer);
        }
    }

    public List<Answer> findById(List<Integer> ids){
        List<Answer> answers = new ArrayList<>();
        for (Integer id : ids) {
            for (Map.Entry<Integer, Answer> answerEntry : answerMap.entrySet()) {
                if (answerEntry.getKey() == id){
                    answers.add(answerEntry.getValue());
                }
            }
        }
        return answers;
    }
}
