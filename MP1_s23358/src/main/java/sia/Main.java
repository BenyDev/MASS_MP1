package sia;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {

        String fileName = "containers.ser";
        File file = new File(fileName);

        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File "+ fileName + " created");

            } catch (IOException e) {
                System.err.println("Error creating file " + e.getMessage());
            }
        }
        if(file.length() > 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
                Container.readExtent(ois);
                ois.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        Container c1 = new Container(9123,94123,71232,11230,"1",
                new HashSet<String>(Arrays.asList("steel", "plastic")),
                LocalDateTime.now().minusYears(1));

        Container c2 = new Container(1921,12349,5437,11230,"2",
                new HashSet<String>(Arrays.asList("aluminum", "plastic")),
                LocalDateTime.now().minusYears(2));

        Container c3 = new Container(5329,12359,1237,1210, "3",
                new HashSet<String>(Arrays.asList("fiberglass", "plastic")),
                LocalDateTime.now().minusYears(3));

        Container c4 = new Container(4129,5219,5327,1031,"4",
                new HashSet<String>(Arrays.asList("wood", "steel", "plastic")),
                LocalDateTime.now().minusYears(4));

        Container c5 = new Container(9231,942,712,1120,"5",
                new HashSet<String>(Arrays.asList("steel", "plastic")),
                LocalDateTime.now().minusYears(5));

        Container c6NoID = new Container(4219,1239,577,10,
                new HashSet<String>(Arrays.asList("wood", "steel")),
                LocalDateTime.now().minusYears(6));

        Container c7NoID = new Container(1259,5329,4517,10,
                new HashSet<String>(Arrays.asList("fiberglass", "plastic")),
                LocalDateTime.now().minusYears(7));




        System.out.println("\n============CONTAINERS=================\n");

        List<Container> extent = Container.getExtent();
        for (Container c : extent ){
            System.out.println(c.getContainerAreaM3() + "m^3");
            System.out.println(c);
        }

        String filter = "Steel";
        System.out.println("\n============CONTAINERS: Looking for:  " + filter + "=================\n");
        List<Container> filteredContainers = Container.filterContainerByMaterial(filter);
        for (Container c : filteredContainers) {
            System.out.println(c);
        }

        System.out.println("\n=======ADD NEW CONTAINER WITH NOT CLIENT ID=======\n");
        Container c8NoID = new Container(1259,5329,4517,10,
                new HashSet<String>(Arrays.asList("steel", "plastic")),
                LocalDateTime.now().minusYears(10));
        System.out.println("NEW CONTAINER: " + c8NoID);
        for(Container c : Container.getExtent()){
            System.out.println(c);
        }
        System.out.println("\n=======EDIT LAST ADDED CONTAINER=======\n");
        System.out.println("\nBEFORE EDIT: " + c8NoID);

        c8NoID.setMaterials(new HashSet<>(Arrays.asList("wood", "fiberglass", "plastic")));
        c8NoID.setIdClient("13");
        c8NoID.setLength(6000);
        c8NoID.setHeight(7000);
        c8NoID.setLength(3000);
        c8NoID.setManufactureDate( LocalDateTime.now().minusYears(20));
        System.out.println("\nAFTER: " + c8NoID);


        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            Container.writeExtent(out);
            out.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}