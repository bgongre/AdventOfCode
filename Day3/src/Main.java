import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String args[]){

        Reader r1 = new Reader();
        r1.getClaim("C:\\Users\\Brittani\\Desktop\\AdventOfCode2018\\Day3\\Day3\\src\\claims.txt");
        r1.createMapArray();
    }
}

class Reader{

    private List<String> claims = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private List<String> newList = new ArrayList<>();

    public List<String> getClaim(String fileName){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null){
                claims.add(line);
            }
            return claims;
        } catch (Exception e){
            System.err.format("Exception in file.", fileName);
            e.printStackTrace();
        }
        return null;
    }

    public void createMapArray(){
        for (int i = 0; i < claims.size(); i++){
            String[] str = claims.get(i).replaceAll("\\:", "").replaceAll("\\,"," ").replaceAll("x", " ").split(" ");
            Collections.addAll(list, str);
            list.remove(str[0]);
            list.remove(str[1]);
            for (int j = 0; j < list.size(); j+=4){
                List<String> numSplit = list.subList(j, j+4);

            }
        }
        System.out.println(list);
    }

}