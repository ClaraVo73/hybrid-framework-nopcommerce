public class Topic_09_Array_Students_Exercise {
    private int ID;
    private String name;
    private int age;
    private double score;

    // Constructor to initialize values
    public Topic_09_Array_Students_Exercise(int ID, String name, int age, double score) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Method to display information
    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
    }

    public static void main(String[] args) {
        // Tạo một đối tượng Student
        Topic_09_Array_Students_Exercise student1 = new Topic_09_Array_Students_Exercise(1, "John Doe", 20, 85.5);

        // Gọi phương thức display để hiển thị thông tin học sinh
        System.out.println("Thông tin học sinh:");
        student1.display();
    }
}