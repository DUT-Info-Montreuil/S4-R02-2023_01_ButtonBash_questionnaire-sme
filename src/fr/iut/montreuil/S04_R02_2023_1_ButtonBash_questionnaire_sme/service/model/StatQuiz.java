package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;

public interface StatQuiz {

    public QuestionDTO bestAnswered (int questionnaire);
    public QuestionDTO worstAnswered (int questionnaire);
}
