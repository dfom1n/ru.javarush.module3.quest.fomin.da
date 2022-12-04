package model;

import java.util.Objects;

public class Answer {
    private Integer id;
    private String answerText;
    private Long nextQuestionId;

    public Answer(Integer id, String answerText, Long nextQuestionId) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(answerText, answer.answerText) &&
                Objects.equals(id, answer.id) &&
                Objects.equals(nextQuestionId, answer.nextQuestionId);
    }

    //    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(answerText, id, nextQuestionId);
    }


    public Integer getId() {
        return id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}
