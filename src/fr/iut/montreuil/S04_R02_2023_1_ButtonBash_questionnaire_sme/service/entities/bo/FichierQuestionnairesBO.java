package fr.iut.montreuil.S04_R02_2023_1_ButtonBash_questionnaire_sme.service.entities.bo;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FichierQuestionnairesBO {
    private String nomFichier; // files must be placed in src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_joueur_sme/resources
    private ArrayList<ArrayList<String[]>> rawQuestionnaires = new ArrayList<>();
    private int nbQuestionnaires = 0;

    public FichierQuestionnairesBO(String nomFichier, char separator) {
        this.nomFichier = nomFichier;

        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(new FileReader("src/fr/iut/montreuil/S04_R02_2023_1_ButtonBash_questionnaire_sme/service/resources/" + nomFichier))
                    .withCSVParser(parser)
                    .build();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) { // nextLine[] is an array of values from the line
                int questionnaireIndex = returnCleanNumber(nextLine[0]);
                while(rawQuestionnaires.size() < questionnaireIndex) {
                    rawQuestionnaires.add(new ArrayList<>());
                }
                rawQuestionnaires.get(questionnaireIndex - 1).add(nextLine);

                if(questionnaireIndex > nbQuestionnaires) {
                    nbQuestionnaires = questionnaireIndex;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fichier non trouve : " + e.getMessage());
        }catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }catch (CsvValidationException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
    }

    private int returnCleanNumber(String rawIndex){ // takes the first number found from the first index because weird characters are sometimes found in the file
        for(int i = 0; i < rawIndex.length(); i++){
            if(Character.isDigit(rawIndex.charAt(i))){
                return Integer.parseInt(rawIndex.substring(i));
            }
        }
        return -1;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    @Override
    public String toString() {
        return "FichierQuestionnairesBO{" +
                "nomFichier='" + nomFichier + '\'' +
                ", rawQuestionnaires=" + rawQuestionnaires +
                ", nbQuestionnaires=" + nbQuestionnaires +
                '}';
    }

    public ArrayList<ArrayList<String[]>> getRawQuestionnaires() {
        return rawQuestionnaires;
    }

    public int getNbQuestionnaires() {
        return nbQuestionnaires;
    }
}
