package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.test;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.impl.ServiceQuiz;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;


public class testServiceQuiz {


//    @BeforeEach
//    public void init(){
//        FichierQuestionnairesBO bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
//    }

    @Test
    public void testListQuestionnaireNotNull(){
        FichierQuestionnairesBO bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
        ArrayList<ArrayList<String[]>> rawQuestions = bo.getRawQuestionnaires();
        for (ArrayList<String[]> listes  :rawQuestions){
            for (String[] tab : listes) {
                for (String s : tab) {
                    assertNotEquals(s.length(), 0);
                }
            }
        }
    }

    @Test
    public void testAjouterQuestionnaire (){
        FichierQuestionnairesBO bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
        ServiceQuiz serv = new ServiceQuiz(bo);
        serv.ajouterQuestionnaire(bo,1);
        assertEquals(2,serv.fournirListeQuestionnaire().size());
    }

    @Test
    public void testFournirUnQuestionnaire (){
        FichierQuestionnairesBO bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
        ServiceQuiz serv = new ServiceQuiz(bo);
        serv.ajouterQuestionnaire(bo,1);
        assertEquals(serv.FournirUnQuestionnaire(1),serv.fournirListeQuestionnaire().get(1));
    }
}
