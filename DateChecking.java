import java.time.LocalDate;
public class DateChecking {
   
        public static Boolean check(String date){
        LocalDate currentDate=LocalDate.now(); 
        String[] parts = date.split("[^0-9]+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format");
        }

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate deleviryDate=LocalDate.of(year,month,day);
        if (currentDate.isBefore(deleviryDate)||currentDate.isEqual(deleviryDate)) {
            return true; 
        }
        return false; 
    }



    //for reports....ali
    public static LocalDate getLocalDate(String date){
        String[] parts = date.split("[^0-9]+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format");
        }
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate localDate=LocalDate.of(year,month,day);
        return localDate;
    }
    
}