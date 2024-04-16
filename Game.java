
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


    public void play(){
        System.out.println(String.format("Начнём! В слове %d букв", wordToGuess.length()));
        Scanner scanner = new Scanner(System.in);
        Gibbet gibbet = new Gibbet();

        while (true){
            System.out.println("\nВведи букву:");
            String letter = scanner.nextLine();

            if (WordUtils.isValidSymbol(letter)) {
                char charLetter = letter.charAt(0);


                if (wordToGuess.contains(letter) && !userAnswers.contains(charLetter)){
                    // есть такая буква, и её ещё НЕ вводили
                    userAnswers.add(charLetter);
                    System.out.println("Есть такая буква!");
                    System.out.println(WordUtils.getPartOfWord(wordToGuess, userAnswers));
                }
                else if (wordToGuess.contains(letter) && userAnswers.contains(charLetter)) {
                    userAnswers.add(charLetter);
                    // есть такая буква, и её уже вводили
                } else if (!wordToGuess.contains(letter) && userAnswers.contains(charLetter)) {
                    userAnswers.add(charLetter);
                    // нет такой буквы, и её уже вводили
                } else if (!wordToGuess.contains(letter) && !userAnswers.contains(charLetter)) {
                    userAnswers.add(charLetter);
                    // нет такой буквы, её ещё НЕ вводили (+счётчик)
                }

//                List<String> l = Arrays.asList((Character) wordToGuess.split(""));
//                if (userAnswers){
//                    int
//                }

            }

            else {
                System.out.println("Невалидная буква!");
            }
        }

//        scanner.close();
    }





    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }
}
