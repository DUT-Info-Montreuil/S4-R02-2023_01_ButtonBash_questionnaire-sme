package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.impl;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model.IServiceQuiz;

import java.util.ArrayList;

public class ServiceQuiz implements IServiceQuiz {
    private ArrayList<QuestionnaireDTO> questionnaires;

    public ServiceQuiz(String nomFichier){
        FichierQuestionnairesBO bo = new FichierQuestionnairesBO(nomFichier, ';');
        questionnaires = new ArrayList<QuestionnaireDTO>();
        for(int i = 0; i < bo.getNbQuestionnaires(); i++) {
            questionnaires.add(new QuestionnaireDTO(bo, i));
        }
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() {
        return null;
    }

    @Override
    public QuestionnaireDTO FournirUnQuestionnaire(int i) {
        return null;
    }

    @Override
    public void maJStatQuestion(QuestionDTO q) {

    }

    @Override
    public String fournirStatQuestion(QuestionDTO q) {
        return null;
    }

    @Override
    public void ajouterQuestionnaire(FichierQuestionnairesBO bo, int index) {

    }

    public static void main(String[] args) { // only here for testing purposes
        new ServiceQuiz("questionsQuizz_V1.1.csv");
    }
}
