import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator extends JFrame {
    private JTextField textField1, textField2, textField3, textField4, textField5;
    private JButton calculateButton;
    private JLabel totalMarksLabel, averagePercentageLabel, gradeLabel;

    public GradeCalculator() {
        setTitle("Grade Calculator");
        setSize(350, 400); // Adjusted for better spacing
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Initialize text fields for input
        textField1 = new JTextField();
        textField1.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField1.getPreferredSize().height));
        textField2 = new JTextField();
        textField2.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField2.getPreferredSize().height));
        textField3 = new JTextField();
        textField3.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField3.getPreferredSize().height));
        textField4 = new JTextField();
        textField4.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField4.getPreferredSize().height));
        textField5 = new JTextField();
        textField5.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField5.getPreferredSize().height));

        // Initialize button with action listener
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });

        // Initialize labels to display results
        totalMarksLabel = new JLabel("Total Marks: ");
        averagePercentageLabel = new JLabel("Average Percentage: ");
        gradeLabel = new JLabel("Grade: ");

        // Add components to the frame with spacing
        add(createLabeledField("Subject 1 Marks: ", textField1));
        add(Box.createRigidArea(new Dimension(0, 5))); // Adds vertical space
        add(createLabeledField("Subject 2 Marks: ", textField2));
        add(Box.createRigidArea(new Dimension(0, 5))); // Adds vertical space
        add(createLabeledField("Subject 3 Marks: ", textField3));
        add(Box.createRigidArea(new Dimension(0, 5))); // Adds vertical space
        add(createLabeledField("Subject 4 Marks: ", textField4));
        add(Box.createRigidArea(new Dimension(0, 5))); // Adds vertical space
        add(createLabeledField("Subject 5 Marks: ", textField5));
        add(Box.createRigidArea(new Dimension(0, 10))); // Adds vertical space
        add(calculateButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Adds vertical space
        add(totalMarksLabel);
        add(averagePercentageLabel);
        add(gradeLabel);

        pack(); // Adjusts window size to fit components
        setVisible(true);
    }

    private JPanel createLabeledField(String label, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel(label));
        panel.add(textField);
        return panel;
    }

    private void calculateResults() {
        try {
            int marks1 = Integer.parseInt(textField1.getText().trim());
            int marks2 = Integer.parseInt(textField2.getText().trim());
            int marks3 = Integer.parseInt(textField3.getText().trim());
            int marks4 = Integer.parseInt(textField4.getText().trim());
            int marks5 = Integer.parseInt(textField5.getText().trim());

            // Calculate total marks and average percentage
            int totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
            double averagePercentage = (double) totalMarks / 5.0;

            // Determine grade based on average percentage
            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display results
            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averagePercentageLabel.setText(String.format("Average Percentage: %.2f%%", averagePercentage));
            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}

