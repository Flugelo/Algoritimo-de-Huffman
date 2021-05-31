package me.flugel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static me.flugel.Coding.*;

public class Main {

    private static ArrayList<Node> nodes;


    public static void main(String[] args) throws IOException {
        nodes = new ArrayList<>();
        File normalFile, compiladoFile, descompiladoFile;
        String texto = JOptionPane.showInputDialog(null, "Escreva um texto:");
        boolean corret = true;


        while (corret){
            String path = JOptionPane.showInputDialog(null, "Coloque a localização onde sera salvo os arquvio .TXT");
            String normal = JOptionPane.showInputDialog(null, "Nome do arquivo que sera salvo o texto normal:");
            String compilado = JOptionPane.showInputDialog(null, "Nome do arquivo que sera salvo o compilamento:");
            String descompilado = JOptionPane.showInputDialog(null, "Nome do arquivo que sera salvo o descompilamento:");

            normalFile = new File(path + "/" + normal + ".txt");
            compiladoFile = new File(path + "/" + compilado + ".txt");
            descompiladoFile = new File(path + "/" + descompilado + ".txt");
            if(normalFile.mkdirs()){

                if (!normalFile.exists()) {
                    normalFile.createNewFile();
                }
                if(!descompiladoFile.exists()){
                    descompiladoFile.createNewFile();
                }
                if(!compiladoFile.exists()){
                    compiladoFile.createNewFile();

                }
                corret = false;
                String code = code(texto);
                System.out.println("Texto a ser codificado: " + texto);
                System.out.println("Codificado: " + code);
                System.out.println("Decodificado: " + decode(code));
                JOptionPane.showMessageDialog(null, "Arquivos criados....");

                PrintWriter normalWrithe = new PrintWriter(normalFile);
                normalWrithe.println(texto);
                normalWrithe.close();
                PrintWriter compiladoWrithe = new PrintWriter(compiladoFile);

                compiladoWrithe.println(code);
                compiladoWrithe.close();
                PrintWriter descompialdoWrithe = new PrintWriter(descompiladoFile);
                descompialdoWrithe.println(decode(code));
                descompialdoWrithe.close();
                JOptionPane.showMessageDialog(null, "Algoritimo de Huffman aplicado com sucesso!");


            }else JOptionPane.showMessageDialog(null, "Localização não encontrada.");

        }



    }

    public static ArrayList<Node> getNodes() {
        return nodes;
    }
}


