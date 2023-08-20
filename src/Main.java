import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int bhsIndonesia, bhsInggris, matematika, ipa;
        int passingGradeSMK, passingGradeSastra, passingGradeTIK;
        double averageUjian, averageBahasa;
        boolean isPassingTIK, isPassingSastra, isPassingSMK;

        passingGradeSastra = 75;
        passingGradeSMK = 73;
        passingGradeTIK = 80;

        System.out.print("Masukkan nilai ujian Bahasa Indonesia: ");
        bhsIndonesia = input.nextInt();

        System.out.print("Masukkan nilai ujian Bahasa Inggris: ");
        bhsInggris = input.nextInt();

        System.out.print("Masukkan nilai ujian Matematika: ");
        matematika = input.nextInt();

        System.out.print("Masukkan nilai ujian IPA: ");
        ipa = input.nextInt();

        averageUjian = calculateAverageUjian(bhsIndonesia, bhsInggris, matematika, ipa);
        averageBahasa = calculateAverageBahasa(bhsIndonesia, bhsInggris);

        isPassingTIK = checkPassingGrade(matematika, passingGradeTIK);
        isPassingSastra = checkPassingGrade(averageBahasa, passingGradeSastra);
        isPassingSMK = checkPassingGrade(averageUjian, passingGradeSMK);

        displayResults(averageUjian, isPassingTIK, isPassingSastra, isPassingSMK);
    }

    private static double calculateAverageUjian(int bhsIndonesia, int bhsInggris, int matematika, int ipa) {
        return (bhsIndonesia + bhsInggris + matematika + ipa) / 4.0;
    }

    private static double calculateAverageBahasa(int bhsIndonesia, int bhsInggris) {
        return (bhsIndonesia + bhsInggris) / 2.0;
    }

    private static boolean checkPassingGrade(double score, int passingGrade) {
        return score >= passingGrade;
    }

    private static void displayResults(double averageUjian, boolean isPassingTIK, boolean isPassingSastra, boolean isPassingSMK) {
        System.out.println();
        System.out.println("Nilai rata-rata ujian kamu adalah: " + averageUjian);

        if (isPassingTIK && !isPassingSMK) {
            System.out.println("Kamu mempunyai bakat di Jurusan Teknik Komputer Jaringan.");
            System.out.println("Tapi, berdasarkan nilai rata-rata, kamu belum memenuhi kualifikasi masuk ke SMK Padepokan 79.");
        } else if (isPassingSastra && !isPassingSMK) {
            System.out.println("Kamu mempunyai bakat di Jurusan Sastra.");
            System.out.println("Tapi, berdasarkan nilai rata-rata, kamu belum memenuhi kualifikasi masuk ke SMK Padepokan 79.");
        } else if (isPassingTIK && isPassingSMK) {
            System.out.println("Selamat! Kamu lolos kualifikasi masuk Jurusan Teknik Komputer Jaringan.");
        } else if (isPassingSastra && isPassingSMK) {
            System.out.println("Selamat! Kamu lolos kualifikasi masuk Jurusan Sastra.");
        } else {
            System.out.println("Maaf, kamu belum memenuhi kualifikasi masuk ke semua Jurusan yang ada.");
        }
    }
}
