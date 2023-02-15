package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_joueur_sme.entities.bo;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class FichierQuestionnaireBO {
    private String nomFichier; // files must be placed in src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_joueur_sme/resources

    public FichierQuestionnaireBO(String nomFichier) {
        this.nomFichier = nomFichier;
        try {
            CSVReader reader = new CSVReader(new FileReader("src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_joueur_sme/resources/" + nomFichier));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine);
            }
        } catch (Exception e) {
            System.out.println("Fichier non trouve : " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        FichierQuestionnaireBO fichierQuestionnaireBO = new FichierQuestionnaireBO("questionsQuizz_V1.1.csv");
    }
}
