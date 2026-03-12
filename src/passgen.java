public class passgen {
    public String generate(String input) {
        if (input == null || input.isEmpty()) {
            return "Please enter something!";
        }
        StringBuilder feedback = new StringBuilder();
        int score = 0;

        if(!(input.length() >= 8)){
            feedback.append("too short! ");

        }
        else {
            if (!input.matches(".*[0-9].*")) {
                feedback.append("you need to add numbers!");
            }

            if (!input.matches(".*[a-z].*")) {
                feedback.append("where are the mini letters?");
            }

            if (!input.matches(".*[A-Z].*")) {
                feedback.append("no big letters?");
            }

        }

        if(feedback.length() == 0) {
            return "Perfecto!";
        }
        else{
            return feedback.toString();
        }
    }
}
