import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner mainScanner = new Scanner(System.in);
        while (true){

            System.out.println("Введи 'д', чтобы начать новую игру или 'н', чтобы выйти.");
            String ans = mainScanner.nextLine();

            if (ans.equals("д")){

            Game game = new Game(WordUtils.getRandomWord());
            game.play();

            } else if (ans.equals("н")) {
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Не понял твоей команды :(");
            }

        }


    }



}
