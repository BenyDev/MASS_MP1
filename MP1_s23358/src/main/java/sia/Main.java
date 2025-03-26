package sia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(GeneratorID.generateId());

        Container c1 = new Container(10,20,30,2000,"123",
                                        Arrays.asList(
                                                new Item("Lodowka",20d),
                                                new Item("Pralka",35d))
                                        ,LocalDateTime.now());
        System.out.println(c1);

    }
}