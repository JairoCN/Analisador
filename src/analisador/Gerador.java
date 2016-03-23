/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.io.File;

/**
 *
 * @author jairo
 */
public class Gerador {
    public static void main(String[] args) {
        String path = "C:/Users/jairo/Documents/NetBeansProjects/Analisador/src/analisador/";
        String arquivo = path + "LexicoVisualg.flex";
        
        File file = new File(arquivo);
        jflex.Main.generate(file);
    }
}
