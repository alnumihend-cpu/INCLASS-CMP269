package Exercise6;

public class LehmanGradeBook {

    public boolean isPassing(int grade){

        if(grade < 0 || grade >100) {
            throw new IllegalArgumentException("Invalid grade");
        }

        return grade >= 70;
    }
    
    //method
    public char getLetterGrade(int score) {

        if(score >= 90) {
            return 'A';
        }
        
        else if(score >= 80) {
            return 'B';
        }
        else if(score >= 70) {
            return 'C';
        }
        else if(score >= 60) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
}