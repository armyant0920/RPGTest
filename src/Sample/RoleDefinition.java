package Sample;

import java.util.Scanner;

/**
 * 角色定義
 * @author Jack
 * @date 2018-10-01
 * @version 1.0
 */
public class RoleDefinition {
    private String name; // 角色姓名
    private int gender; // 角色性別

    /**
     * 獲取角色姓名
     * @return 角色姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 設定角色姓名
     * @param name 角色姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 獲取角色性別
     * @return 角色性別
     */
    public int getGender() {
        return gender;
    }

    /**
     * 設定角色性別
     * @param gender 角色性別
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 設定角色的姓名和性別
     * @return 角色性別
     */
    public int inputNameAndGender() {
        System.out.println("請輸入您遊戲角色的姓名:");
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
        while (true) {
            System.out.println("請選擇您遊戲角色的性別(0男性，1女性):");
            this.gender = sc.nextInt();
            // 判斷性別輸入是否正確
            if (gender == 0 || gender == 1) {
                // 輸入正確
                break;
            } else {
                System.out.println("請輸入0或1來選擇性別!");
            }
        }
        return gender;
    }

    /**
     * 輸出角色的姓名和性別資訊
     */
    public void outputNameAndGender() {
        System.out.println("==============================");
        System.out.println(" 姓名\t\t\t" + this.name);
        System.out.println("==============================");
        if (this.gender == 0) {
            System.out.println(" 性別\t\t\t" + "男性");
        } else {
            System.out.println(" 性別\t\t\t" + "女性");
        }
    }

}