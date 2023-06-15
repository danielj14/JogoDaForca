package me.ldanjel;

import org.json.JSONObject;

public class Game {

    public static String genWord() {
        //Cria a palavra e a deixa com um è invalido
        String word = "è";

        /*
        Se a palavra tiver acento ou algo do tipo
        o loop vai ligar e vai gerar uma palavra nova
        até vir uma palavra correta
        */

        while(Tools.checkWrongWord(word)) {
            String body = Tools.callGET(Tools.URL).body().toString();
            JSONObject bodyJson = new JSONObject(body);

            word = bodyJson.getString("word");
        }

        /*
        Funciona do seguinte jeito:
        - Cria uma palavra invalida
        - Sendo invalida, o loop inicia e começa a gerar uma palavra valida

        - Uma palavra invalida não pode ter:
        Espaço, traço, acento, pontuação.
        Apenas letras do alfabeto são permitidas
         */

        return word;
    }

    public static void guessWord() {

        String word = genWord();
        StringBuilder lines = new StringBuilder("_".repeat(word.length()));

        int lives = 10;
        String letter;

        System.out.println("Jogo começado.");

        while(lives > 0) {
            letter = Tools.getInputChar();

            if(word.contains(letter)) {
                Tools.doWordReplacing(word, letter, lines);
            } else {
                lives -= 1;
            }

            System.out.printf("Vidas: %d\n%s\n", lives, lines);
        }
    }

}
