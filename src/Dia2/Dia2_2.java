package Dia2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Dia2_2 {
    public static void main(String[] args) {

        final int PPF_Rock = 1;
        final int PPF_Paper = 2;
        final int PPF_Scissors = 3;
        final int win = 6;
        final int tie = 3;
        final int loss = 0;
        final char rock = 'A';
        final char paper = 'B';
        final char sciss = 'C';
        final char ganar = 'Z';
        final char perder = 'X';
        final char empatar = 'Y';
        int roundScore = 0;
        int totalScore = 0;
        int victorias = 0;

        try{
            File fl = new File("src/Dia2/input.txt");
            if(fl.exists()){
                System.out.println("Fichero localizado con éxito.");
            }
            Scanner sc = new Scanner(fl);

            while(sc.hasNextLine()){

                String linea = sc.nextLine().trim();
                char objetivo = linea.charAt(2);
                char rival = linea.charAt(0);

                switch (objetivo){
                    case ganar:
                        roundScore+=win;
                        if(rival==rock){
                            roundScore+=PPF_Paper;
                        }
                        if(rival==paper){
                            roundScore+=PPF_Scissors;
                        }
                        if(rival==sciss){
                            roundScore+=PPF_Rock;
                        }
                        break;
                    case empatar:
                        roundScore+=tie;
                        if(rival==rock){
                            roundScore+=PPF_Rock;
                        }
                        if(rival==paper){
                            roundScore+=PPF_Paper;
                        }
                        if(rival==sciss){
                            roundScore+=PPF_Scissors;
                        }
                        break;
                    case perder:
                        roundScore+=loss;
                        if(rival==rock){
                            roundScore+=PPF_Scissors;
                        }
                        if(rival==paper){
                            roundScore+=PPF_Rock;
                        }
                        if(rival==sciss){
                            roundScore+=PPF_Paper;
                        }
                        break;
                }

                totalScore+=roundScore;
                roundScore=0;
            }

            System.out.println("Puntos totales: "+totalScore);

        }catch(FileNotFoundException exception){
            System.out.println("Fichero no encontrado.");
        }
    }
}
