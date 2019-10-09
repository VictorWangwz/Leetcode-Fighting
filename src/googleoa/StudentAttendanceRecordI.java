package googleoa;
//551. Student Attendance Record I
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int numOfA = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
                int numOfL = 0;
                while( i < s.length() && s.charAt(i) == 'L'){
                    numOfL ++;
                    i++;
                    if(numOfL > 2){
                        return false;
                    }
                }
            }
            if( i < s.length() && s.charAt(i) == 'A'){
                numOfA ++;
            }
            if(numOfA > 1){
                return false;
            }
        }
        return true;
    }
}
