package me.ldanjel;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Tools {
    static String URL = "https://api.dicionario-aberto.net/random";

    public static HttpResponse callGET(String URI) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(java.net.URI.create(URI))
                .build();

        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(InterruptedException | IOException e) {
            System.out.println("Um erro: " + e);
        }

        return response;
    }

    public static Boolean checkWrongWord(String word) {
        ArrayList<Character> alphabet = createCharArrayList('a', 'z');

        boolean hasWrongLetter = false;

        for (int i = 0; i < word.length(); i++) {
            if(!alphabet.contains(word.charAt(i))) {
                hasWrongLetter = true;
                break;
            }
        }

        return hasWrongLetter;
    }

    public static ArrayList<Character> createCharArrayList(char from, char to) {
        ArrayList<Character> charArrayList = new ArrayList<>();
        for(char character = from; character < to; character++) {
            charArrayList.add(character);
        }

        return charArrayList;
    }

    public static String getInputChar() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("> ");
            input = scanner.nextLine();
        } while (input.length() != 1);

        return Character.toString(input.charAt(0));
    }

    public static void doWordReplacing(String word, String letter, StringBuilder lines) {
        do {
            int wordIndex = word.indexOf(letter);
            word.replace(letter, " ");
            lines.setCharAt(wordIndex, letter.toCharArray()[0]);
        } while(!word.contains(letter));
    };


}
