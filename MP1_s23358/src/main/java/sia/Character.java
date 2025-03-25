package sia;

import java.util.List;
import java.util.Map;

public class Character {

    //wymagane
    private String name;
    private String race;
    private int strength;
    private int dexterity;
    private int speed;
    private int intelligence;
    private int life;
    private int mana;

    //optional:
    //avatar -  -null
    private byte[] avatar;

    //pochodne:
    //move -  get(speed + 3)// move = basicMove + speed // błąd - trudniejsze
    //bagCapacity
    //dmg

    //powtarzalny
    private List<Weapon> bag;

    //złożony - rasa nowa klasa

    //klasowy
    // basicMove = 3

}
