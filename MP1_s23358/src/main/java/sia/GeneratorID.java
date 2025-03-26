package sia;

import java.util.UUID;

public class GeneratorID {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public GeneratorID() {
    }
}
