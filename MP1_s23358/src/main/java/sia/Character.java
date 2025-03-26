package sia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Character {

    private static List<Character> extent = new ArrayList<>();

    private static void addCharacterToExtent(Character character) {
        extent.add(character);
    }
    private static void removeCharacterFromExtent(Character character) {
        extent.remove(character);
    }

    /***
     * klasowe
     * */
    private static int basicMove = 3;
    private static int baseBagCapacity = 3;
    private static Region currentRegion = new Region("Labirynt Próby");

    /***
     * wymagane
     * */
    private String name;
    private String race;
    private int strength;
    private int dexterity;
    private int speed;
    private int intelligence;
    private int life;
    private int mana;

    /***
     * opcjonalne
     * */
    private byte[] avatar;


    /***
     * pochodne
     * */
    private int getMove(){
        return basicMove + speed;
    }
    private int getBagCapacity(){
        return  baseBagCapacity + strength;
    }

    /***
     * powtarzalny
     * */
    private List<Weapon> bag;

    /***
     * złożony
     * */
    private Experience experience;


    public Character(
            String name, String race, int strength, int dexterity, int speed, int intelligence,
            int life, int mana, byte[] avatar, List<Weapon> bag, Experience experience) {
        this.setName(name);
        this.setRace(race);
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setSpeed(speed);
        this.setIntelligence(intelligence);
        this.setLife(life);
        this.setMana(mana);
        this.setAvatar(avatar);
        this.setBag(bag);
        this.setExperience(experience);
    }

    /***
     *  Get & Set
     * **/
    public static List<Character> getExtent() {
        return extent;
    }

    public static void setExtent(List<Character> extent) {
        Character.extent = extent;
    }

    public static int getBasicMove() {
        return basicMove;
    }

    public static void setBasicMove(int basicMove) {
        Character.basicMove = basicMove;
    }

    public static int getBaseBagCapacity() {
        return baseBagCapacity;
    }

    public static void setBaseBagCapacity(int baseBagCapacity) {
        Character.baseBagCapacity = baseBagCapacity;
    }

    public static Region getCurrentRegion() {
        return currentRegion;
    }

    public static void setCurrentRegion(Region currentRegion) {
        Character.currentRegion = currentRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public List<Weapon> getBag() {
        return bag;
    }

    public void setBag(List<Weapon> bag) {
        this.bag = bag;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}
