package reposytory;

import model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepository {
    private Map<Integer, Question> questionMap = new HashMap<>();

    public QuestionRepository(List<Question> questionList) {
        Integer id;
        for (Question question : questionList) {
//            System.out.println("id : " + question.getId() + ", questionText : " + question.getQuestionText() + ", nextQuestionId : " + question.getUsеAnswerId().toString());
            id = question.getId();
            this.questionMap.put(id, question);
        }
    }

    public Question findById(Integer id){
        return questionMap.get(id);
    }
}
