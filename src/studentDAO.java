import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add student
    public void addStudent(Student student) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students(name, age, department) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDepartment());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View students
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("department")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
