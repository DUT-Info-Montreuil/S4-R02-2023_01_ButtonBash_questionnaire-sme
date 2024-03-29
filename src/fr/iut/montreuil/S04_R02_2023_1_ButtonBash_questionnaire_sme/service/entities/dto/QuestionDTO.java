package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.dto;

public class QuestionDTO {

    private int numero;
    private String langue;
    private String texte;
    private String reponse;
    private int goodAnswer;
    private int answeredCount;

    public int getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(int goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public int getAnsweredCount() {
        return answeredCount;
    }

    public void setAnsweredCount(int answeredCount) {
        this.answeredCount = answeredCount;
    }

    public QuestionDTO (String[] tab){
        this.numero=Integer.parseInt(tab[1]);
        this.langue=tab[2];
        this.texte=tab[3];
        this.reponse=tab[4];
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "numero=" + numero +
                ", langue='" + langue + '\'' +
                ", texte='" + texte + '\'' +
                ", reponse='" + reponse + '\'' +
                '}';
    }
}
