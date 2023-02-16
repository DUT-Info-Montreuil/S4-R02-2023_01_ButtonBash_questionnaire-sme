package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.model;

import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo.FichierQuestionnaireBO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionDTO;
import fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto.QuestionnaireDTO;

import java.util.ArrayList;

public interface IServiceQuiz {
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire ();
    public QuestionnaireDTO FournirUnQuestionnaire (int i);
    public void maJStatQuestion (QuestionDTO q);
    public String fournirStatQuestion (QuestionDTO q);
    public void ajouterQuestionnaire(FichierQuestionnaireBO bo);
}