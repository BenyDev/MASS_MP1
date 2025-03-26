import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sia.Container;
import sia.Item;
import sia.validation.ToLowValueException;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    void setIdTransportTest(){
        c1.setIdTransport(null);
        assertEquals("Empty", c1.getIdTransport());
        System.out.println(c1.getIdTransport());

        c1.setIdTransport("1ID");
        assertEquals("1ID", c1.getIdTransport());
        System.out.println(c1.getIdTransport());
    }

    @Test
    void setContentTest(){
        System.out.println("Before test: " + c1.getContent());
        assertThrows(IllegalArgumentException.class, () -> {c1.setContent(null);});
        assertThrows(IllegalArgumentException.class, () -> {c1.setContent(Arrays.asList(new Item("Lodówka",23d)));});
        System.out.println("After test: " +c1.getContent());
    }


}

