package hangman;

import lombok.SneakyThrows;

import java.io.File;
import java.util.*;

public class HangmanGameService {

    private static final String WORDS_TXT = "src/main/resources/words.txt";

    public void start() {
       Scanner inputScanner = new Scanner(System.in);
        String randomWord = getRandomWord();
        char[] randomWordArray = randomWord.toCharArray();
        char[] guessingArray = new char[randomWord.length()];
        Arrays.fill(guessingArray, '_');
        int numberOfChances = randomWord.length();

        System.out.println("Starting the game");
        System.out.println("The length of the word and the number of chances: " + numberOfChances);

        while (true) {
            System.out.println("------------------------");
            System.out.print("Please type in a letter: ");
            String inputLine = inputScanner.nextLine().toLowerCase();
            char letter = inputLine.charAt(0);

            boolean isGuessingCorrect = false;
            for (int i = 0; i < randomWord.length(); i++) {
                if (letter == randomWordArray[i]) {
                    guessingArray[i] = letter;
                    isGuessingCorrect = true;
                }
            }

            if(isGuessingCorrect) {

            } else {
                numberOfChances--;
                if (numberOfChances == 0) {
                    System.out.println("You ran out of chances");
                    System.out.println("The word was: " + randomWord);
                    break;
                }
                System.out.println("Your number of chances is decreased to: " + numberOfChances);
                System.out.println("Try another letter");
            }

            System.out.println("The word: " + new String(guessingArray));
        }
    }

    @SneakyThrows
    private List<String> getWords() {
        List<String> words = new ArrayList<>();

        File wordsFile = new File(WORDS_TXT);

        Scanner wordScanner = new Scanner(wordsFile);
        while (wordScanner.hasNextLine()) {
            words.add(wordScanner.nextLine());
        }
        return words;
    }


    private String getRandomWord() {
        List<String> existedWords = getWords();
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(existedWords.size());

        return existedWords.get(randomIndex);
    }
}
