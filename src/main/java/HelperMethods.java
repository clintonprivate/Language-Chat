import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HelperMethods {

    public String translateText(String text, String targetLanguage) {
        String pythonScriptPath = "src/main/resources/python/translate.py";
        try {
            // Build the command to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, text, targetLanguage);

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish and get the exit code
            int exitCode = process.waitFor();

            // Check if the process exited successfully
            if (exitCode == 0) {
                return output.toString().trim();
            } else {
                System.err.println("Error executing Python script. Exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

	public String informalizeText(String text) {

		/* Creating a dictionary using HashMap
        Map<String, String> dictionary = new HashMap<>();

        // Adding key-value pairs to the dictionary
        dictionary.put("ben sie ", "st du ");
        dictionary.put("ben sie sich ", "st du dich ");
        dictionary.put("tten sie ", "ttest du ");
        dictionary.put("tten sie sich ", "ttest du dich ");
        dictionary.put("en sie ", "st du ");
        dictionary.put("en sie sich ", "st du dich ");
        dictionary.put(". sind ihnen ", ". Ist dir ");
		
        // Replace keys with their values in the input string
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            text = text.replaceAll("(?i)" + key, value);
        }*/
        
        return text;
	}
}
