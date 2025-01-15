import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Enter a password to check its strength: ");
            String password = scanner.nextLine();

            String strength = evaluatePasswordStrength(password);
            System.out.println("Password Strength: " + strength);

            if (!strength.equals("Strong")) {
                System.out.println("Suggestions to improve your password:");
                System.out.println("- Use at least 8 characters.");
                System.out.println("- Include uppercase and lowercase letters.");
                System.out.println("- Add numbers and special characters.");
            }

            System.out.print("Do you want to check another password? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                continueProgram = false;
            }
        }

        System.out.println("Program ended. Stay safe with strong passwords!");
    }

    private static String evaluatePasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++; // checks uppercase
        if (password.matches(".*[a-z].*")) score++; // checks lowercase
        if (password.matches(".*\\d.*")) score++;   // checks digit
        if (password.matches(".*[!@#$%^&*()].*")) score++; // checks special character

        if (score <= 2) return "Weak";
        else if (score == 3 || score == 4) return "Moderate";
        else return "Strong";
    }
}
