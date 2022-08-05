public class NumberOfDaysInMonths {

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
        else return false;
    }

    public static int getDaysInMonth(int month, int year) {
        if(month < 1 || month >12) return -1;
        if(year< 1 || year >9999) return -1;
        if(month == 1 || month == 3 || month == 5 || month ==7 || month == 8 || month == 10 || month == 12)
            return 31;
        if(month == 2) {
            if(isLeapYear(year)) return 29;
            return 28;
        }
        return 30;
    }
}
