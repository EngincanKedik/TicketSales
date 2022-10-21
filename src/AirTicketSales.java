import java.util.Scanner;

public class AirTicketSales {
    public static void main(String[] args) {

        ticketSalesApp.run();

    }
}

class ticketSalesApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("1. Ankara - İstanbul, 2. İstanbul - Antalya, 3. Ankara - Van, 4. İzmir - Gaziantep, 5. Çanakkale - Tokat");
        System.out.print("Gitmek istediğiniz seferin numarasını seçiniz: ");
        int travelChoosen = kb.nextInt();
        System.out.print("Gidiş-Dönüş bileti için 1, Tek yön için 2'yi tuşlayınız: ");
        int oneOrtwoTicket = kb.nextInt();
        System.out.print("Yaşınızı giriniz: ");
        int Age = kb.nextInt();
        printResult(calculatetravel(travelChoosen), oneOrtwoTicket(oneOrtwoTicket), Age);

    }

    public static int calculatetravel(int Choosen)
    {
        if (Choosen == 1) {
            int ankaraIstanbul = 400;
            Choosen = ankaraIstanbul;
        }
        else if (Choosen == 2) {
            int istanbulAntalya = 600;
            Choosen = istanbulAntalya;
        } else if (Choosen == 3) {
            int ankaraVan = 850;
            Choosen = ankaraVan;
        } else if (Choosen == 4) {
            int izmirGaziantep = 1200;
            Choosen = izmirGaziantep;
        }
        else {
            int canakkaleTokat = 1000;
            Choosen = canakkaleTokat;
        }

        return Choosen * 20;
    }

    public static double calculateDiscount(int calculatetravel, boolean oneOrtwoTicket)
    {
        double discountAmount;
        double discountResult;

        if (oneOrtwoTicket)
        {
            discountAmount = 0.20;
            discountResult = calculatetravel - calculatetravel * discountAmount;
        }

        else {
            discountResult = calculatetravel;
        }

        return discountResult;
    }

    public static double caltulateDiscountAge(int Age)
    {
        double discountAgeAmount;

        if (Age < 12)
        {
            discountAgeAmount = 0.50;
        } else if (Age < 25) {
            discountAgeAmount = 0.10;
        }
        else if (Age < 65) {
            discountAgeAmount = 0;
        }
        else {
            discountAgeAmount = 0.30;
        }

        return discountAgeAmount;
    }

    public static void printResult(int calculatetravel, boolean oneOrtwoTicket, int Age)
    {
        double calculateTwoDiscount = calculateDiscount(calculatetravel, oneOrtwoTicket);
        double AgeDiscount = caltulateDiscountAge(Age);
        double resultPrice = calculateTwoDiscount - calculateTwoDiscount * AgeDiscount;

        System.out.printf("Bilet Fiyat: %f%n", resultPrice);

    }

    public static boolean oneOrtwoTicket(int oneOrtwo)
    {
        return oneOrtwo == 1;
    }
}

