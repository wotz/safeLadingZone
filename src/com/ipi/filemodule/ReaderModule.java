package com.ipi.filemodule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class ReaderModule {

    public ReaderModule() {
    }

//    public static List<BufferedImage> readAsphalt(int begin, int end) {
//        List<BufferedImage> images = new ArrayList<>();
//        for (int i = begin; i <= end; i ++) {
//            try {
//                images.add(image);
//            } catch (IOException e) {
//                System.exit(1);
//            }
//        }
//        return images;
//    }

    public static String read(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

}
