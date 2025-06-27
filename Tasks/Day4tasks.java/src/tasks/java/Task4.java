package tasks.java;

import java.io.*;

public class Task4 {
    public static void main(String[] args) {
        String inputFile = "marks.txt";
        String outputFile = "results.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int total = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i].trim());
                }

                double average = (double) total / (parts.length - 1);
                String result = String.format("%s - Total: %d, Average: %.2f", name, total, average);
                writer.write(result);
                writer.newLine();
            }

            System.out.println("✅ Results written to " + outputFile);
        } catch (IOException | NumberFormatException e) {
            System.out.println("⚠️ Error processing file: " + e.getMessage());
        }
    }
}
