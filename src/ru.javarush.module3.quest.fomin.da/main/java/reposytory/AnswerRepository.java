package reposytory;

import model.Answer;

import java.util.*;

public class AnswerRepository {
    private Map<Long, Answer> answerMap = new HashMap<>();

    public AnswerRepository(List<Answer> answerList) {
        Long id;
        for (Answer answer : answerList) {
            id = answer.getId();
            this.answerMap.put(id, answer);
        }
    }

    public List<Answer> findById(List<Long> ids){
        List<Answer> answers = new ArrayList<>();
        for (Long id : ids) {
            for (Map.Entry<Long, Answer> answerEntry : answerMap.entrySet()) {
                if (answerEntry.getKey() == id){
                    answers.add(answerEntry.getValue());
                }
            }
        }
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerRepository that = (AnswerRepository) o;
        return Objects.equals(answerMap, that.answerMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerMap);
    }
}
