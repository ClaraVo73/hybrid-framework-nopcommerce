package javaBasic;

public class Topic_14_Class_Object {
    //Properties
    private int studentId;
    private String fullName;
    private float theoryScore, practiceScore;

    //Constructor
    public Topic_14_Class_Object(int studentId, String fullName, float theoryScore, float practiceScore){
        this.studentId = studentId;
        this.fullName = fullName;
        this.theoryScore = theoryScore;
        this.practiceScore = practiceScore;
    }

    //Getter and Setter studentID
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    //Getter and Setter fullName
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }


    //Getter and Setter theoryScore
    public float getTheoryScore(){
        return theoryScore;
    }
    public void setTheoryScore(float theoryScore){
        this.theoryScore = theoryScore;
    }


    //Getter and Setter practiceScore
    public float getPracticeScore(){
        return practiceScore;
    }
    public void setPracticeScore(float practiceScore){
        this.practiceScore = practiceScore;
    }

    //Method to calculate average score
    public float calculateAverageScore(){
        return (theoryScore + practiceScore *2) / 3;
    }

    //Method to display student information
    public void displayStudentInfo(){
        System.out.println("************************************");
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Average Score: " + calculateAverageScore());

    }
    public static void main(String[] args){
        //Creating 3 student objects
        Topic_14_Class_Object sv1 = new Topic_14_Class_Object(1, "Nguyen Ngoc An Nhien", 9.8f,9.9f);
        Topic_14_Class_Object sv2 = new Topic_14_Class_Object(2, "Nguyen Ngoc Diem My", 8.9f,9.0f);
        Topic_14_Class_Object sv3 = new Topic_14_Class_Object(3, "Nguyen Van Gioi", 6.4f,5.2f);

        //Display information of each student
        sv1.displayStudentInfo();
        System.out.println();
        sv2.displayStudentInfo();
        System.out.println();
        sv3.displayStudentInfo();

    }

}
