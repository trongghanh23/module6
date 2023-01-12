public class HinhChuNhat {
    public int chieuDai = 15;
    public int chieuRong = 10;

    public void dienTich(int chieuDai, int chieuRong) {
        int dienTich = chieuDai * chieuRong;
        System.out.printf("dt:" + dienTich);
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        if (chieuDai >0){
            this.chieuDai = chieuDai;
        }
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

}



