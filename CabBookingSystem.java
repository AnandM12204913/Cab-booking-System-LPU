import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.awt.Image;
import javax.imageio.ImageIO;


public class CabBookingSystem extends JFrame implements ActionListener {
	
   
     


    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JLabel pickUpLabel;
    private JLabel destinationLabel;
    private JComboBox<String> pickUpComboBox;
    private JComboBox<String> destinationComboBox;
    private JButton bookCabButton;

    public CabBookingSystem() {
        setTitle("LPU Cab Booking System");
        setSize(1900,1100 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		JLabel label = new JLabel();
    
		
     

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        pickUpLabel = new JLabel("Pick Up Location:");
        
        destinationLabel = new JLabel("Destination:");
        pickUpComboBox = new JComboBox<String>(new String[] {"Uni Hospital", "Uni Mall", "Robo Park", "Block 38", "BH-1", "Sports Complex", "BH-4", "BH-6", "Block 55", "Main Gate"});
        pickUpComboBox.setPreferredSize(new Dimension(300,20));
        destinationComboBox = new JComboBox<String>(new String[] {"Uni Hospital", "Uni Mall", "Robo Park", "Block 38", "BH-1", "Sports Complex", "BH-4", "BH-6", "Block 55", "Main Gate"});
        bookCabButton = new JButton("Book Cab");
        bookCabButton.addActionListener(this);
        setLayout(new FlowLayout()); 
        JLabel empty_line1 = new JLabel("");
        JLabel empty_line2 = new JLabel("");
        JLabel empty_line3 = new JLabel("");
        empty_line1.setPreferredSize(new Dimension(3000,0));
        empty_line2.setPreferredSize(new Dimension(3000,0));
        empty_line3.setPreferredSize(new Dimension(3000,0));
        usernameField.setPreferredSize(new Dimension(200,20));
        passwordField.setPreferredSize(new Dimension(200,20));

		label.setIcon(new ImageIcon("logo.png"));
        
		add(label);
        add(empty_line1);
        
        
        

            add(usernameLabel);
            add(usernameField);
            add(empty_line2);
        

        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(empty_line3);
        add(loginButton);
        
        
        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("Anand") && password.equals("Anand@123")) {
                getContentPane().removeAll();
                getContentPane().setLayout(new GridLayout(3, 2));
                getContentPane().add(pickUpLabel);
                getContentPane().add(pickUpComboBox);
                getContentPane().add(destinationLabel);
                getContentPane().add(destinationComboBox);
                getContentPane().add(new JLabel());
                getContentPane().add(bookCabButton);
                revalidate();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        } else if (e.getSource() == bookCabButton) {
            String pickUpLocation = (String) pickUpComboBox.getSelectedItem();
            String destination = (String) destinationComboBox.getSelectedItem();

            int fare = 15;
            JOptionPane.showMessageDialog(null, "Your cab has been booked from " + pickUpLocation + " to " + destination + " for a fare of " + fare + " rupees.");
        }
    }

    public static void main(String[] args) {
        new CabBookingSystem();
    }
}
