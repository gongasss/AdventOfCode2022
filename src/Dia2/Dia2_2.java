package Dia2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dia2_2 {
    public static void main(String[] args) {
        final int PPF_Rock = 1;
        final int PPF_Paper = 2;
        final int PPF_Scissors = 3;
        final int win = 6;
        final int tie = 3;
        final int loss = 0;
        int opp_roundScore = 0;
        int self_roundScore = 0;
        int opp_totalScore = 0;
        int self_totalScore = 0;
        int victorias = 0;

        try{
            File fl = new File("src/Dia2/input.txt");
            if(fl.exists()){
                System.out.println("Fichero localizado con éxito.");
            }
            Scanner sc = new Scanner(fl);

            while (sc.hasNextLine()){
                String linea = sc.nextLine().trim();
                char opp = linea.charAt(0);
                char toDo = linea.charAt(2);
                char self = 'H';


                if (opp=='A'){
                    if(toDo=='X'){
                        self = 'Z';
                    }
                    if(toDo=='Y'){
                        self = 'X';
                    }
                    if(toDo=='Z'){
                        self = 'Y';
                    }
                    opp_roundScore += PPF_Rock;
                    if(self=='Z'){
                        self_roundScore+=PPF_Scissors;
                        opp_roundScore+=win;
                        self_roundScore+=loss;
                    }else{
                        if(self=='Y'){
                            self_roundScore+=PPF_Paper;
                            opp_roundScore+=loss;
                            self_roundScore+=win;
                            victorias++;
                        }else{
                            self_roundScore+=PPF_Rock;
                            opp_roundScore+=tie;
                            self_roundScore+=tie;
                        }
                    }
                }
                if (opp=='B'){
                    if(toDo=='X'){
                        self = 'X';
                    }
                    if(toDo=='Y'){
                        self = 'Y';
                    }
                    if(toDo=='Z'){
                        self = 'Z';
                    }

                    opp_roundScore += PPF_Paper;
                    if(self=='X'){
                        self_roundScore+=PPF_Rock;
                        opp_roundScore += win;
                        self_roundScore+=loss;
                    }else{
                        if(self=='Z'){
                            self_roundScore+=PPF_Scissors;
                            opp_roundScore+=loss;
                            self_roundScore+=win;
                            victorias++;
                        }else{
                            self_roundScore+=PPF_Paper;
                            opp_roundScore+=tie;
                            self_roundScore+=tie;
                        }
                    }
                }
                if (opp == 'C'){
                    if(toDo=='X'){
                        self = 'Y';
                    }
                    if(toDo=='Y'){
                        self = 'Z';
                    }
                    if(toDo=='Z'){
                        self = 'X';
                    }
                    opp_roundScore += PPF_Rock;
                    if(self=='Y'){
                        self_roundScore+=PPF_Paper;
                        opp_roundScore += win;
                        self_roundScore+=loss;
                    }else{
                        if(self=='X'){
                            self_roundScore+=PPF_Rock;
                            opp_roundScore+=loss;
                            self_roundScore+=win;
                            victorias++;
                        }else{
                            self_roundScore+=PPF_Scissors;
                            opp_roundScore+=tie;
                            self_roundScore+=tie;
                        }
                    }
                }

                opp_totalScore+=opp_roundScore;
                self_totalScore+=self_roundScore;

                opp_roundScore=0;
                self_roundScore=0;
            }

            System.out.println("Puntos totales: "+self_totalScore);
            System.out.println("Victorias: "+victorias);

        }catch(FileNotFoundException exception){
            System.out.println("Fichero no encontrado.");
        }

    }
}
