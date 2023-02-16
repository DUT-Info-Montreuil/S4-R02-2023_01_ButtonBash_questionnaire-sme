package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.impl;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnaireBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model.IServiceQuiz;

import java.util.ArrayList;

public class ServiceQuiz implements IServiceQuiz {
    private ArrayList<QuestionnaireDTO> questionnaire;

    public ServiceQuiz(){

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
}
