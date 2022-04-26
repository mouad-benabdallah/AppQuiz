package doranco.appquiz;

import java.util.List;

public class Question {
    private String question;
    private List<String> reponseslist;
    private int correctreponseindex;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getReponseslist() {
        return reponseslist;
    }

    public void setReponseslist(List<String> reponseslist) {
        this.reponseslist = reponseslist;
    }

    public int getCorrectreponseindex() {
        return correctreponseindex;
    }

    public void setCorrectreponseindex(int correctreponseindex) {
        this.correctreponseindex = correctreponseindex;
    }

    public Question(String question, List<String> reponseslist, int correctreponseindex) {
        this.question = question;
        this.reponseslist = reponseslist;
        this.correctreponseindex = correctreponseindex;
    }
}
