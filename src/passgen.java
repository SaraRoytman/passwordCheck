public class passgen {
    public String generate(String input) {
        if (input == null || input.isEmpty()) {
            return "Please enter something!";
        }
        StringBuilder feedback = new StringBuilder();
        int score = 0;

        if(input.length() >= 8){
            score++;
        }
        else{
            feedback.append("too short for sure!");
        }

        if(input.matches(".*[a-z].*")){
            score++;
        }
        else{
            feedback.append("no small letters");
        }

        if(score == 2) {
            return "good";
        }
        else{
            return feedback.toString();
        }
    }
}
