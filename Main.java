import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

//        while (true){
//            System.out.println(WordUtils.getRandomWord());
//            if (false){
//                break;
//            }
//        }

        Scanner mainScanner = new Scanner(System.in);
        while (true){
            System.out.println("Введи 'y', чтобы начать новую игру или 'n', чтобы выйти.");
            String ans = mainScanner.nextLine();

            if (ans.equals("y")){

            Game game = new Game(WordUtils.getRandomWord());
            game.play();

            } else if (ans.equals("n")) {
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Не понял твоей команды :(");
            }

        }




    }



}
