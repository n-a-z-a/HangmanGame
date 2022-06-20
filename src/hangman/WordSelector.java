package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordSelector {

    ArrayList<String> words = new ArrayList<>();


    public void createWordsArray() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/hangman/words.txt"));

        String word = bf.readLine();

        while (word != null) {
            words.add(word);
            word = bf.readLine();
        }

        bf.close();

    }

    public String wordSelector() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size())).toUpperCase();
    }


}
