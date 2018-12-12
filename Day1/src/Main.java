import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        Reader r1 = new Reader();

        //Replace the file with the text containing numbers with "+" or "-" in front
        //i.e +14, -151, +15, -121...
        r1.readFile("...\\Code\\AdventOfCode\\Day1\\src\\numbers.txt");
        r1.addOrSubtract();

    }
}

class Reader{

    private List<String> numbers = new ArrayList<>();

    public List<String> readFile(String filename){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                numbers.add(line);
            }
            reader.close();
            System.out.println(numbers);
            return numbers;
        } catch (Exception e){
            System.err.format("Exception occurred trying to read the file", filename);
            e.printStackTrace();
            return null;
        }
    }

    public void addOrSubtract(){
        int result = 0;
        for (String i : numbers) {
            if (i.contains("+")){
                result += Integer.parseInt(i);
            } else if (i.contains("-")){
                int negNum = Integer.valueOf(i);
                result -= Math.abs(negNum);
            } else {
                System.out.println("Invalid Character." + i);
            }
        }
        System.out.println(result);
    }
}