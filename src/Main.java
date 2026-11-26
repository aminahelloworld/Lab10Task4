import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputFile = "studentsEN.txt";
        String outputFile = "studentsGrade5.txt";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_16));
             FileWriter writer = new FileWriter(outputFile, StandardCharsets.UTF_8)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\t");
                String grade = parts[parts.length - 1].trim();

                if (grade.equals("5")) {
                    writer.write(line + System.lineSeparator());
                    count++;
                }
            }

            System.out.println("Done! Students with grade 5: " + count);
            System.out.println("Saved to file: " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}