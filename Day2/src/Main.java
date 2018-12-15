import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        Reader r1 = new Reader();
        r1.getIdNumbers("...\\AdventOfCode2018\\Day2\\Day2\\src\\checksum.txt");
        r1.createMapArray();
        r1.calculateCheckSum();
    }
}

class Reader {

    private List<String> idNumbers = new ArrayList<>();
    private Map<Character, Integer> map = new HashMap<>();
    private Collection<Integer> charCount = map.values();
    private int tripleLetter = 0;
    private int doubleLetter = 0;

    public List<String> getIdNumbers(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                idNumbers.add(line);
            }
            return idNumbers;
        } catch (Exception e) {
            System.err.format("Exception in file", fileName);
            e.printStackTrace();
        }
        return null;
    }

    public void createMapArray() {
        for (int i = 0; i < idNumbers.size(); i++) {
            String idNum = idNumbers.get(i);
            for (int j = 0; j < idNum.length(); j++) {
                char c = idNum.charAt(j);
                Integer count = map.get(c);
                if (count == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, count + 1);
                }
            }
            if (charCount.stream().anyMatch(n -> n == 3)) {
                tripleLetter++;
            }

            if (charCount.stream().anyMatch(n -> n == 2)) {
                doubleLetter++;
            }
            map.clear();
        }

    }


    public int calculateCheckSum() {
        int result = doubleLetter * tripleLetter;
        System.out.println("Triple: " + tripleLetter);
        System.out.println("Double: " + doubleLetter);
        System.out.println("Total : " + result);
        return result;
    }
}