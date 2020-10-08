public class Role extends Unit{

    private String country;
    private String rank;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * 收到一個指令,理論上傳進來的參數可能也是一個類,或甚至多個類
     *1.需要有目標(單位、點、區域,或無目標等等...)
     * 2.實際執行動作
     */
    public void order(){//收到一個指令


    };
}
