package untils.exception;

public class Validate {
    public static boolean checkStringIn(String stringCheck,String regex){
        return stringCheck.matches(regex);
    }
}
