
import java.util.*;

public class Game {

    private final String wordToGuess;
    private final HashSet<Character> userAnswers = new HashSet<>();


    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }


    public void play() {
        System.out.printf("Начнём! В слове %d букв%n", wordToGuess.length());
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
                System.out.printf("Нет такой буквы! Кол-во ошибок: %d/%d%n",
                        gibbet.getCurState(), gibbet.getNumStates());
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

            System.out.print("\nТы использовал буквы: ");
            userAnswers.stream().map(x -> x + ", ").forEach(System.out::print);
            System.out.println("\n" + WordUtils.getPartOfWord(wordToGuess, userAnswers));


        }
    }

}
