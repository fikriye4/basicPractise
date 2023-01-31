package hastaneProject;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static hastaneProject.hastaneIslemler.hastaneMenusu;


public class DoktorIslemler {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> doktorListesiMap = new HashMap<>();

    public static void doktorListesi() {
        doktorListesiMap.put("Allergist", "Nilson, Avery");
        doktorListesiMap.put("Norolog", "John, Abel");
        doktorListesiMap.put("Genel cerrah", "Robert, Erik");
        doktorListesiMap.put("Cocuk doktoru", "Marry, Jacob");
        doktorListesiMap.put("Dahiliye", "Alan, Pedro");
        doktorListesiMap.put("Kardiolog", "Mahesh, Tristen");

    }

    public static void doktorMenu() throws InterruptedException {
        int tercih =0;


        Scanner scan=new Scanner(System.in);
        System.out.println("============= DOKTOR MENUSU =============\n" +

                "\n" +
                        "\t   1- Doktor Ekle\t\n" +
                        "\t   2- Doktor Listesi Yazdir\n" +
                        "\t   3- Unvandan Doktor Bulma\n" +
                        "\t   4- Doktor Silme\n" +
                        "\t   5- ANAMENU\n" +
                        "\t   6-CIKIS");
        tercih = scan.nextInt();

        switch (tercih) {

            case 1: // Doktor Ekle
                doktorEkleMethodu();
                doktorMenu();
                break;
            case 2: //  Doktor Listesi Yazdir
                doktorListesiYazdirma();
                doktorMenu();
                break;
            case 3: // Unvandan Doktor Bulma
                unvandanDoktorBulma();
                doktorMenu();
                break;
            case 4: // Unvan ile doktor  Silme
                doktorSilme();
                doktorMenu();
                break;
            case 5: // ANAMENU
                hastaneMenusu();
                break;
            case 6://CIKIS
                doktorMenusuCikis();
                break;

            default:
                System.out.println("Lutfen gecerli tercih yapiniz");
        }

    }

    private static void doktorMenusuCikis() throws InterruptedException {
        System.out.println("==>AnaMenuye donmek icin 1'e\n" +
                "==>Cikis icin 0'a basin");
        int secim = scan.nextInt();
        if(secim==1){
            hastaneMenusu();
        }else if(secim==0){
            System.out.println("Sistemden cikisiniz gerceklesti");
        }

    }

    private static void doktorSilme() {
        System.out.println("Silmek istediginiz doktorun unvanini girin: ");
        String arananUnvan=scan.nextLine();

        boolean flag=false;
        if(doktorListesiMap.containsKey(arananUnvan)){
            doktorListesiMap.remove(arananUnvan);
            System.out.println("Istenen doktor silindi.");
            System.out.println("====== Guncel doktor listesi======");
            doktorListesiYazdirma();
            flag=true;

        }
        if(flag==false){
            System.out.println("Gecerli unvan girin");
            unvandanDoktorBulma();
        }

    }


    private static void unvandanDoktorBulma() {
        Scanner scan = new Scanner(System.in);
        System.out.println("***** UNVANDAN DOKTOR BULMA ***** ");
        System.out.println("aradiginiz doktorun unvanini girin: ");
        String arananUnvan=scan.nextLine();

        Set<Map.Entry<String,String>> doktorEntrySet=doktorListesiMap.entrySet();
        System.out.println("*****  DOKTOR LISTELEME ***** ");
        System.out.println(	"Unvan	ismi  soyadi\n"+
                "----------------------------------------------------");
        boolean flag = false;
        for (Map.Entry<String,String> each : doktorEntrySet) {
            String eachKey=each.getKey();
            String eachValue=each.getValue();
            String valueArr[]=eachValue.split(", ");
            if(eachKey.contains(arananUnvan)){
                System.out.printf("%1s %-8s %-8s \n" , eachKey, valueArr[0],valueArr[1]);
                flag=true;

                break;
            }
        }
        if(flag==false){
            System.out.println("Gecerli unvan girin");
            unvandanDoktorBulma();

        }
    }

    private static void doktorListesiYazdirma() {
        System.out.println("*****  DOKTOR LISTELEME ***** ");
        System.out.println(	" Unvan	     ismi      soyadi\n"+
                "----------------------------------------------------");
        Set<Map.Entry<String,String>> doktorListSet = doktorListesiMap.entrySet();
        for (Map.Entry<String,String> each : doktorListSet ) {
            String eachKey=each.getKey();
            String eachValue=each.getValue();
            //System.out.println(eachKey+ ", "+ eachValue);
            String valueArr[]=eachValue.split(", ");
            System.out.printf("%-12s %-8s %-8s  \n" , eachKey, valueArr[0],valueArr[1]);

        }
    }

    static void doktorEkleMethodu() {
        System.out.println("============= DOKTOR EKLME =============");
        System.out.println("Doktor ismi girin: ");
        String doktorAdi = scan.nextLine();
        System.out.println(" Doktor Soyisim girin: ");
        String doktorSoyIsim = scan.nextLine();
        System.out.println("Doktor unvani girin: ");
        String unvan = scan.nextLine();
        String eklenecekValue =  doktorAdi + ", " + doktorSoyIsim;
        doktorListesiMap.put(unvan, eklenecekValue);
    }
}
