import java.io.IOException;
import java.util.Scanner;
import java.util.Objects;

public class FilePractice {


    public static void main ( String [] args ) throws IOException{

        Game hello = new Game();

//        String [] movieNames = hello.returnMovieList();

        String answer = hello.pickOne();

//      System.out.println(answer);
        // this is the answer!

        StringBuilder answer_copy = new StringBuilder(answer.replaceAll("[a-zA-Z]", "_"));
        String answer2 = answer;


        int wrongWord = 0;
        String wrongWords = new String();

        while(true) {
            if( Objects.equals(answer, answer_copy.toString())){
                System.out.println("You win!");
                System.out.println("You have guessed '" + answer + "' correctly.");
                break;

            } else if(wrongWord>9) {

                System.out.println("You have lost 10 points...");
                System.out.println("The answer was... " + answer + "!!!");
                break;

            } else{
                    System.out.println("You are guessing: " + answer_copy);

                    System.out.println("You have lost (" + wrongWord + ") points:" + wrongWords);



                    System.out.println("Guess a letter:");

                    Scanner reader = new Scanner(System.in);
                    char c = reader.next(".").charAt(0);

                    while (!(Character.isLetter(c))) {
                        System.out.println("Try again with valid letter: ");
                        c = reader.next(".").charAt(0);
                    }

                    boolean x = true;

                    int indexGuess = answer2.indexOf(c);

                    if (indexGuess > -1) {
                        while(indexGuess>-1) {
                            answer_copy.setCharAt(indexGuess, c);
                            answer2 = answer2.substring(0, indexGuess) + '_' + answer2.substring(indexGuess + 1);
                            indexGuess = answer2.indexOf(c);
                        }
                    } else {
                        wrongWords = wrongWords + " " + c;
                        wrongWord++;
                    }
                }
            }
        }
    }


