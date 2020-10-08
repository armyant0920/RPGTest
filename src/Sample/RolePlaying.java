package Sample;

import java.io.*;
import java.util.Scanner;

/**
 * 角色生成器測試類
 * @author Jack
 * @date 2018-10-01
 * @version 1.0
 */
public class RolePlaying {

    static String dir="src/sample/roles_information.txt";
    static void load() throws IOException {

        String NAME,COUNTRY;
        int LV,HP,MP;

        String str="";
        FileReader fr = new FileReader(dir);//可以在此按絕對目錄設定FileReader要讀取的檔案，須使用"\\"取代"\"
        BufferedReader br = new BufferedReader(fr);
        while (br.ready())//當buffer就緒就印出buffer中的資料
        {   String s=br.readLine();
            System.out.println(s);
            if(s.startsWith("姓名")){

            }
//            str=str+br.readLine();
//            System.out.println(str);
        }

//        fr.close();
//        String[]S=str.split(",");
//        //for(String s:S) {System.out.print(s+",");}
//        LV=Integer.valueOf(S[0]);
//        NAME=S[1];
//        COUNTRY=S[2];
//        HP=Integer.valueOf(S[3]);
//        MP=Integer.valueOf(S[4]);
//
//        System.out.println("LV:"+LV);
//        System.out.println("COUNTRY:"+COUNTRY);
//        System.out.println("NAME:"+NAME);
//        System.out.println("HP:"+HP);
//        System.out.println("MP:"+MP);
    }

    public static void main(String[] args) throws IOException {
        while (true) {

            boolean flag = true;
            Scanner sc = new Scanner(System.in);
            System.out.println("輸入1.創建新腳色\n輸入2.讀取角色資料");
            if(sc.hasNextInt()){
                int code=sc.nextInt();
                switch (code){

                    case 1:
                        // 建立角色物件
                        RoleDefinition role = new RoleDefinition();
                        RaceAndProfession rap = new RaceAndProfession();
                        ProfessionAttribute pa = new ProfessionAttribute();
                        do {
                            role.inputNameAndGender();
                            int race = rap.selectRace();
                            rap.selectProfession(race);
                            // 輸出角色基本資訊
                            role.outputNameAndGender();
                            rap.outputRaceAndProfession();
                            pa.initialAttributes(rap.getProfession());
                            pa.outputProfessionAttribute();
                            // 判斷使用者是否滿意
                            System.out.println("是否滿意角色屬性?(Y/N)若不滿意,則重新建立!");
                            String str = sc.next();
                            if ("Y".equals(str) || "y".equals(str)) {
                                break;
                            }
                        } while (flag);
                        // 將角色資訊儲存到檔案中
                        saveRoleInformation(role, rap, pa);
                        System.out.println("角色資訊已成功儲存!");
                        break;
                    case 2:
                        load();
                        break;

                }
            }


        }
    }

    /**
     * 將角色資訊儲存到檔案中
     * @param role 角色類物件
     * @param rap 種族職業類物件
     * @param pa 職業屬性類物件
     */
    public static void saveRoleInformation(RoleDefinition role, RaceAndProfession rap, ProfessionAttribute pa) {
        try {
            // 建立字元輸出流物件
            FileWriter desFile = new FileWriter("src/sample/roles_information.txt", true);
            // 字元緩衝輸出流
            BufferedWriter out = new BufferedWriter(desFile);
            out.write(" 姓名\t\t\t" + role.getName());
            // 輸出換行
            out.newLine();
            if (role.getGender() == 0) {
                out.write(" 性別\t\t\t" + "男性");
            } else {
                out.write(" 性別\t\t\t" + "女性");
            }
            out.newLine();
            switch (rap.getRace()) {
                case 0:
                    out.write(" 種族\t\t\t" + "人類");
                    break;
                case 1:
                    out.write(" 種族\t\t\t" + "精靈");
                    break;
                case 2:
                    out.write(" 種族\t\t\t" + "獸人");
                    break;
                case 3:
                    out.write(" 種族\t\t\t" + "矮人");
                    break;
                case 4:
                    out.write(" 種族\t\t\t" + "元素");
                    break;
                default:
                    break;
            }
            out.newLine();
            switch (rap.getProfession()) {
                case 0:
                    out.write(" 職業\t\t\t" + "狂戰士");
                    break;
                case 1:
                    out.write(" 職業\t\t\t" + "聖騎士");
                    break;
                case 2:
                    out.write(" 職業\t\t\t" + "刺客");
                    break;
                case 3:
                    out.write(" 職業\t\t\t" + "獵手");
                    break;
                case 4:
                    out.write(" 職業\t\t\t" + "祭司");
                    break;
                case 5:
                    out.write(" 職業\t\t\t" + "巫師");
                    break;
                default:
                    break;
            }
            out.newLine();
            out.write(" 力量\t\t\t" + pa.getStrength());
            out.newLine();
            out.write(" 敏捷\t\t\t" + pa.getAgility());
            out.newLine();
            out.write(" 體力\t\t\t" + pa.getPhysical());
            out.newLine();
            out.write(" 智力\t\t\t" + pa.getIntelligence());
            out.newLine();
            out.write(" 智慧\t\t\t" + pa.getWisdom());
            out.newLine();
            out.write(" 生命值\t\t\t" + pa.getHP());
            out.newLine();
            out.write(" 魔法值\t\t\t" + pa.getMP());
            out.newLine();
            // 關閉資源
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}