import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Conversation {
	
	private static HelperMethods helperMethods = new HelperMethods();
	
	public static void startConversation() {
        while (true) {
        	String aiResponse = pickRandomQuestion();
            System.out.println("\nAI: " + aiResponse + "\n");
        	Scanner scanner = new Scanner(System.in);
        	System.out.print("You: ");
            String userResponse = scanner.nextLine();
        }
	}
	
	private static String pickRandomQuestion() {
		List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/aiquestions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!lines.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(lines.size());
            return lines.get(randomIndex);
        }
        return null;
	}
}
