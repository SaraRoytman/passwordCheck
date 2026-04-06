import java.sql.*;

public class Username {

    public String valid(String userName1) {
        if (userName1 == null || userName1.isEmpty()) {
            return "cant be empty!";
        }
        StringBuilder feedback = new StringBuilder();

        if (userName1.length() < 8) {
            feedback.append("too short! ");
        }
        if (!userName1.matches(".*\\d.*")) {
            feedback.append("add numbers! ");
        }

        if (!userName1.matches(".*[a-z].*")) {
            feedback.append("small letters! ");
        }

        if (feedback.length() == 0) {
            if (isUsernameTaken(userName1)) {
                return "Username already taken!";
            }
            return "OK";
        }
        return feedback.toString();
    }

    private boolean isUsernameTaken(String user) {

        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }
}
