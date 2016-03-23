/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.util.Formatter;

/**
 *
 * @author jairo
 */
public class Token {
    public enum T { RESERVADA, ID, LITERAL, SOMA, SUBTRACAO, MULTIPLICACAO, 
                    DIVISAO, DIVISAOINTEIRA,EXPONENCIACAO, MODULO, MAIOR,
                    MENOR, MAIORIGUAL, MENORIGUAL, IGUAL, DIFERENTE, 
                    MULTLOGICA, ADICLOGICA, NEGACAO, ATRIBUICAO, ERRO,
                    INTEIRO, REAL, BRANCO, EOF; }
    public T type;
    public Object val;
    public int line;
    public int col;
    
    public Token(T type, int line, int col){
        this.type = type;
        this.line = line;
        this.col = col;
    }
    
    public Token(T type, Object val, int line, int col){
        this.type = type;
        this.val = val;
        this.line = line;
        this.col = col;
    }
    
    public String toString(){
        Formatter out = new Formatter();
        out.format("Token[%s] - Linha:%d/Coluna:%d", type, line, col);
        if (val != null)
            out.format("/Lexema[%s]", val);
        out.format("\n");
        return out.toString();
    }
}
