package doranco.appquiz;

import java.util.Arrays;

public class DataQuiz {

     public static final QuestionBank generateQuestions(){

         Question question1 = new Question("Quel est le premier President Francais de la 4éme Republique ?",
                 Arrays.asList("Vincent AURIOL","Rene COTY","Albert LEBRUN","Paul DOUMER"),0);
         Question question2 = new Question("Combien exist-t-il de pays dans l\'union Européenne ?",
                 Arrays.asList("15","24","27","32"),2);
         Question question3 = new Question("Quelle la longue la moins parlée au monde ? ",
                 Arrays.asList("L\'artchi","Le Silbo","Rotokas","Le Piraha"),3);
         Question question4 = new Question("Quel est le payé le plus peuplé au monde  ? ",
                 Arrays.asList("USA","Chine","Inde","Indonésie"),1);
         Question question5 = new Question("Quel est le créateur du système d\'exploiatation Android ?  ? ",
                 Arrays.asList("Jake Wharton", "Steve Wozmiak", "Paul Smith", "Andu Rubin"),3);
         Question question6 = new Question("Quelle est la plus petite République du monde en nombre d\'habitants  ? ",
                 Arrays.asList("Les Tuvalu", "Nauru", "Monaco", "Les Palaos"),1);

         return new QuestionBank(Arrays.asList(question1,question2,question3,question4,question5,question6));


     }

}
