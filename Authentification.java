import java.util.Scanner;

public class Authentification {
    private static final String Login="admin";
    public static int authentificate(Scanner in){
        System.out.println("Login:");
        String log = in.nextLine();
        if(log.equals(Login)){
            return 1;
        }
        return 0;
    }
}
