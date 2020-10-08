package Sample;

import java.util.Random;

/**
 * 角色的職業屬性
 * @author Jack
 * @date 2018-10-01
 * @version 1.0
 */
public class ProfessionAttribute {
    private int strength; // 力量
    private int agility; // 敏捷
    private int physical; // 體力
    private int intelligence; // 智力
    private int wisdom; // 智慧
    private int HP; // 生命值ֵ
    private int MP; // 魔法值ֵ

    /**
     * 獲取角色的力量屬性
     * @return 力量屬性
     */
    public int getStrength() {
        return strength;
    }

    /**
     * 獲取角色的敏捷屬性
     * @return 敏捷屬性
     */
    public int getAgility() {
        return agility;
    }

    /**
     * 獲取角色的體力屬性
     * @return 體力屬性
     */
    public int getPhysical() {
        return physical;
    }

    /**
     * 獲取角色的智力屬性
     * @return 智力屬性
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * 獲取角色的智慧屬性
     * @return 智慧屬性
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * 獲取角色的生命值屬性
     * @return 生命值屬性
     */
    public int getHP() {
        return HP;
    }

    /**
     * 獲取角色的魔法值屬性
     * @return 魔法值屬性
     */
    public int getMP() {
        return MP;
    }

    /**
     * 自動生成角色屬性
     * @param str 角色初始力量屬性
     * @param agi 角色初始敏捷屬性
     * @param phy 角色初始體力屬性
     * @param intell 角色初始智力屬性
     * @param wis 角色初始智慧屬性
     */
    public void AutoGenerateAttribute(int str, int agi, int phy, int intell, int wis) {
        int sum = 0;
        Random random = new Random();
        do {
            strength = random.nextInt(5) % 10 + str;
            agility = random.nextInt(5) % 10 + agi;
            physical = random.nextInt(5) % 10 + phy;
            intelligence = random.nextInt(5) % 10 + intell;
            wisdom = random.nextInt(5) % 10 + wis;
            sum = strength + agility + physical + intelligence + wisdom;
        } while (sum <= 100);
        // 生命值為體力的20倍
        HP = physical * 20;
        // 魔法值為智力與智慧之和的10倍
        MP = (wisdom + intelligence) * 10;
        System.out.println("能力值總和:"+sum);
    }

    /**
     * 初始化角色屬性
     * @param profession 角色職業資訊
     */
    public void initialAttributes(int profession) {
        if (profession == 0) {
            AutoGenerateAttribute(40, 20, 30, 5, 5);
        }
        if (profession == 1) {
            AutoGenerateAttribute(25, 15, 30, 20, 10);
        }
        if (profession == 2) {
            AutoGenerateAttribute(20, 35, 20, 15, 10);
        }
        if (profession == 3) {
            AutoGenerateAttribute(15, 40, 15, 10, 20);
        }
        if (profession == 4) {
            AutoGenerateAttribute(15, 20, 15, 35, 15);
        }
        if (profession == 5) {
            AutoGenerateAttribute(10, 20, 10, 20, 40);
        }
    }

    /**
     * 輸出角色的屬性資訊
     */
    public void outputProfessionAttribute() {
        System.out.println("==============================");
        System.out.println(" 力量\t\t\t" + this.strength);
        System.out.println("==============================");
        System.out.println(" 敏捷\t\t\t" + this.agility);
        System.out.println("==============================");
        System.out.println(" 體力\t\t\t" + this.physical);
        System.out.println("==============================");
        System.out.println(" 智力\t\t\t" + this.intelligence);
        System.out.println("==============================");
        System.out.println(" 智慧\t\t\t" + this.wisdom);
        System.out.println("==============================");
        System.out.println(" 生命值\t\t\t" + this.HP);
        System.out.println("==============================");
        System.out.println(" 魔法值\t\t\t" + this.MP);
        System.out.println("==============================");
    }
}