package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.test;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.impl.ServiceQuiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class testStats {

    FichierQuestionnairesBO bo;

    @BeforeEach
    public void init(){
        bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
    }

    @Test
    public void testBestAnswered(){
        ServiceQuiz quiz = new ServiceQuiz(bo);
        // set the first question as the best answered by changing the number of good answers and total answers
        QuestionDTO q = quiz.FournirUnQuestionnaire(0).getQuestions().get(0);
        q.setGoodAnswer(2);
        q.setAnsweredCount(2);
        // check that the best answered question is the first one
        assertEquals(q, quiz.bestAnswered(0));
        // change the number of good answers and total answers of the second question
        QuestionDTO q2 = quiz.FournirUnQuestionnaire(0).getQuestions().get(1);
        q2.setGoodAnswer(5);
        q2.setAnsweredCount(5);
        // check that the best answered question is the second one
        assertEquals(q2, quiz.bestAnswered(0));
    }

    @Test
    public void testWorstAnswered(){
        ServiceQuiz quiz = new ServiceQuiz(bo);
        // set the first question as the worst answered by changing the number of good answers and total answers
        QuestionDTO q = quiz.FournirUnQuestionnaire(0).getQuestions().get(0);
        q.setGoodAnswer(0);
        q.setAnsweredCount(2);
        // check that the worst answered question is the first one
        assertEquals(q, quiz.worstAnswered(0));
        // change the number of good answers and total answers of the second question
        QuestionDTO q2 = quiz.FournirUnQuestionnaire(0).getQuestions().get(1);
        q2.setGoodAnswer(0);
        q2.setAnsweredCount(5);
        // check that the worst answered question is the second one
        assertEquals(q2, quiz.worstAnswered(0));
    }
}
