import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Game {


    public String [] returnMovieList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("movieSampleList.txt"));

        String line;
        String [] movieNames = new String[100];
        int i=0;

        while ( (line = reader.readLine()) != null ) {
            movieNames[i] = line;
            i++;
        }

        String [] hello = Arrays.copyOf(movieNames, i);

        return hello;
    }


    public String pickOne() throws IOException{
        String ans = new String();

        String [] temp = this.returnMovieList();

        Random rand = new Random();
        int i = rand.nextInt(temp.length) + 1;

        return temp[i];
    }
}
