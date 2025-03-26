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
    private String idClient;


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

    public Container(int width, int height, int length, double netWeight, String idClient, List<Item> content, LocalDateTime manufactureDate) {
        this.setWidth(width);
        this.height = height;
        this.length = length;
        this.netWeight = netWeight;
        this.idClient = idClient;
        this.content = content;
        this.manufactureDate = manufactureDate;
    }

    public static String getProducent() {
        return producent;
    }

    public static void setProducent(String producent) {
        Container.producent = producent;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {

//        if(!Validator.isIntValueValid(width,0, "Width should be greater than")){
//            return;
//        }

        int minValue = 0;
        if(width < minValue ) {
            throw new IllegalArgumentException("Width must be greater than or equal to " + minValue);
        }
    this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int minValue = 0;
        if(height < minValue ) {
            throw new IllegalArgumentException("Height must be greater than or equal to " + minValue);
        }

        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        int minValue = 0;
        if(length < minValue ) {
            throw new IllegalArgumentException("Length must be greater than or equal to " + minValue);
        }

        this.length = length;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        double minValue = 0;
        if(netWeight < minValue ) {
            throw new IllegalArgumentException("NetWeight must be greater than or equal to " + minValue);
        }

        this.netWeight = netWeight;
    }

    public String getIdClient() {

        if(idClient == null) {
            String nullVal = "Empty";
            return nullVal;
        }
        return idClient;
    }

    public void setIdClient(String idClient) {

        if(idClient == null || !idClient.isEmpty()) {
            this.idClient = null;
        }

        this.idClient = idClient;
    }

    public List<Item> getContent() {
        return content;
    }

    public void setContent(List<Item> content) {

        int minSizeContent = 1;

        if(content == null ) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        if(content.isEmpty() || content.size() == minSizeContent){
            throw new IllegalArgumentException("Content cannot be empty, and minSize must be greater than: " + minSizeContent );
        }

        this.content = content;
    }

    public LocalDateTime getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDateTime manufactureDate) {

        if(manufactureDate == null  ) {
            throw new IllegalArgumentException("Manufacture date cannot be null");
        }
        if(!manufactureDate.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Manufacture date must be before now");
        }
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return "Container{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", netWeight=" + netWeight +
                ", idTransport='" + idClient + '\'' +
                ", content=" + content +
                ", manufactureDate=" + manufactureDate +
                '}';
    }
}
