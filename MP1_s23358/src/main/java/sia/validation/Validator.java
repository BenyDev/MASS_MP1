package sia.validation;

public class Validator {

    public static Boolean isIntValueValid(int input, int min, String message)  {

        try{
            if(input < min){
                throw new ToLowValueException(message + min);
            }

        }
        catch (ToLowValueException e){
            System.out.println(e.getMessage());
            return false;
        }


        return true;
    }
}
