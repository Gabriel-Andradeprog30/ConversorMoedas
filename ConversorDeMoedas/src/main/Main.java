package main;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {

        startMsg();
        Menu menu = new Menu();
        menu.showMenu();
        endMsg();

    }

    private static void startMsg(){
        System.out.println("""
        ****************************************************************
        
        ----------------------------------------------------------------
        
                 Seja bem-vindo(a) ao Conversor de Moedas!
        """);
    }

    private static void endMsg(){
        System.out.println("""
       
                      --      Pesquisa concluida!     --
        
               Não se esqueça de conferir o arquivo que foi
               gerado com todos os resultados de suas pesquisas.
        
        ----------------------------------------------------------------
        
        ****************************************************************
        """);
    }
}