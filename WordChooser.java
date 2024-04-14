import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordChooser {

    public static int minWordLength = 6;
    public static String srcFileName = "words_orig.txt";
    public static String targetFileName = "words.txt";
    private static final ArrayList<String> wordList = new ArrayList<>();


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


    public static String getRandomWord(){
        if (!wordList.isEmpty()){
            int randomIdx = new Random(wordList.size()).nextInt();
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
            int size = wordList.size();
            int randomIdx = new Random().nextInt(wordList.size());
            return wordList.get(randomIdx);
        }
        else {
            return null;
        }

    }



}
