import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicates_HashSet {

    private static String splitChar = " ";
    private static int requestIndex = 6;
    private static int responseIndex = 8;
    private static String pathSeparator = "/";
    private static String responsePrefix = "gifs_";
    private static String SUCCESS = "200";

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        // O(1) - lookup
        HashSet<String> gifs = new HashSet<>();
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.trim().split(splitChar);
                // Arrays.asList(columns).forEach(System.out::println);

                String request = columns[requestIndex];
                String gifFile = request.substring(request.lastIndexOf(pathSeparator) + 1);
                String response = columns[responseIndex];

                if(!gifs.contains(gifFile) && SUCCESS.equals(response)){
                    gifs.add(gifFile);
                    result.append(gifFile + "\n");
                }
            }

            String resultPath = responsePrefix + filename;

            Path filePath = Path.of(resultPath);

            Files.write(filePath, br.toString().getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }



        gifs.forEach(System.out::println);

        // create response
    }
}