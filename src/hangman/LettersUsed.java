package hangman;

import java.util.ArrayList;

public class LettersUsed {

    private String letterUsed;

    ArrayList<String> lettersUsed = new ArrayList<String>();

    public String getLetterUsed() {
        return letterUsed;
    }

    public void setLetterUsed(String letterUsed) {
        this.letterUsed = letterUsed;
    }

    public ArrayList<String> getLettersUsed() {
        return lettersUsed;
    }

    public void setLettersUsed(ArrayList<String> lettersUsed) {
        this.lettersUsed = lettersUsed;
    }
}
