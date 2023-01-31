package hastaneProject;


import java.util.Scanner;

class hastaneIslemler {


    public static void hastaneMenusu() throws InterruptedException {
        Scanner scan=new Scanner(System.in);
        System.out.println("================ ESAT TIP MERKEZINE HOSGELDINIZ======================");
        System.out.println("Yapmak istediginiz islemi secin: " +
                "\n==> Doktor menusu icin 1'e " +
                "\n==>Hasta menusu icin 2'e " +
                "\n==>Cikis icin 0'a basin");
        int secim=scan.nextInt();
        switch (secim) {
            case 1:
                DoktorIslemler.doktorMenu();
                break;
            case 2:
                HastaIslemler.hastaMenusu();
                break;
            case 0:
                cikis();
                break;
        }
    }

    private static void cikis() {
        System.out.println("Sitemden cikis yapildi");
    }

}