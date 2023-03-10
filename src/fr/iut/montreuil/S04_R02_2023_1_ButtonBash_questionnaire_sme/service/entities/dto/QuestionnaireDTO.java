package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;

import java.util.ArrayList;

public class QuestionnaireDTO {

    private ArrayList<QuestionDTO> questions;
    private String nom;

    public QuestionnaireDTO (FichierQuestionnairesBO o, int i) {
        if(i > o.getNbQuestionnaires() || i < 0)
            throw new IllegalArgumentException("Le numero de questionnaire n'existe pas");

        questions = new ArrayList<QuestionDTO>();
        ArrayList<ArrayList<String[]>> questionnaires = o.getRawQuestionnaires();
        for(String[] rawQuestion : questionnaires.get(i)) {
            questions.add(new QuestionDTO(rawQuestion));
        }
    }
}
