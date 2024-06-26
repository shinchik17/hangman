import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class WordUtils {

    public static int minWordLength = 6;
    public static String srcFileName = "words_orig.txt";
    public static String targetFileName = "words.txt";
    private static final ArrayList<String> wordList = new ArrayList<>();
    public static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";


    // функция для удаления из исходного словаря слов короче minWordLength,
    // а также содержащих пробел и/или дефис
    public static void removeShortWords(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(targetFileName));
            BufferedReader reader = new BufferedReader(new FileReader(srcFileName)))
        {
            String line;
            while ((line = reader.readLine()) != null){
                if (line.length() >= minWordLength && !line.contains(" ") && !line.contains("-")){
                    writer.write(line + "\n");
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public static boolean isValidSymbol(String symbol) {
        if (symbol == null) {
            return false;
        } else if (symbol.length() > 1) {
            return false;
        } else return alphabet.contains(symbol);
    }


    public static String getRandomWord(){
        if (!wordList.isEmpty()){
//            Random rnd = new Random();
            int randomIdx = (new Random()).nextInt(wordList.size());
            return wordList.get(randomIdx);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(targetFileName)))
        {
            String line;
            while ((line = reader.readLine()) != null){
                wordList.add(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        if (!wordList.isEmpty()) {
            int randomIdx = new Random().nextInt(wordList.size());
            return wordList.get(randomIdx);
        }
        else {
            return null;
        }

    }

    public static boolean listContainsAllLettersOfString(String s, Collection<Character> list){
        if (s.isEmpty()) {
            System.out.println("String is empty");
            return false;}

        for(char chr: s.toCharArray()) {
            if (!list.contains(chr)) {
                return false;
            }
        }

        return true;
    }


    public static String getPartOfWord(String word, Collection<Character> shownLetters){
        StringBuilder resultString = new StringBuilder();
        char[] wordArr = word.toCharArray();

        for (char c : wordArr) {
            if (shownLetters.contains(c)) {
                resultString.append(c);
            } else {
                resultString.append("*");
            }
        }
        return resultString.toString();
    }


}
