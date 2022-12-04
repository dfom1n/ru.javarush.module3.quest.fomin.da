package model;

import java.util.List;
import java.util.Objects;

public class Question {
    private Integer id;
    private String questionText;
    private boolean isLast;
    private List<Integer> usеAnswerId;

    public Question(Integer id, String questionText, boolean isLast, List<Integer> usеAnswerId) {
        this.id = id;
        this.questionText = questionText;
        this.isLast = isLast;
        this.usеAnswerId = usеAnswerId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", isLast=" + isLast +
                ", usеAnswerId=" + usеAnswerId +
                '}';
    }

    public Question(){}

    public Integer getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return isLast == question.isLast &&
                Objects.equals(id, question.id) &&
                Objects.equals(questionText, question.questionText) &&
                Objects.equals(usеAnswerId, question.usеAnswerId);
    }

    //    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, isLast, usеAnswerId);
    }

    public boolean getIsLast() {
        return isLast;
    }

    public List<Integer> getUsеAnswerId() {
        return usеAnswerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public void setUsеAnswerId(List<Integer> usеAnswerId) {
        this.usеAnswerId = usеAnswerId;
    }
}
