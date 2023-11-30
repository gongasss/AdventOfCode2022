package Dia1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dia1_2 {
    public static void main(String[] args) {
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;
        int suma = 0;

        try{

            File fl = new File("src/input.txt");
            System.out.println(fl.exists());
            Scanner sc = new Scanner(fl);

            while (sc.hasNextLine()){

                String linea = sc.nextLine().trim();

                if(linea.isBlank() || linea.isEmpty() || linea.equals(" ")){
                    if(suma>top1){

                        top3 = top2;
                        top2 = top1;
                        top1 = suma;
                        suma = 0;
                    }else{
                        if (suma>top2){
                            top3 = top2;
                            top2 = suma;
                            suma = 0;
                        }else{
                            if (suma>top3){
                                top3 = suma;
                                suma = 0;
                            }
                        }

                        suma=0;
                    }

                }else{

                    int n1 = Integer.parseInt(linea);
                    suma+=n1;
                }
            }

            System.out.println(top1+top2+top3);

            sc.close();

        }catch (FileNotFoundException e){
            System.out.println("Something went wrong.");
        }

    }
}
