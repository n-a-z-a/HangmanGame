package hangman;

import java.io.IOException;
import java.util.Scanner;

public class Hangman {
    private Scanner scanner = new Scanner( System.in );
    WordSelector wordSelector = new WordSelector();
    LettersUsed lettersUsed = new LettersUsed();
    HangmanFigure hangmanFigure = new HangmanFigure();


    private boolean isLetterAlreadyUsed(String letter) {
        return this.lettersUsed.getLettersUsed().contains(letter);
    }

    private void addLetterUsed (String letterUsed) {
        this.lettersUsed.getLettersUsed().add(letterUsed);
    }

    private boolean isEmpty() {
        return this.lettersUsed.getLettersUsed().isEmpty();
    }


    public void play() throws IOException {
        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the hidden word by guessing one letter at a time");
        System.out.println("You have 7 lives to do it! Good luck|");
        wordSelector.createWordsArray();
        String word = wordSelector.wordSelector();
        char[] wordHidden = word.replaceAll(".","_").toCharArray();
        System.out.println(String.valueOf(wordHidden));
        System.out.println("Please enter a letter:");

        int currentHangmanFigureIndex = 0;
        int lives = 7;

        while(true) {
            String letter = scanner.nextLine().replace(" ", "").toUpperCase();
            if (letter.length() != 1 || !letter.matches("^[A-Za-z]")) {
                System.out.println("Please enter one valid letter:");
            } else if (!isEmpty() && isLetterAlreadyUsed(letter)) {
                System.out.println("You've already entered this letter! Please enter a new one:");
            } else if (word.contains(letter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        wordHidden[i] = letter.charAt(0);
                    }
                }
                System.out.println(wordHidden);
                if (word.compareTo(String.valueOf(wordHidden)) != 0) {
                    addLetterUsed(letter);
                    System.out.println("Please enter a letter:");
                } else {
                    System.out.println("Congratulations! You win!");
                    System.out.println("Thanks for playing!");
                    break;
                }
            } else {
                addLetterUsed(letter);
                System.out.println(hangmanFigure.getHangmanFigure(currentHangmanFigureIndex));
                currentHangmanFigureIndex++;
                lives--;
                if (lives == 0) {
                    System.out.println("Oh no! No more chances! You lose!");
                    break;
                } else {
//                    System.out.println(lettersUsed.getLettersUsed());
                    System.out.println("Wrong guess!");
                    System.out.println("Lives left: " + lives);
                    System.out.println(wordHidden);
                    System.out.println("Try again with another letter:");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Hangman hangman = new Hangman();
        hangman.play();

    }
}
