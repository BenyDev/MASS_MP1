import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sia.Container;
import sia.Item;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerTest {

    Container c1;

    @BeforeEach
    void setUp() { c1 = new Container(2,20,30,2000,"123",
                            Arrays.asList(
                                            new Item("Lodowka",20d),
                                             new Item("Pralka",35d))
                                            ,LocalDateTime.now());}


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
        assertEquals("Empty", c1.getIdClient());
        System.out.println(c1.getIdClient());

        c1.setIdClient("1ID");
        assertEquals("1ID", c1.getIdClient());
        System.out.println(c1.getIdClient());
    }

    @Test
    void setContentTest(){
        System.out.println("Before test: " + c1.getContent());
        assertThrows(IllegalArgumentException.class, () -> {c1.setContent(null);});
        assertThrows(IllegalArgumentException.class, () -> {c1.setContent(Arrays.asList(new Item("Lodówka",23d)));});
        System.out.println("After test: " +c1.getContent());
    }
    @Test
    void setManufacturerTest(){
        assertThrows(IllegalArgumentException.class, () -> {c1.setManufactureDate(LocalDateTime.now().plusNanos(20) );});
        assertThrows(IllegalArgumentException.class, () -> {c1.setManufactureDate(null );});
    }

}

