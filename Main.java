import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        while (true){
            System.out.println("Введи 'y', чтобы начать новую игру или 'n', чтобы выйти.");
            String ans = (new Scanner(System.in)).nextLine();

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
