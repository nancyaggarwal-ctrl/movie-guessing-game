import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieWordGuessGUI extends JFrame {

    String[] movies = {
        "DANGAL","SHOLAY","LAGAAN","BAHUBALI","KGF","ANDHADHUN", "CHAKDEINDIA","DHURANDHAR","TAAREZAMEENPAR","3IDIOTS","STRANGERTHINGS","INCEPTION","JOKER"};

    String movie;
    char[] guessed;
    int lifelines = 5;   

    JLabel wordLabel, messageLabel, lifelineLabel;
    JTextField inputField;
    JButton guessButton;

    public MovieWordGuessGUI() {              //constructor

        setTitle("Movie Word Guessing Game");       // Frame settings
        setSize(700, 500);
        setLayout(new GridLayout(6,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Random ran = new Random();                   // Random movie selection
        movie = movies[ran.nextInt(movies.length)];
        guessed = new char[movie.length()];
        Arrays.fill(guessed, '_');

        int fill = movie.length() / 3;                 // Fill 1/3 letters automatically
        int count = 0;
        while(count < fill){
            int idx = ran.nextInt(movie.length());
            if(guessed[idx] == '_'){
                guessed[idx] = movie.charAt(idx);
                count++;
            }
        }

        JLabel title = new JLabel("🎬 Movie Word Guessing Game", JLabel.CENTER);    
        title.setFont(new Font("Arial", Font.BOLD, 40));

        wordLabel = new JLabel(getWord(), JLabel.CENTER);
        wordLabel.setFont(new Font("Monospaced", Font.BOLD, 40));

        lifelineLabel = new JLabel("Lifelines: "+lifelines , JLabel.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Letter: "));
        inputField = new JTextField(5);
        inputPanel.add(inputField);

        guessButton = new JButton("Guess");

        messageLabel = new JLabel(" ", JLabel.CENTER);

        add(title);
        add(wordLabel);
        add(lifelineLabel);
        add(inputPanel);
        add(guessButton);
        add(messageLabel);

        guessButton.addActionListener(e -> guessLetter());     // Button action

        setVisible(true);
    }

    String getWord(){                  // Display word with spaces
        String s = "";
        for(char c : guessed)
            s += c + " ";
        return s;
    }

    void guessLetter(){               // Guess logic
        String input = inputField.getText().toUpperCase();
        inputField.setText("");

        if(input.length() != 1){
            messageLabel.setText("Enter only ONE letter!");
            return;
        }

        char ch = input.charAt(0);
        boolean found = false;

        for(int i=0;i<movie.length();i++){
            if(movie.charAt(i) == ch && guessed[i] == '_'){
                guessed[i] = ch;
                found = true;
            }
        }

        if(found){
            messageLabel.setText("✅ Correct Guess!");
        } else {
            lifelines--;                              //lifeline decrease
            messageLabel.setText("❌ Wrong Guess!");
        }

        wordLabel.setText(getWord());
        lifelineLabel.setText("Lifelines: " + lifelines);

        if(String.valueOf(guessed).equals(movie)){                // Win condition
            JOptionPane.showMessageDialog(this,
                "🎉 Congratulations!\nMovie Name: " + movie);
            guessButton.setEnabled(false);
        }

        if(lifelines == 0){                            // Game Over condition
            JOptionPane.showMessageDialog(this,
                "❌ Game Over!\nCorrect Movie: " + movie);
            guessButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
         new MovieWordGuessGUI();
    }
}
