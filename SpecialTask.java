public class SpecialTask {

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear)
    {
        int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(toYear > 9291) toYear = 9291;
        if(fromYear < 101) fromYear = 101;

        for(int currentYear = fromYear; currentYear < toYear; currentYear++)
        {
            if(currentYear % 4 == 0)
                monthLength[1] = 29;
            else
                monthLength[1] = 28;

            int rightSide = reverseDate(currentYear);
            int month = rightSide / 100;
            int day = rightSide % 100;

            if(month >= 1 && month <= 12 && day >= 1 && day <= monthLength[month - 1])
            {
                System.out.printf("%04d-%02d-%02d%n", currentYear, month, day);
            }
        }
    }

    public static int reverseDate(int date)
    {
        int result = date % 10;
        for(int i = 0; i < 3; i++)
        {
            date /= 10;
            result = result * 10 + date % 10;
        }
        return result;
    }
}
