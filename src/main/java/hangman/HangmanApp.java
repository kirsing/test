package hangman;

public class HangmanApp {
    public static void main(String[] args) {
        HangmanGameService hangmanGameService = new HangmanGameService();
        hangmanGameService.start();
    }
}
