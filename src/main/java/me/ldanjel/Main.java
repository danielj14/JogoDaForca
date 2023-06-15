package me.ldanjel;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                """
                Boas vindas ao jogo da forca!
                Aqui voce deve adivinhar uma letra, se perder as 10 vidas, ja era.
                
                Esse progama foi feito por danielj14, e usa a API do dicionario-aberto.
                https://api.dicionario-aberto.net/
                
                Versão 1.0
                """
        );

        Game.guessWord();
    }
}
