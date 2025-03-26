package sia;

import java.time.LocalDateTime;
import java.util.List;

public class Container {

    /***
     * klasowe
     * */
    private static String producent = "PROCONTAINERS";


    /***
     * wymagane
     * */
    private int width;
    private int height;
    private int length;

    private double netWeight;

    /***
     * opcjonalne
     * */
    private String idTransport;


    /***
     * pochodne
     * */
    //total weight

    /***
     * powtarzalny
     * */
    private List<Item> content;

    /***
     * złożony
     * */
    private LocalDateTime manufactureDate;

    public Container(int width, int height, int length, double netWeight, String idTransport, List<Item> content, LocalDateTime manufactureDate) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.netWeight = netWeight;
        this.idTransport = idTransport;
        this.content = content;
        this.manufactureDate = manufactureDate;
    }




    @Override
    public String toString() {
        return "Container{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", netWeight=" + netWeight +
                ", idTransport='" + idTransport + '\'' +
                ", content=" + content +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
