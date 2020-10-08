import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.Scanner;

/**
 * 嘗試利用序列化和反射機制幹點事情
 */
public class Unit implements Serializable {
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            System.out.println("指向相等");
            return true;

        }
        if(obj==null ||getClass()!=obj.getClass()){
            System.out.println("temp為空或class不符");
            return false;
        }

        Unit temp = (Unit) obj;
        System.out.printf("比較中,this:%s,temp:%s\n",this.name,temp.name);
        System.out.printf("類比較結果%b\n",this.name.equals(temp.name));
        return this.name .equals(temp.name);

    }

    private static final long serialVersionUID = 1L;
    static final int hp_basic = 100;
    static final int mp_basic = 100;
    private int hp_Max;
    private int hp_current;
    private int mp_Max;
    private int mp_Current;
    private int str;
    private int wis;
    private int agi;
    private int lv;
    String name;
    String nation;
    int posX, posY;
    private Unit unit;

    public Unit() {
    }


    public Unit(String name) {
        Random rnd = new Random();
        this.name = name;
        this.lv = 1;
        str = 1 + rnd.nextInt(10);
        wis = 1 + rnd.nextInt(10);
        agi = 1 + rnd.nextInt(10);
        set_hp_Max(hp_basic + str * 10);

        hp_current = hp_Max;
        set_mp_Max(mp_basic + wis * 10);
        mp_Current = mp_Max;
        posX = rnd.nextInt();
        posY = rnd.nextInt();

    }

    @Override
    public String toString() {
        return "Unit{" +
                ", name='" + name + '\'' +
                ", lv=" + lv +
                ", nation='" + nation + '\'' +
                "hp_Max=" + hp_Max +
                ", hp_current=" + hp_current +
                ", mp_Max=" + mp_Max +
                ", mp_Current=" + mp_Current +
                ", str=" + str +
                ", agi=" + agi +
                ", wis=" + wis +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public int get_hp_Max() {
        return hp_Max;
    }

    public void set_hp_Max(int hp_Max) {
        this.hp_Max = hp_Max;
    }

    public int get_mp_Max(int mp_Max) {
        return mp_Max;
    }

    public void set_mp_Max(int mp_Max) {
        this.mp_Max = mp_Max;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void unit_Serialize(String dir, String path) throws Exception {


        File file = new File(dir + path);

        if (file.exists()) {//如果檔案存在,詢問動作
            boolean b = true;
            while (b) {
                System.out.printf("路徑%s下%s檔案已存在,請確認動作\n1.直接覆蓋\n2.檢查資料\n3.其他任意鍵離開", dir, path);
                Scanner in = new Scanner(System.in);
                if (in.hasNextInt()) {

                    switch (in.nextInt()) {
                        case 1:
                            FileOutputStream fos = new FileOutputStream(file);//存檔路徑+角色名稱

                            ObjectOutputStream oos = new ObjectOutputStream(fos);

                            oos.writeObject(this);
                            oos.flush();
                            oos.close();
                            b = false;
                            break;
                        case 2:


                            FileInputStream fis = new FileInputStream(file);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            Unit tempUnit = (Unit) ois.readObject();
                            ois.close();
                            System.out.println(tempUnit);

                            break;


                        default:
                            b = false;
                            break;
                    }

                }

            }


        } else {//如果檔案不存在,很單純的創一個新檔案
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);//存檔路徑+角色名稱
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            System.out.println("創建新檔案" + file.getAbsolutePath());
            System.out.println(this);

        }

    }

    /**
     * @param dir 獲取物件的路徑
     * @param b   如果目前的unit名字與他同步,b=true->覆蓋,flase->nothing
     */
    public Unit(String dir, boolean b) throws Exception {

        Unit tempUnit = null;
        File file = new File(dir);
        if (file.exists()) {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tempUnit = (Unit) ois.readObject();

            ois.close();
            Field[] fields_A = this.getClass().getDeclaredFields();
//            Field[] fields_B = tempUnit.getClass().getDeclaredFields();
//            Constructor[] constructors = this.getClass().getDeclaredConstructors();
            for (int i = 0; i < fields_A.length; i++) {
//                String s = fields_A[i].getClass().toString();
//                if (s .equals("static")  || s.equals("final") ) {
//                    System.out.printf("欄位%s,修飾詞%s",fields_A[i].getName(),s);

//                } else {
                    fields_A[i].setAccessible(true);//開放存取權
//                fields_B[i].setAccessible(true);
//                    fields_A[i].set(tempUnit, fields_B[i]);
                System.out.printf("%s,type:%s,value:%s\n", fields_A[i].getName(), fields_A[i].getAnnotatedType(), fields_A[i].get(this));
                }



        } else {
            System.out.println("指定的路徑不存在");
        }


    }

    public void importFrom(String dir, String path) throws Exception {

        Unit tempUnit = null;
        File file = new File(dir + path);
        if (file.exists()) {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
          /*  Class cls= (Class) ois.readObject();
            for(Field f:cls.getFields()){
                System.out.println(f);
            }*/

            tempUnit = (Unit) ois.readObject();

            ois.close();
            this.name = tempUnit.name;


        } else {
            System.out.println("指定的路徑不存在");
        }

    }

    public void listALlField() {

        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
//            boolean access=fields[i].isAccessible();
//            System.out.println(access);
            fields[i].setAccessible(true);//開放存取權

            try {
//                Class<?>cls=fields[i].getType();
//                Object obj=cls.getNestHost();
//                System.out.println(cls);
                System.out.printf("%s,type:%s,value:%s\n", fields[i].getName(), fields[i].getAnnotatedType(), fields[i].get(this));
//                System.out.println(fields[i].get(this));
            } catch (Exception e) {
                e.printStackTrace();

            }


//            System.out.println(fields[i].getGenericType());

        }

    }
}
