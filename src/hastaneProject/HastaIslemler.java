package hastaneProject;


    import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

        import static hastaneProject.hastaneIslemler.hastaneMenusu;


    public class HastaIslemler {
        static Scanner scan = new Scanner(System.in);
        static Map<Integer, String> hastaListesiMap = new HashMap<>();
        static int hastaIDNo = 777;


        public static void hastaListesi() {
            hastaListesiMap.put(111, "Warren, Traven, Allerji");
            hastaListesiMap.put(222, "Petanow, William, Bas agrisi");
            hastaListesiMap.put(333, "Sophia, George, Diabet");
            hastaListesiMap.put(444, "Emma, Tristan, Soguk alginligi");
            hastaListesiMap.put(555, "Darian, Luis, Migren");
            hastaListesiMap.put(666, "Peter, Cole, Kalp hastaliklari");

        }

        public static void hastaMenusu() throws InterruptedException {

            Scanner scan = new Scanner(System.in);
            System.out.println("============= HASTA MENUSU =============\n" +

                    "\n" +
                            "\t   1- Hasta Ekle\t\n" +
                            "\t   2- Hasta Listesi Yazdir\n" +
                            "\t   3- Hasta Durumu Listele\n" +
                            "\t   4- Hasta Silme\n" +
                            "\t   5- Hasta Bulma\n" +
                            "\t   6- ANAMENU\n" +
                            "\t   7-CIKIS");
            int tercih = scan.nextInt();

            switch (tercih) {
                case 1: //Hasta Ekle
                    hastaEkle();
                    hastaMenusu();
                    break;
                case 2: //Hasta Listesi Yazdir
                    hastaListesiYazdir();
                    hastaMenusu();
                    break;
                case 3: //Hasta Durumu Listele
                    hastaDurumu();
                    hastaMenusu();
                    break;
                case 4: //
                    hastaSilme();
                    hastaMenusu();
                    break;

                case 5: // ANAMENU
                    hastaBul();
                    hastaMenusu();
                    break;
                case 6://CIKIS
                    hastaneMenusu();
                    break;
                case 7://CIKIS
                    hastaMenusuCikis();
                    break;

                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");
            }

        }

        private static void hastaBul() {
            Scanner scan = new Scanner(System.in);
            System.out.println("***** HASTA BULMA ***** ");
            System.out.println("aradiginiz id noyu girin: ");
            int arananId=scan.nextInt();
            boolean flag = false;

            Set<Map.Entry<Integer, String>> hastaListSet = hastaListesiMap.entrySet();
            for (Map.Entry<Integer, String> each : hastaListSet) {
                Integer eachKey = each.getKey();
                String eachValue = each.getValue();
                String valueArr[] = eachValue.split(", ");

                if(eachKey==arananId){

                    System.out.printf("%-4d %-8s %-8s %-8s  \n", eachKey, valueArr[0], valueArr[1], valueArr[2]);
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.println("Gecerli id no girin");
                hastaBul();

            }




        }




        private static void hastaSilme() {
            System.out.println("Silmek istediginiz hastanin id numarasini girin: ");
            int arananId=scan.nextInt();

            boolean flag=false;
            if(hastaListesiMap.containsKey(arananId)){
                hastaListesiMap.remove(arananId);
                System.out.println("Istenen hasta silindi.");

                hastaListesiYazdir();
                flag=true;

            }
            if(flag==false){
                System.out.println("Gecerli unvan girin");

            }

        }

        private static void hastaDurumu() throws InterruptedException {
            Durum hastaDurumu = new Durum();
            System.out.println("*****  HASTA LISTELEME ***** ");
            System.out.println("Hasta durumunu giriniz: ");
            String hastaDurum = scan.nextLine();
            switch (hastaDurum) {
                case "Allerji":
                    System.out.println(hastaDurumu.isAciliyet(false));
                    break;
                case "Bas agrisi":
                    System.out.println(hastaDurumu.isAciliyet(false));
                    break;
                case "Diabet":
                    System.out.println(hastaDurumu.isAciliyet(false));
                    break;
                case "Soguk alginligi":
                    System.out.println(hastaDurumu.isAciliyet(false));
                    break;
                case "Migren":
                    System.out.println(hastaDurumu.isAciliyet(true));
                    break;
                case "Kalp hastaliklari":
                    System.out.println(hastaDurumu.isAciliyet(true));
                    break;
                default:
                    System.out.println("Gecerli bir durum degil");

            }


        }

        private static void hastaListesiYazdir() {
            System.out.println("*****  HASTA LISTELEME ***** ");
            System.out.println("IdNo  ismi   soyadi  AktuelDurum\n" +
                    "----------------------------------------------------");
            Set<Map.Entry<Integer, String>> hastaListSet = hastaListesiMap.entrySet();
            for (Map.Entry<Integer, String> each : hastaListSet) {
                Integer eachKey = each.getKey();
                String eachValue = each.getValue();
                String valueArr[] = eachValue.split(", ");
                System.out.printf("%-4d %-8s %-8s %-8s  \n", eachKey, valueArr[0], valueArr[1], valueArr[2]);

            }
        }

        private static void hastaEkle() {
            // Hasta obj = new Hasta();

            System.out.println("============= HASTA EKLME =============");
            System.out.println("Hasta ismi girin: ");
            String hastaAdi = scan.nextLine();
            System.out.println(" Hasta Soyisim girin: ");
            String hastaSoyadi = scan.nextLine();
            System.out.println("Hasta aktuel durumunu girin: ");
            String aktuelDurum = scan.nextLine();
            String eklenecekValue =  hastaAdi + ", " + hastaSoyadi + ", " + aktuelDurum;
            hastaListesiMap.put(hastaIDNo, eklenecekValue);
            System.out.println("Eklemek istediginiz Hasta " + hastaIDNo + " ID numarasi ile sisteme basarili sekilde eklendi");
            hastaIDNo += 111;
        }

        private static void hastaMenusuCikis() throws InterruptedException {
            System.out.println("==>AnaMenuye donmek icin 1'e\n" +
                    "==>Cikis icin 0'a basin");
            int secim = scan.nextInt();
            if (secim == 1) {
                hastaneMenusu();
            } else if (secim == 0) {
                System.out.println("Sistemden cikisiniz gerceklesti");
            }
        }

    }

