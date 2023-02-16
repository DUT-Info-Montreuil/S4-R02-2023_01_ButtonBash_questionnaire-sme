package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_joueur_sme.entities.bo;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class FichierQuestionnaireBO {
    private String nomFichier; // files must be placed in src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_joueur_sme/resources
    private ArrayList<String[]> rawQuestions = new ArrayList<>();

    public FichierQuestionnaireBO(String nomFichier) {
        this.nomFichier = nomFichier;

        try {
            CSVReader reader = new CSVReader(new FileReader("src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_joueur_sme/resources/" + nomFichier));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                rawQuestions.add(nextLine);
            }
        } catch (Exception e) {
            System.out.println("Fichier non trouve : " + e.getMessage());
        }
        for(String[] s : rawQuestions) {
            for(String s2 : s) {
                System.out.print(s2 + " ");
            }
            System.out.println();
        }
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public ArrayList<String[]> getRawQuestions() {
        return rawQuestions;
    }
}
