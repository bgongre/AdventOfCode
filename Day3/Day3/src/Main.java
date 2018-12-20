import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]){

        Reader r1 = new Reader();
        r1.getClaim("C:\\Users\\TJ3314\\Desktop\\Code\\AdventOfCode\\Day3\\src\\claims.txt");
        r1.editListArray();
        r1.splitListArray();
        r1.findOverlaps();
    }
}

class Reader {

    private List<String> claims = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private List<String> count = new ArrayList<>();

    public List<String> getClaim(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                claims.add(line);
            }
            return claims;
        } catch (Exception e) {
            System.err.format("Exception in file.", fileName);
            e.printStackTrace();
        }
        return null;
    }

    public void editListArray() {
        for (int i = 0; i < claims.size(); i++) {
            String[] str = claims.get(i).replaceAll("\\,", " ").split(" ");
            Collections.addAll(list, str);
            list.remove(str[0]);
            list.remove(str[1]);
            list.remove(str[2]);
            list.remove(str[3]);
        }
    }

    public void splitListArray() {
        for (int i = 0; i < list.size(); i++) {
            List<String> numSplit = list.subList(i, i + 1);
            for (int j = 0; j < numSplit.size(); j++){
                count.addAll(numSplit);
            }
            }
        System.out.println(count);
    }

    public void findOverlaps(){
        int num = 0;
        Map<String, Long> result = count.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Collection<Long> numCount = result.values();
        ArrayList<Long> temp = new ArrayList<>(numCount);
        for (int i = 0; i < temp.size(); i++){
            if (temp.get(i) >= 2){
                num+=temp.get(i);
            }
        }
        System.out.println(num);

        }
    }
