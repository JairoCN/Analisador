package analisador;

%%

%class Lexer
%type Token
%line
%column

%{
    private StringBuilder str = new StringBuilder();

    private Token token(Token.T type){
        return new Token(type, yyline, yycolumn);
    }

    private Token token(Token.T type, Object val){
        return new Token(type, val, yyline, yycolumn);
    }
%}

%state STR

alpha   =   [a-zA-Z]
dig     =   [0-9]
id      =   {alpha} ({alpha} | {dig})*
int     =   {dig}+
float   =   {dig}+ "." {dig}* | {dig}* "." {dig}+

%%

<YYINITIAL> {
                if      { return token(Token.T.IF); }
                {id}    { return token(Token.T.ID, yytext()); }
                {int}   { return token(Token.T.INT, new Integer(yytext())); }
                {float} { return token(Token.T.FLOAT, new Double(yytext())); }
                \"      { str.setLength(0);
                          yybegin(STR);
                        }
                [ \t\n\r] + {return token(Token.T.EOF); }
                .       {System.out.printf("Erro: caracter inesperado |%s|\n", yytext()); }
}

<STR> {
        \"          { yybegin(YYINITIAL); return token(Token.T.STR,
                        str.toString()); }
        [^\n\r\\]   { str.append(yytext()); }
        <<EOF>>     { yybegin(YYINITIAL);
                        System.out.println("Erro: String não terminada");
                    }
        .           { yybegin(YYINITIAL);
                        System.out.printf("Erro: quebra de linha inesperada\n");
                    }
}