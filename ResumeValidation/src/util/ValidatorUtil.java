package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ValidatorUtil {

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^\\d{10}$");
    }

    public static void saveToVerifiedFile(String basePath, String name, String email, String phone, List<String> skills) {
        try {
            File dir = new File(basePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(basePath + "\\verifyemail.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true); // Append mode
            String skillLine = String.join(", ", skills);
            String line = name + " | " + email + " | " + phone + " | " + skillLine + "\n";
            writer.write(line);
            writer.close();

            System.out.println("Verified entry saved ");
        } catch (IOException e) {
            System.out.println("Error writing to verifyemail.txt: " + e.getMessage());
        }
    }
}
