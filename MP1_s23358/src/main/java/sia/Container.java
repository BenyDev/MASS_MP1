package sia;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Container implements Serializable {

    private static List<Container> extent = new ArrayList<>();
    private static String producer = "PROCONTAINERS";
    private static final int MIN_SIZE_MATERIALS = 1;
    private int width;
    private int height;
    private int length;
    private double netWeight;
    private String idClient;
    private LocalDateTime manufactureDate;
    private HashSet<String> materials;



    public Container(int width, int height, int length, double netWeight, String idClient, HashSet<String> materials, LocalDateTime manufactureDate) {
        this.setWidth(width);
        this.setHeight(height);
        this.setLength(length);
        this.setNetWeight(netWeight);
        this.setIdClient(idClient);
        this.setMaterials(materials);
        this.setManufactureDate(manufactureDate);

        addToExtent(this);
    }

    public Container(int width, int height, int length, double netWeight, HashSet<String> materials, LocalDateTime manufactureDate) {
        this.setWidth(width);
        this.setHeight(height);
        this.setLength(length);
        this.setNetWeight(netWeight);
        this.setMaterials(materials);
        this.setManufactureDate(manufactureDate);

        addToExtent(this);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Container>) stream.readObject();
    }
    public static void  writeExtent(ObjectOutputStream stream) throws IOException
    {
        stream.writeObject(extent);
    }

    public static List<Container> getExtent() {
        return new ArrayList<>(extent);
    }


    private static void addToExtent(Container container){
        if(container == null){
            throw new IllegalArgumentException("container is null");
        }

        extent.add(container);
    }
    private static void removeFromExtent(Container container){
        if(container == null){
            throw new IllegalArgumentException("container is null");
        }

        if(!extent.isEmpty() ) {
            extent.remove(container);
        }else
        {
            System.out.println("Extent is empty");
        }
    }

    public static List<Container> filterContainersByMaterial(String material) {

        if(material == null){
            throw new IllegalArgumentException("material is null");
        }
        if(material.isEmpty()){
            throw new IllegalArgumentException("material is empty");
        }

        String lookingForMaterial = material.toLowerCase();

        List<Container> containersToFilter = Container.getExtent();
        List<Container> containersFiltered = new ArrayList<>();
        containersToFilter.forEach( container -> {

            HashSet<String> materials = container.getMaterials();

            for(String m : materials){
                if(lookingForMaterial.equals(m)){
                    containersFiltered.add(container);
                    return;
                }
            }
        });

        return containersFiltered;
    }

    public BigDecimal getContainerAreaM3(){
        long fromMMtoM = 1000;
        BigDecimal widthArea = BigDecimal.valueOf(this.width).divide(BigDecimal.valueOf(fromMMtoM));
        BigDecimal heightArea = BigDecimal.valueOf(this.height).divide(BigDecimal.valueOf(fromMMtoM));
        BigDecimal lengthArea = BigDecimal.valueOf(this.length).divide(BigDecimal.valueOf(fromMMtoM));

        return widthArea.multiply(heightArea).multiply(lengthArea);
    }



    public static String getProducer() {
        return producer;
    }

    public static void setProducer(String producer) {
        Container.producer = producer;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {

        int minValue = 500;
        if(width < minValue ) {
            throw new IllegalArgumentException("Width must be greater than or equal to " + minValue);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int minValue = 500;
        if(height < minValue ) {
            throw new IllegalArgumentException("Height must be greater than or equal to " + minValue);
        }

        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        int minValue = 500;
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
        if(netWeight <= minValue ) {
            throw new IllegalArgumentException("NetWeight must be greater than or equal to " + minValue);
        }

        this.netWeight = netWeight;
    }

    public String getIdClient() {

        if(idClient == null) {
            String nullVal = "noValue";
            return nullVal;
        }
        return idClient;
    }

    public void setIdClient(String idClient) {

        if(idClient == null) {
            this.idClient = null;
            return;
        }

        if( idClient.isEmpty()) {
            throw new IllegalArgumentException("Id Client can not be empty.");
        }

        this.idClient = idClient;
    }

    public void setMaterials(HashSet<String> materials) {



        if(materials == null){
            throw new IllegalArgumentException("Materials can not be null.");
        }
        if(materials.size() < MIN_SIZE_MATERIALS) {
            throw new IllegalArgumentException("Materials size must be greater than or equal to " + MIN_SIZE_MATERIALS);
        }

        for(String material : materials) {
            if(material.isEmpty()) {
                throw new IllegalArgumentException("Material can not be empty.");
            }
        }




        this.materials = materials.stream().map(String::toLowerCase).collect(Collectors.toCollection(HashSet::new));

    }

    public HashSet<String> getMaterials() {
        return new HashSet<>(materials);
    }

    public void addMaterial(String material) {

        if(material == null) {
            throw new IllegalArgumentException("Material can not be null.");
        }

        if(material.isEmpty()) {
            throw new IllegalArgumentException("Material can not be empty.");
        }
        if(materials.contains(material)) {
            throw new IllegalArgumentException("Material already exists.");
        }

        materials.add(material.toLowerCase());
    }
    public void removeMaterial(String material) {

        if(material == null) {
            throw new IllegalArgumentException("Material can not be null.");
        }

        if(material.isEmpty()) {
            throw new IllegalArgumentException("Material can not be empty.");
        }
        if(!materials.contains(material)) {
            throw new IllegalArgumentException("Material does not exist.");
        }

        if((materials.size() -1) < MIN_SIZE_MATERIALS ) {
            throw new IllegalArgumentException("Can not remove material. Container should have at least one material.");
        }

        materials.remove(material);

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return getWidth() == container.getWidth() && getHeight() == container.getHeight() && getLength() == container.getLength() && Double.compare(getNetWeight(), container.getNetWeight()) == 0 && Objects.equals(getIdClient(), container.getIdClient()) && Objects.equals(getMaterials(), container.getMaterials()) && Objects.equals(getManufactureDate(), container.getManufactureDate());
    }



    @Override
    public String toString() {
        return "Container{" +
                "width=" + getWidth() + "mm" +
                ", height=" + getLength() + "mm" +
                ", length=" + getLength() + "mm" +
                ", netWeight=" + getNetWeight() + "kg" +
                ", idClient='" + getIdClient() + '\'' +
                ", materials=" + getMaterials() +
                ", manufactureDate=" + getManufactureDate() +
                ", hashCode=" + this.hashCode() +
                '}';
    }
}
