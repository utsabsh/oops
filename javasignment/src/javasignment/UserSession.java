package javasignment;

public class UserSession {
    private static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String userRole) {
        role = userRole;
    }

    public static boolean isAdmin() {
        return "Admin".equals(role);
       
    }
    
    public static boolean isTeacher() {
    	 return "Teacher".equals(role);
    	
    }
}