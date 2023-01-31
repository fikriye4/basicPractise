package hastaneProject;

    import static hastaneProject.hastaneIslemler.hastaneMenusu;

    public class HastaneRunner {


        public static void main(String[] args) throws InterruptedException {

            DoktorIslemler.doktorListesi();
            HastaIslemler.hastaListesi();
            hastaneMenusu();


        }

    }