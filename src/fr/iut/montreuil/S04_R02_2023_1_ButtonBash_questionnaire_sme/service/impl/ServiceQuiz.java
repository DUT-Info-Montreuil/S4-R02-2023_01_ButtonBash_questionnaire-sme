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
    public QuestionDTO bestAnswered(int questionnaire) {
        QuestionDTO rep=this.questionnaires.get(0).getQuestions().get(0);
        for(QuestionnaireDTO questionnaires : this.fournirListeQuestionnaire()){
            for (QuestionDTO questions : questionnaires.getQuestions()){
                if (questions.getGoodAnswer()/questions.getAnsweredCount()> rep.getGoodAnswer()/rep.getAnsweredCount()){
                    rep=questions;
                }
            }
        }
        return rep;
    }

    @Override
    public QuestionDTO worstAnswered(int questionnaire) {
        QuestionDTO rep=this.questionnaires.get(0).getQuestions().get(0);
        for(QuestionnaireDTO questionnaires : this.fournirListeQuestionnaire()){
            for (QuestionDTO questions : questionnaires.getQuestions()){
                if (questions.getGoodAnswer()/questions.getAnsweredCount()< rep.getGoodAnswer()/rep.getAnsweredCount()){
                    rep=questions;
                }
            }
        }
        return rep;
    }

    public void recupereStats(){
        int i=1;
        QuestionDTO best;
        QuestionDTO worst;
        for (QuestionnaireDTO questionnaire:this.questionnaires){
            System.out.println("statistiques du questionnaire : "+i);
            System.out.println("le questionnaire à été joué :\n"+questionnaire.getPlayCount()+" fois");
            best=this.bestAnswered(i-1);
            System.out.println("la question avec le meilleur taux de réussite est : "+best.toString()+" avec "+best.getGoodAnswer()+" bonne réponses sur"+best.getAnsweredCount());
            worst = this.worstAnswered(i-1);
            System.out.println("la question avec le pire taux de réussite est : "+worst.toString()+" avec "+worst.getGoodAnswer()+" bonne réponses sur"+worst.getAnsweredCount());
            i++;
        }
    }
}
