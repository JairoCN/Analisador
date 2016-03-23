package analisador;

%%

%class LexicoVisualg
%public
%type Token
%line
%column

%{
    StringBuffer string = new StringBuffer();

    private Token token(Token.T type){
        return new Token(type, yyline, yycolumn);
    }

    private Token token(Token.T type, Object val){
        return new Token(type, val, yyline, yycolumn);
    }
%}

FinalLinha      =   \r|\n|\r\n
Caracter        =   [^\r\n]
Branco          =   {FinalLinha} | [ \t\f]

/* comentários */
Comentario      =   "//" {Caracter}* {FinalLinha}


Numero          =   [0-9]
Inteiro         =   {Numero}+
Real            =   {Inteiro}+ "." {Inteiro}* | {Inteiro}* "." {Inteiro}+
Letra           =   [a-zA-Z]

Id              =   {Letra}({Letra} | {Inteiro})*

%state LITERAL

%%


<YYINITIAL> {
/* palavras reservdas */
   "aleatorio"     {return token(Token.T.RESERVADA, yytext()); }
   "abs"           {return token(Token.T.RESERVADA, yytext()); }
   "algoritmo"     {return token(Token.T.RESERVADA, yytext()); }
   "arccos"        {return token(Token.T.RESERVADA, yytext()); }
   "arcsen"        {return token(Token.T.RESERVADA, yytext()); }
   "arctan"        {return token(Token.T.RESERVADA, yytext()); }
   "arquivo"       {return token(Token.T.RESERVADA, yytext()); }
   "asc"           {return token(Token.T.RESERVADA, yytext()); }  
   "caracter"      {return token(Token.T.RESERVADA, yytext()); }
   "caso"          {return token(Token.T.RESERVADA, yytext()); }
   "compr"         {return token(Token.T.RESERVADA, yytext()); }
   "copia"         {return token(Token.T.RESERVADA, yytext()); }
   "cos"           {return token(Token.T.RESERVADA, yytext()); }
   "cotan"         {return token(Token.T.RESERVADA, yytext()); }
   "cronometro"    {return token(Token.T.RESERVADA, yytext()); }
   "debug"         {return token(Token.T.RESERVADA, yytext()); }
   "declare"       {return token(Token.T.RESERVADA, yytext()); }
   "eco"           {return token(Token.T.RESERVADA, yytext()); }
   "enquanto"      {return token(Token.T.RESERVADA, yytext()); }
   "entao"         {return token(Token.T.RESERVADA, yytext()); }
   "escolha"       {return token(Token.T.RESERVADA, yytext()); }
   "escreva"       {return token(Token.T.RESERVADA, yytext()); }
   "exp"           {return token(Token.T.RESERVADA, yytext()); }
   "faca"          {return token(Token.T.RESERVADA, yytext()); }
   "falso"         {return token(Token.T.RESERVADA, yytext()); }
   "fimalgoritmo"  {return token(Token.T.RESERVADA, yytext()); }
   "fimenquanto"   {return token(Token.T.RESERVADA, yytext()); }
   "fimescolha"    {return token(Token.T.RESERVADA, yytext()); }
   "fimfuncao"     {return token(Token.T.RESERVADA, yytext()); }
   "fimpara"       {return token(Token.T.RESERVADA, yytext()); }
   "fimprocedimento" {return token(Token.T.RESERVADA, yytext()); }
   "fimrepita"     {return token(Token.T.RESERVADA, yytext()); }
   "fimse"         {return token(Token.T.RESERVADA, yytext()); }
   "funcao"        {return token(Token.T.RESERVADA, yytext()); }
   "grauprad"      {return token(Token.T.RESERVADA, yytext()); }
   "inicio"        {return token(Token.T.RESERVADA, yytext()); }
   "int"           {return token(Token.T.RESERVADA, yytext()); }
   "interrompa"    {return token(Token.T.RESERVADA, yytext()); }
   "leia"          {return token(Token.T.RESERVADA, yytext()); }
   "literal"       {return token(Token.T.RESERVADA, yytext()); }
   "log"           {return token(Token.T.RESERVADA, yytext()); }
   "logico"        {return token(Token.T.RESERVADA, yytext()); }
   "logn"          {return token(Token.T.RESERVADA, yytext()); }
   "maiusc"        {return token(Token.T.RESERVADA, yytext()); }
   "mensagem"      {return token(Token.T.RESERVADA, yytext()); }
   "minusc"        {return token(Token.T.RESERVADA, yytext()); }
   "numerico"      {return token(Token.T.RESERVADA, yytext()); }
   "numpcarac"     {return token(Token.T.RESERVADA, yytext()); }
   "outrocaso"     {return token(Token.T.RESERVADA, yytext()); }
   "para"          {return token(Token.T.RESERVADA, yytext()); }
   "passo"         {return token(Token.T.RESERVADA, yytext()); }
   "pausa"         {return token(Token.T.RESERVADA, yytext()); }
   "pi"            {return token(Token.T.RESERVADA, yytext()); }
   "pos"           {return token(Token.T.RESERVADA, yytext()); }
   "procedimento"  {return token(Token.T.RESERVADA, yytext()); }
   "quad"          {return token(Token.T.RESERVADA, yytext()); }
   "radpgrau"      {return token(Token.T.RESERVADA, yytext()); }
   "raizq"         {return token(Token.T.RESERVADA, yytext()); }
   "rand"          {return token(Token.T.RESERVADA, yytext()); } 
   "randi"         {return token(Token.T.RESERVADA, yytext()); }
   "repita"        {return token(Token.T.RESERVADA, yytext()); }
   "se"            {return token(Token.T.RESERVADA, yytext()); }
   "sen"           {return token(Token.T.RESERVADA, yytext()); }
   "senao"         {return token(Token.T.RESERVADA, yytext()); }
   "timer"         {return token(Token.T.RESERVADA, yytext()); }
   "tan"           {return token(Token.T.RESERVADA, yytext()); }
   "verdadeiro"    {return token(Token.T.RESERVADA, yytext()); }
   "xou"           {return token(Token.T.RESERVADA, yytext()); }

    "E"           {return token(Token.T.MULTLOGICA); }
    "Ou"          {return token(Token.T.ADICLOGICA); }
    "Nao"         {return token(Token.T.NEGACAO); }

   {Inteiro}       {return token(Token.T.INTEIRO, new Integer(yytext())); }
   {Real}          {return token(Token.T.REAL, new Double(yytext())); }

/* identidicadores */
    {Id}           {return token(Token.T.ID, yytext()); }

/* literal */
    \"             { string.setLength(0); yybegin(LITERAL); }

    {Branco}       {}

/* operadores */
    "+"           {return token(Token.T.SOMA); }
    "-"           {return token(Token.T.SUBTRACAO); }
    "*"           {return token(Token.T.MULTIPLICACAO); }
    "/"           {return token(Token.T.DIVISAO); }
    "\\"          {return token(Token.T.DIVISAOINTEIRA); }
    "^"           {return token(Token.T.EXPONENCIACAO); }
    "%"           {return token(Token.T.MODULO); }

    ">"           {return token(Token.T.MAIOR); }
    "<"           {return token(Token.T.MENOR); }
    ">="          {return token(Token.T.MAIORIGUAL); }
    "<="          {return token(Token.T.MENORIGUAL); }
    "="           {return token(Token.T.IGUAL); }
    "<>"          {return token(Token.T.DIFERENTE); }

    "("          {return token(Token.T.ABREPARENTESES); }
    ")"          {return token(Token.T.FECHAPARENTESES); }

    "<-"          {return token(Token.T.ATRIBUICAO); }

}

<LITERAL> {
    \"            { yybegin(YYINITIAL);
                    return token(Token.T.LITERAL,
                    string.toString()); }
    [^\n\r\"\\]+  { string.append( yytext() ); }
}

    [^]           { return token(Token.T.ERRO); }