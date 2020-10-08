import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Start {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Unit unit = null;
        String dir = "D:/專案資料夾/RPGTest/";


        while (true) {
            System.out.println("輸入指令");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int command = input.nextInt();
                switch (command) {
                    case 0:
                        System.out.println("新建角色,請輸入名稱");
                        String name = input.next();
                        unit = new Unit(name);
                        System.out.println(unit);
                        System.out.printf("unit存在?%b\n", unit != null);

                        break;
                    case 1:
                        System.out.println("輸出序列化資料");
                        if (unit != null) {
                            try {
                              /*  FileOutputStream fos=new FileOutputStream(dir+unit.name);
                                ObjectOutputStream oos=new ObjectOutputStream(fos);
                                oos.writeObject(unit);
                                oos.flush();
                                oos.close();
                                System.out.println("輸出結束");*/
                                unit.unit_Serialize(dir, unit.name);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("反序列化");
                        System.out.println("輸入名稱");
                        String path = input.next();
//                        unit = new Unit(dir, path);
//                        System.out.println(unit);
                       /* try {
                            FileInputStream fis = new FileInputStream(dir + path);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            unit = (Unit) ois.readObject();
                            ois.close();
//                        unit=tempUnit;
                            System.out.println(unit);
                        } catch (FileNotFoundException e) {
                            System.out.println("找不到指定檔案");


                        }*/

                        try {
                            FileInputStream fis = new FileInputStream(dir + path);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            Unit temp = (Unit) ois.readObject();
                            ois.close();
//                            Unit temp=new Unit(dir+path,true);
                            System.out.printf("unit是否存在?%b\n", unit != null);


                            if (unit != null) {
                                boolean b = unit.equals(temp);

                                System.out.println("比較結果" + b);
                                if (b) {
                                    System.out.printf("目前單位的名字%s與匯入單位的名子%s一樣,選1覆蓋", unit.name, temp.name);
                                    if (input.nextInt() == 1) {
                                        unit = temp;
                                        System.out.println("以匯入檔案取代");
                                    } else {
                                        System.out.println("取消匯入");
                                    }
                                }


                            } else {
                                System.out.println("unit不存在,直接覆蓋");
                                unit=temp;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:

                        if (unit != null) {
                            System.out.println("列出所有屬性");
                            unit.listALlField();

                        } else {
                            System.out.println("unit為null");
                        }
                        break;
                    case 4:
                        System.out.println("檢查目前單位");
                        System.out.println(unit);
                        break;
                    default:
                        System.out.println("不存在的指令");
                }

            } else {
                System.out.println("請輸入數字");
            }

        }


    }
}
