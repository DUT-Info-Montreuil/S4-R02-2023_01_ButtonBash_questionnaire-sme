package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnairesBO;

import java.util.ArrayList;

public class QuestionnaireDTO {

    private ArrayList<QuestionDTO> questions;

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    private int playCount = 0;

    public QuestionnaireDTO (FichierQuestionnairesBO o, int questionnaireID) {
        if(questionnaireID > o.getNbQuestionnaires() || questionnaireID < 0)
            throw new IllegalArgumentException("Le numero de questionnaire n'existe pas");

        questions = new ArrayList<QuestionDTO>();
        ArrayList<ArrayList<String[]>> questionnaires = o.getRawQuestionnaires();
        for(String[] rawQuestion : questionnaires.get(questionnaireID - 1)) {
            questions.add(new QuestionDTO(rawQuestion));
        }
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }
}
