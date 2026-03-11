
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    @DisplayName("Grade 70 should return true for passing")
    void testPassingGrade(){
        LehmanGradeBook gb = new LehmanGradeBook();
        assertTrue(gb.isPassing(70),"A grade of 70 should pass.");
    }

    @Test
    void testLetterGradeA(){
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('A',gb.getLetterGrade(95));
    }

    @Test
    void testLetterGradeF(){
        LehmanGradeBook gb = new LehmanGradeBook();
        assertEquals('F', gb.getLetterGrade(50));
    }

    @Test
    void testBoundaryGrades() {
        LehmanGradeBook gb = new LehmanGradeBook();

        assertEquals('A', gb.getLetterGrade(90));
        assertEquals('B',gb.getLetterGrade(80));
        assertEquals('C', gb.getLetterGrade(70));
    }

    @Test
    void testInvalidGradeThrowsException() {
        LehmanGradeBook gb = new LehmanGradeBook();

        assertThrows(IllegalArgumentException.class, () -> {
            gb.isPassing(150);
        });
    }
}
	

}
