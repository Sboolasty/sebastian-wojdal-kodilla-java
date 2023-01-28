package com.kodilla.stream;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier PoemBeautifier = new PoemBeautifier();
        String beauty1 = PoemBeautifier.beautify("Poem", s -> "ABC" + s + "ABC");
        String beauty2 = PoemBeautifier.beautify("Poem", s -> s.toUpperCase());
        String beauty3 = PoemBeautifier.beautify("Poem", s -> s.replace('e', 'E'));
        String beauty4 = PoemBeautifier.beautify("Poem", s -> "O_O" + s + "^^");
        System.out.println(beauty1);
        System.out.println(beauty2);
        System.out.println(beauty3);
        System.out.println(beauty4);
    }
}