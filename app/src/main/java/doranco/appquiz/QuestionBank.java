package doranco.appquiz;



import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> questionlist;
    private int totaleOfAllQuestions , nextQuestionIndex;

    public QuestionBank(List<Question> questionlist){
        Collections.shuffle(questionlist);
    }
    public Question getNextQuestion(){
        Question q = questionlist.get(nextQuestionIndex);
        return q;
    }
    public int getTotaleOfAllQuestions(){
        totaleOfAllQuestions = questionlist.size();
        return totaleOfAllQuestions;
    }

    public List<Question> getQuestionlist() {
        return questionlist;
    }

    public void setQuestionlist(List<Question> questionlist) {
        this.questionlist = questionlist;
    }

    public void setTotaleOfAllQuestions(int totaleOfAllQuestions) {
        this.totaleOfAllQuestions = totaleOfAllQuestions;
    }

    public int getNextQuestionIndex() {
        return nextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        this.nextQuestionIndex = nextQuestionIndex;
    }
}
