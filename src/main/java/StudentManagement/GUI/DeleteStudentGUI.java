package StudentManagement.GUI;

import StudentManagement.controller.StudentManager;
import StudentManagement.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.*;

@Component
public class DeleteStudentGUI extends JFrame {

    private StudentManager studentManager; // Inject StudentManager

    private JTextField studentIdField;

    // Constructor injecting StudentManager
    public DeleteStudentGUI(StudentManager studentManager) {
        this.studentManager = studentManager; // Constructor injection

        setTitle("Delete Student");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with padding
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(3, 2, 10, 10));  // 3 rows, 2 columns, 10px gaps

        // Add Student ID field
        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        // Add buttons with some spacing
        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(e -> deleteStudent());
        panel.add(deleteButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> exit());
        panel.add(exitButton);

        add(panel);
    }

    private void deleteStudent() {
        String studentIdText = studentIdField.getText().trim();
        if (studentIdText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int studentId = Integer.parseInt(studentIdText);

            // Use studentManager to get student details, which returns a ResponseEntity
            ResponseEntity<Student> response = studentManager.getStudentById(studentId);

            if (response.getStatusCode() != HttpStatus.OK) {
                JOptionPane.showMessageDialog(this, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // If student found, call the delete endpoint
            ResponseEntity<Void> deleteResponse = studentManager.deleteStudent(studentId);

            if (deleteResponse.getStatusCode() == HttpStatus.NO_CONTENT) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete student.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Student ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Exit button event handler
    private void exit() {
        // Close the current window and return to the previous screen
        this.dispose();
    }
}
