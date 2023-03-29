package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.impl;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model.IServiceQuiz;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model.StatQuiz;

import java.util.ArrayList;

public class ServiceQuiz implements IServiceQuiz, StatQuiz {
    private ArrayList<QuestionnaireDTO> questionnaires;

    public ServiceQuiz(FichierQuestionnairesBO bo) {
        questionnaires = new ArrayList<QuestionnaireDTO>();
        for(int i = 0; i < bo.getNbQuestionnaires(); i++) {
            questionnaires.add(new QuestionnaireDTO(bo, i + 1));
        }
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() {
        return questionnaires;
    }

    @Override
    public QuestionnaireDTO FournirUnQuestionnaire(int i) {
        return questionnaires.get(i);
    }

    @Override
    public void maJStatQuestion(QuestionDTO q) {
        // not sure what are the "stats" to update so I'm leaving this empty
    }

    @Override
    public String fournirStatQuestion(QuestionDTO q) {
        return q.toString();
    }

    @Override
    public void ajouterQuestionnaire(FichierQuestionnairesBO bo, int index) {
        questionnaires.add(new QuestionnaireDTO(bo, index));
    }

    public static void main(String[] args) { // only here for testing purposes
        FichierQuestionnairesBO bo = new FichierQuestionnairesBO("questionsQuizz_V1.1.csv", ';');
        ServiceQuiz quiz = new ServiceQuiz(bo);

        System.out.println(quiz.fournirListeQuestionnaire());
        System.out.println(quiz.FournirUnQuestionnaire(0));
        System.out.println(quiz.fournirStatQuestion(quiz.FournirUnQuestionnaire(0).getQuestions().get(0)));
        quiz.maJStatQuestion(quiz.FournirUnQuestionnaire(0).getQuestions().get(0));
        quiz.ajouterQuestionnaire(bo, 1);
    }

    @Override
    public int bestAnswered(int questionnaire) {
        return 0;
    }

    @Override
    public int worstAnswered(int questionnaire) {
        return 0;
    }
}
