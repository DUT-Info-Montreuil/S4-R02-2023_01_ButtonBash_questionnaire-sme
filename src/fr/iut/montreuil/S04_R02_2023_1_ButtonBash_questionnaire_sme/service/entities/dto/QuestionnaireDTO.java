package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnaireBO;

import java.util.ArrayList;

public class QuestionnaireDTO {

    private ArrayList<QuestionDTO> questions;
    private String nom;

    public QuestionnaireDTO (FichierQuestionnaireBO o, int i){
        questions = new ArrayList<QuestionDTO>();
        ArrayList<String[]> s = o.getRawQuestions();
        for (String[] tab : s){
            if (tab[0].equals(i)){
                this.questions.add(new QuestionDTO(tab));
            }
        }
    }
    
}
