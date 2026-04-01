public class Username {
    public String valid(String userName1){
        if(userName1 == null || userName1.isEmpty()){
            return "cant be empty!";
        }
        StringBuilder feedback = new StringBuilder();
        feedback.setLength(0);
        if(userName1.length() < 8){
            feedback.append("too short!");

        }
        if(!userName1.matches(".*\\d.*")){
            feedback.append("add numbers! ");
        }
        if(!userName1.matches(".*[a-z]*.")){
            feedback.append("small letters! ");
        }

        if(feedback.length() == 0){
            feedback.append("OK");

        }


        return feedback.toString();
    }

}
