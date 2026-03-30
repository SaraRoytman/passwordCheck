public class Username {
    public String valid(String userName1){
        if(userName1 == null || userName1.isEmpty()){
            return "cant be empty!";
        }
        StringBuilder feedback = new StringBuilder();
        if(userName1.length() < 8){
            feedback.append("too short!");

        }
        else{
            feedback.append("OK");

        }


        return feedback.toString();
    }

}
