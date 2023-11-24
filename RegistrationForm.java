import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleRegistrationForm extends JFrame {

    private JTextField nameField, usernameField, emailField, phoneField, addressField;
    private JPasswordField passwordField, confirmPasswordField;

    public SimpleRegistrationForm() {
        
        setTitle("Simple Registration Form");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        nameField = new JTextField(15);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);
        emailField = new JTextField(15);
        phoneField = new JTextField(15);
        addressField = new JTextField(15);

        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        JButton closeButton = new JButton("Close");

        
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                registerUser();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                clearFields();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });

        
        setLayout(new GridLayout(8, 2));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Confirm Password:"));
        add(confirmPasswordField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Address:"));
        add(addressField);
        add(submitButton);
        add(resetButton);
        add(closeButton);
    }

    private void registerUser() {
        
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        
        String userInfo = String.format("Name: %s\nUsername: %s\nEmail: %s\nPhone: %s\nAddress: %s",
                name, username, email, phone, address);

        JOptionPane.showMessageDialog(this, userInfo, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    private void clearFields() {
        
        nameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new SimpleRegistrationForm().setVisible(true);
            }
        });
    }
}
