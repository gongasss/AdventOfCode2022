package Dia3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;

public class Dia3_1 {
    public static void main(String[] args) throws FileNotFoundException {

        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        char letra = 'a';

        File fl = new File("src/Dia3/input.txt");
        if(fl.exists()){
            System.out.println("Fichero localizado con éxito.");
        }
        Scanner sc = new Scanner(fl);
        while(sc.hasNextLine()){
            String linea=sc.nextLine().trim();
            System.out.println(linea);
            String linea1=linea.substring(0,linea.length()/2);
            System.out.println(linea1);
            String linea2=linea.substring(linea.length()/2, linea.length());
            System.out.println(linea2);

            for(int i=0;i<linea1.length();i++){
                char ch1 = linea1.charAt(i);
                for(int j=0;j<linea2.length();j++){
                    char ch2 = linea2.charAt(j);
                    if(ch1==ch2){
                        letra=ch1;
                    }
                }
        }
            for(int k=1;k<abc.length()+1;k++){
                char abc_ch = abc.charAt(k-1);
                if(abc_ch==letra){
                    sum+=k;
                }
            }
    }
        System.out.println(sum);


    }
}
