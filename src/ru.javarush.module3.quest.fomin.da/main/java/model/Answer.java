package model;

import java.util.Objects;

public class Answer {
    private Long id;
    private String answerText;
    private Long nextQuestionId;

    public Answer(Long id, String answerText, Long nextQuestionId) {
        this.id = id;
        this.answerText = answerText;
        this.nextQuestionId = nextQuestionId;
    }

    public Answer(){}

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", nextQuestionId=" + nextQuestionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id.equals(answer.id) && answerText.equals(answer.answerText) && nextQuestionId.equals(answer.nextQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerText, nextQuestionId);
    }

    public Long getId() {
        return id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}
