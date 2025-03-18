package StudentManagement.GUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Primary
@Component
public class StudentManagementGUI extends JFrame {

    private final AddStudentGUI addStudentGUI;
    private final DeleteStudentGUI deleteStudentGUI;
    private final UpdateStudentGUI updateStudentGUI;
    private final ViewStudentGUI viewStudentGUI;

    // Constructor with dependency injection
    @Autowired
    public StudentManagementGUI(AddStudentGUI addStudentGUI, DeleteStudentGUI deleteStudentGUI,
                                UpdateStudentGUI updateStudentGUI, ViewStudentGUI viewStudentGUI) {
        this.addStudentGUI = addStudentGUI;
        this.deleteStudentGUI = deleteStudentGUI;
        this.updateStudentGUI = updateStudentGUI;
        this.viewStudentGUI = viewStudentGUI;

        setTitle("Student Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();  // Initialize GUI components
    }

    // Method to initialize components and layout
    public void init() {
        // Main panel with BorderLayout and margins
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Button panel with vertical GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 20));  // 4 rows, 1 column, 20px vertical gap
        
        JButton[] buttons = {
            new JButton("Add Student"),
            new JButton("Delete Student"),
            new JButton("Update Student"),
            new JButton("View Students")
        };

        // Set uniform button size - bigger than before
        Dimension buttonSize = new Dimension(200, 50);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setPreferredSize(buttonSize);
            final int index = i;
            buttons[i].addActionListener(e -> {
                switch(index) {
                    case 0: addStudentGUI.setVisible(true); break;
                    case 1: deleteStudentGUI.setVisible(true); break;
                    case 2: updateStudentGUI.setVisible(true); break;
                    case 3: viewStudentGUI.setVisible(true); break;
                }
            });
            buttonPanel.add(buttons[i]);
        }

        // Center the button panel
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(buttonPanel);

        // Welcome label with larger margins
        JLabel welcomeLabel = new JLabel("Welcome to Student Management System", SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        add(mainPanel);
    }
}
    