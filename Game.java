
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String wordToGuess;
    private ArrayList<Character> userAnswers = new ArrayList<>();


    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }


    public void play() {
        System.out.println(String.format("Начнём! В слове %d букв", wordToGuess.length()));
        Scanner scanner = new Scanner(System.in);
        Gibbet gibbet = new Gibbet();

        while (true) {
            System.out.println("\nВведи букву:");
            String letter = scanner.nextLine();

            if (!WordUtils.isValidSymbol(letter)) {
                System.out.println("Невалидная буква!");
                continue;
            }

            char charLetter = letter.charAt(0);

            if (wordToGuess.contains(letter) && !userAnswers.contains(charLetter)) {
                // есть такая буква, и её ещё НЕ вводили
                userAnswers.add(charLetter);
                System.out.println("Есть такая буква!");

            } else if (wordToGuess.contains(letter) && userAnswers.contains(charLetter)) {
//                userAnswers.add(charLetter);
                System.out.println("Ты уже называл эту букву!");
//                System.out.println(WordUtils.getPartOfWord(wordToGuess, userAnswers));
            } else if (!wordToGuess.contains(letter) && userAnswers.contains(charLetter)) {
//                userAnswers.add(charLetter);
                System.out.println("Ты уже называл эту букву!");
//                System.out.println(WordUtils.getPartOfWord(wordToGuess, userAnswers));
                // нет такой буквы, и её уже вводили
            } else if (!wordToGuess.contains(letter) && !userAnswers.contains(charLetter)) {
                // нет такой буквы, её ещё НЕ вводили (+счётчик)
                userAnswers.add(charLetter);
                gibbet.addState();
                System.out.println(String.format("Нет такой буквы! Кол-во ошибок: %d/%d",
                        gibbet.getCurState(), gibbet.getNumStates()));
                System.out.println(gibbet.getCurStateStr());
//                System.out.println(WordUtils.getPartOfWord(wordToGuess, userAnswers));
            }

            if (WordUtils.listContainsAllLettersOfString(wordToGuess, userAnswers)) {
                System.out.println("Ты выиграл! Загаданное слово: " + wordToGuess + "\n");
                break;
            } else if (!WordUtils.listContainsAllLettersOfString(wordToGuess, userAnswers) && gibbet.isFinalState()) {
                System.out.println("Ты проиграл! Загаданное слово: " + wordToGuess + "\n");
                break;
            }
            System.out.println(WordUtils.getPartOfWord(wordToGuess, userAnswers));



        }
    }


    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }
}
