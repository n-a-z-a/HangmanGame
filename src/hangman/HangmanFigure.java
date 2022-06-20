package hangman;

public class HangmanFigure {

    private String[] hangmanFigure = {
            "\n \n \n \n \n \n ____|____",
            "\n     |\n     |\n     |\n     |\n     |\n ____|____",
            "     _______\n     |\n     |\n     |\n     |\n     |\n ____|____",
            "     _______\n     |     |\n     |    ( )\n     |\n     |\n     |\n ____|____",
            "     _______\n     |     |\n     |    ( )\n     |    /|\\ \n     |\n     |\n ____|____",
            "     _______\n     |     |\n     |    ( )\n     |    /|\\ \n     |     |\n     |\n ____|____",
            "     _______\n     |     |\n     |    ( )\n     |    /|\\ \n     |     |\n     |    / \\\n ____|____"
    };

    public String getHangmanFigure(int index) {
        return hangmanFigure[index];
    }

}
