package Sample;

import java.util.Scanner;

/**
 * 角色的種族和職業
 * @author Jack
 * @date 2018-10-01
 * @version 1.0
 */
public class RaceAndProfession {
    private int race; // 種族
    private int profession; // 職業
    private String[] races = { "人類", "精靈", "獸人", "矮人", "元素" };
    private String[] professions = { "狂戰士", "聖騎士", "刺客", "獵手", "祭司", "巫師" };

    /**
     * 獲取角色職業資訊
     * @return 角色職業資訊
     */
    public int getProfession() {
        return this.profession;
    }

    /**
     * 獲取角色種族資訊
     * @return 角色種族資訊
     */
    public int getRace() {
        return race;
    }

    /**
     * 設定角色種族
     * @param race 角色種族
     */
    public void setRace(int race) {
        this.race = race;
    }

    /**
     * 選擇角色種族
     * @return 角色種族資訊
     */
    public int selectRace() {
        while (true) {
            System.out.println("請選擇您遊戲角色的種族(0人類，1精靈，2獸人，3矮人，4元素):");
            Scanner sc = new Scanner(System.in);
            this.race = sc.nextInt();
            // 判斷種族輸入是否正確
            if (race >= 0 && race <= 4) {
                // 輸入正確跳出迴圈
                break;
            } else {
                System.out.println("請輸入0到4之間的數字來選擇種族!");
            }
        }
        return race;
    }

    /**
     * 選擇角色職業
     * @param race 角色種族資訊
     * @return 角色職業資訊
     */
    public int selectProfession(int race) {
        switch (race) {
            case 0:
                while (true) {
                    System.out.println("請選擇您的職業(0狂戰士，1聖騎士，2刺客，3獵手，4祭司，5巫師):");
                    Scanner sc = new Scanner(System.in);
                    this.profession = sc.nextInt();
                    // 判斷職業輸入是否正確
                    if (profession >= 0 && profession <= 5) {
                        // 輸入正確跳出迴圈
                        break;
                    } else {
                        System.out.println("請輸入0到5之間的數字來選擇職業！");
                    }
                }
                break;
            case 1:
                while (true) {
                    System.out.println("請選擇您的職業(2刺客，3獵手，4祭司，5巫師):");
                    Scanner sc = new Scanner(System.in);
                    this.profession = sc.nextInt();
                    // 判斷職業輸入是否正確
                    if (profession >= 2 && profession <= 5) {
                        // 輸入正確跳出迴圈
                        break;
                    } else {
                        System.out.println("請輸入2到5之間的數字選擇職業!");
                    }
                }
                break;
            case 2:
                while (true) {
                    System.out.println("請選擇您的職業(0狂戰士，3獵手，4祭司):");
                    Scanner sc = new Scanner(System.in);
                    this.profession = sc.nextInt();
                    // 判斷職業輸入是否正確
                    if (profession == 0 || profession == 3 || profession == 4) {
                        // 輸入正確跳出迴圈
                        break;
                    } else {
                        System.out.println("請輸入數字0、3或4來選擇職業!");
                    }
                }
                break;
            case 3:
                while (true) {
                    System.out.println("請選擇您的職業(0狂戰士，1聖騎士，4祭司):");
                    Scanner sc = new Scanner(System.in);
                    this.profession = sc.nextInt();
                    // 判斷職業輸入是否正確
                    if (profession == 0 || profession == 1 || profession == 4) {
                        // 輸入正確跳出迴圈
                        break;
                    } else {
                        System.out.println("請輸入數字0、1或4來選擇職業!");
                    }
                }
                break;
            case 4:
                while (true) {
                    System.out.println("請選擇您的職業(4祭司，5巫師):");
                    Scanner sc = new Scanner(System.in);
                    this.profession = sc.nextInt();
                    // 判斷種族輸入是否正確
                    if (profession == 4 || profession == 5) {
                        // 輸入正確跳出迴圈
                        break;
                    } else {
                        System.out.println("請輸入數字4或5來選擇職業!");
                    }
                }
                break;
            default:
                break;
        }
        return profession;
    }

    /**
     * 輸出角色的種族和職業資訊
     */
    public void outputRaceAndProfession() {
        System.out.println("==============================");
        System.out.println(" 種族\t\t\t" + races[this.race]);
        System.out.println("==============================");
        System.out.println(" 職業\t\t\t" + professions[this.profession]);
    }
}