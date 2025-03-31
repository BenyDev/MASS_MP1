import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sia.Container;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerTest {

    Container c1;
    Container c2;
    Container c3;
    Container c4_NoClientID;

    @BeforeEach
    void setUp() {
        c1 = new Container(500,500,500,2000, "1",
                                new HashSet<String>(Arrays.asList("Metal", "plastic"))
                                            ,LocalDateTime.now().minusDays(1));

       c2 = new Container(600,700,800,234000,"2",
                                new HashSet<String>(Arrays.asList( "plastic"))
                                ,LocalDateTime.now().minusDays(1));

        c3 = new Container(54530,5240,2200,201300,"3",
                                new HashSet<String>(Arrays.asList("Metal", "plastic"))
                                ,LocalDateTime.now().minusDays(1));

        c4_NoClientID = new Container(12521,1132,32143,201200,
                                new HashSet<String>(Arrays.asList("MetAl"))
                                ,LocalDateTime.now().minusDays(1));

    }

    @Test
    void testGetContainerArea(){
        System.out.println(c1.getContainerAreaM3());
        System.out.println(c2.getContainerAreaM3());
        System.out.println(c3.getContainerAreaM3());
        System.out.println(c4_NoClientID.getContainerAreaM3());

    }
    @Test
    void testFilterExtendByMaterials(){
        String material = "a";

        List<Container> containers = Container.filterContainersByMaterial(material);
        for(Container c : containers){
            System.out.println(c);
        }
        assertThrows(IllegalArgumentException.class, ()-> {Container.filterContainersByMaterial(null);});
        assertThrows(IllegalArgumentException.class, ()-> {Container.filterContainersByMaterial("");});
        System.out.println(containers);
    }

    @Test
    void setWidthTest(){

        assertThrows(IllegalArgumentException.class, () -> {c1.setWidth(-2);});


    }
    @Test
    void setHeightTest(){
        assertThrows(IllegalArgumentException.class, () -> {c1.setHeight(-1);});

    }
    @Test
    void setLengthTest(){
        assertThrows(IllegalArgumentException.class, () -> {c1.setLength(-2);});
    }
    @Test
    void setNetWeightTest(){
        assertThrows(IllegalArgumentException.class, () -> {c1.setNetWeight(-2d);});
    }

    @Test
    void setIdClientTest(){
        c1.setIdClient(null);
        assertEquals("noValue", c1.getIdClient());
        System.out.println(c1.getIdClient());

        c1.setIdClient("1ID");
        assertEquals("1ID", c1.getIdClient());
        System.out.println(c1.getIdClient());
    }

    @Test
    void setMaterialsTest(){
        System.out.println("Before test: " + c1.getMaterials());
        assertThrows(IllegalArgumentException.class, () -> {c1.setMaterials(null);});
        assertThrows(IllegalArgumentException.class, () -> {c1.setMaterials(new HashSet<>(Arrays.asList("")));});
        System.out.println("After test: " + c1.getMaterials());
    }
    @Test
    void setManufactureDateTest(){
        assertThrows(IllegalArgumentException.class, () -> {c1.setManufactureDate(LocalDateTime.now().plusDays(2) );});
        assertThrows(IllegalArgumentException.class, () -> {c1.setManufactureDate(null );});
    }

}

