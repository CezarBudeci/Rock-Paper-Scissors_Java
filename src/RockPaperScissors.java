import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;

public class RockPaperScissors extends JFrame {

	private JPanel contentPane;
	private JPanel panelStart;
	private JLabel lblTitle;
	private JTextField textUsername;
	private JLabel lblUsername;
	private JButton btnStart;
	private String username;
	private JPanel panelGame;
	private JLabel lblHighScore;
	private JLabel lblScore;
	private JLabel lblHighScoreValue;
	private JLabel lblScoreValue;
	private JButton btnEndGame;
	private JButton btnRock;
	private JButton btnPaper;
	private JButton btnScissors;
	private JLabel lblComputerAnswer;
	private JLabel lblUsername2;
	private JLabel lblUsernameValue;
	private JLabel lblComputerHighScore;
	private JLabel lblComputerScore;
	private JLabel lblComputer;
	private JButton btnSave;
	private int result;
	private ArrayList<String> highscores = new ArrayList<String>();
	File testFile = new File("");
	private String filePath;
	private String fileAdd = "/highscore.txt";
	private JButton btnResetScore;
	private JButton btnResetHighScore;
	private JButton btnChangeUsername;
	private JLabel lblRock;
	private JLabel lblPaper;
	private JLabel lblScissors;
	private JLabel lblBackground;
	private JLabel lblUrChoice;
	private JLabel bgPanelStart;
	private String urChoice = "Your choice: ";
	private Image img1 = (new ImageIcon(this.getClass().getResource("/rock1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img1a = (new ImageIcon(this.getClass().getResource("/rock2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img2 = (new ImageIcon(this.getClass().getResource("/paper1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img2a = (new ImageIcon(this.getClass().getResource("/paper2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img3 = (new ImageIcon(this.getClass().getResource("/scissors1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img3a = (new ImageIcon(this.getClass().getResource("/scissors2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img4 = (new ImageIcon(this.getClass().getResource("/rockcomp1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img4a = (new ImageIcon(this.getClass().getResource("/rockcomp2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img5 = (new ImageIcon(this.getClass().getResource("/papercomp1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img5a = (new ImageIcon(this.getClass().getResource("/papercomp2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img6 = (new ImageIcon(this.getClass().getResource("/scissorscomp1.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	private Image img6a = (new ImageIcon(this.getClass().getResource("/scissorscomp2.png")).getImage()).getScaledInstance(180, 210, Image.SCALE_SMOOTH);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissors frame = new RockPaperScissors();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RockPaperScissors() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				panelGame.setVisible(false);
				panelGame.setEnabled(false);

				System.out.println();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panelGame = new JPanel();
		panelGame.setBounds(0, 0, 995, 618);
		contentPane.add(panelGame);
		panelGame.setLayout(null);
		
		lblHighScore = new JLabel("Highscore:");
		lblHighScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHighScore.setBounds(49, 46, 79, 29);
		panelGame.add(lblHighScore);
		
		lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScore.setBounds(49, 78, 65, 29);
		panelGame.add(lblScore);
		
		lblHighScoreValue = new JLabel("0000");
		lblHighScoreValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScoreValue.setBounds(191, 49, 56, 23);
		panelGame.add(lblHighScoreValue);
		
		lblScoreValue = new JLabel("0");
		lblScoreValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreValue.setBounds(191, 81, 56, 23);
		panelGame.add(lblScoreValue);
		
		btnEndGame = new JButton("End");
		btnEndGame.setBackground(Color.WHITE);
		btnEndGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				saving();
				System.exit(0);
				
			}
		});
		btnEndGame.setBounds(848, 57, 105, 50);
		panelGame.add(btnEndGame);
		
		btnRock = new JButton("Rock");
		btnRock.setContentAreaFilled(false);
		btnRock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				lblUrChoice.setText(urChoice + "Rock");
				computerAnswer(result());
				changePicture(1);
				if(result == 2) {
					setScoreComp();
				}
				else if(result == 3) {
					setScorePlayer();
				}
				updateHighScore();
			}

		});
		btnRock.setBounds(37, 395, 180, 210);
		panelGame.add(btnRock);
		
		btnPaper = new JButton("Paper");
		btnPaper.setContentAreaFilled(false);
		btnPaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblUrChoice.setText(urChoice + "Paper");
				computerAnswer(result());
				changePicture(2);
				
				if(result == 3) {
					setScoreComp();
				}
				else if(result == 1) {
					setScorePlayer();
				}
				updateHighScore();
				
			}

		});
		btnPaper.setBounds(298, 395, 180, 210);
		panelGame.add(btnPaper);
		
		btnScissors = new JButton("Scissors");
		btnScissors.setContentAreaFilled(false);
		btnScissors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblUrChoice.setText(urChoice + "Scissors");
				computerAnswer(result());
				changePicture(3);
				if(result == 1) {
					setScoreComp();
				}
				else if(result == 2) {
					setScorePlayer();
				}
				updateHighScore();
				
			}

		});
		btnScissors.setBounds(552, 395, 180, 210);
		panelGame.add(btnScissors);
		
		lblComputerAnswer = new JLabel("Computer's choice:");
		lblComputerAnswer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComputerAnswer.setOpaque(true);
		lblComputerAnswer.setBackground(Color.WHITE);
		lblComputerAnswer.setHorizontalAlignment(SwingConstants.LEFT);
		lblComputerAnswer.setBounds(35, 117, 210, 22);
		panelGame.add(lblComputerAnswer);
		
		lblUsername2 = new JLabel("Username:");
		lblUsername2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername2.setBounds(50, 17, 100, 29);
		panelGame.add(lblUsername2);
		
		lblUsernameValue = new JLabel("New label");
		lblUsernameValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameValue.setBounds(171, 17, 100, 29);
		panelGame.add(lblUsernameValue);
		
		lblComputerHighScore = new JLabel("0000");
		lblComputerHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputerHighScore.setBounds(315, 49, 56, 23);
		panelGame.add(lblComputerHighScore);
		
		lblComputerScore = new JLabel("0");
		lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputerScore.setBounds(315, 81, 56, 23);
		panelGame.add(lblComputerScore);
		
		lblComputer = new JLabel("Computer");
		lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputer.setBounds(295, 17, 100, 29);
		panelGame.add(lblComputer);
		
		btnSave = new JButton("Save ");
		btnSave.setBackground(Color.WHITE);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				changePicture(0);
				changePicturelbl(0);
				saving();
				
			}
		});
		btnSave.setBounds(848, 164, 105, 50);
		panelGame.add(btnSave);
		
		btnResetScore = new JButton("Reset Score");
		btnResetScore.setBackground(Color.WHITE);
		btnResetScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				resetScore();				
				changePicture(0);
				changePicturelbl(0);
			}
		});
		btnResetScore.setBounds(848, 271, 105, 50);
		panelGame.add(btnResetScore);
		
		btnResetHighScore = new JButton("<html>Reset<br>Highscore</html>");
		btnResetHighScore.setBackground(Color.WHITE);
		btnResetHighScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				resetHighScore();
				changePicture(0);
				changePicturelbl(0);
				saving();
				
				
			}
		});
		btnResetHighScore.setBounds(848, 378, 105, 50);
		panelGame.add(btnResetHighScore);
		
		btnChangeUsername = new JButton("<html>Change<br>Username</html>");
		btnChangeUsername.setBackground(Color.WHITE);
		btnChangeUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panelGame.setVisible(false);
				panelGame.setEnabled(false);
				panelStart.setVisible(true);
				panelStart.setEnabled(true);
				changePicture(0);
				changePicturelbl(0);
				saving();
				resetScore();
				
				
			}
		});
		btnChangeUsername.setBounds(848, 485, 105, 50);
		panelGame.add(btnChangeUsername);
		
		lblRock = new JLabel("New label");
		lblRock.setBounds(37, 152, 180, 210);
		panelGame.add(lblRock);
		
		lblPaper = new JLabel("New label");
		lblPaper.setBounds(298, 152, 180, 210);
		panelGame.add(lblPaper);
		
		lblScissors = new JLabel("New label");
		lblScissors.setBounds(552, 152, 180, 210);
		panelGame.add(lblScissors);
		
		
		lblUrChoice = new JLabel(urChoice);
		lblUrChoice.setOpaque(true);
		lblUrChoice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUrChoice.setBackground(Color.WHITE);
		lblUrChoice.setBounds(35, 362, 210, 22);
		panelGame.add(lblUrChoice);
		
		Image bg = new ImageIcon(this.getClass().getResource("/grasspanel.jpg")).getImage();
		lblBackground = new JLabel("New label");
		lblBackground.setBounds(6, 0, 983, 618);
		panelGame.add(lblBackground);
		lblBackground.setIcon(new ImageIcon(bg));
		
		panelStart = new JPanel();
		panelStart.setBounds(10, 11, 977, 615);
		contentPane.add(panelStart);
		panelStart.setLayout(null);
		panelStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblCreatedBy = new JLabel("Created by: Cezar Budeci, Anna Kot");
		lblCreatedBy.setForeground(Color.WHITE);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setBounds(760, 553, 207, 51);
		panelStart.add(lblCreatedBy);
		
		lblTitle = new JLabel("Rock, Paper, Scissors");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("Cambria", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(277, 11, 420, 21);
		panelStart.add(lblTitle);
		
		textUsername = new JTextField();
		textUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textUsername.setBounds(382, 242, 200, 64);
		panelStart.add(textUsername);
		textUsername.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setOpaque(true);
		lblUsername.setBounds(382, 228, 200, 14);
		panelStart.add(lblUsername);
		
		btnStart = new JButton("START");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStart.setBackground(Color.WHITE);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				if(btnStart.isEnabled()) {
					highscores.clear();
					username = textUsername.getText();//Gets username from label on first panel				
					panelStart.setEnabled(false);
					panelStart.setVisible(false);
					panelGame.setEnabled(true);
					panelGame.setVisible(true);
					lblUsernameValue.setText(username);//Introduces username in a label on main panel
					try {
						File file = new File(setPath());
						if(file.exists()) { //if file highscore.txt exists
							try {
								FileReader reader = new FileReader(setPath());
								BufferedReader bufferedReader = new BufferedReader(reader);
								
								String line;
								
									if(file.length() > 0) {//Tests if file has content
										while ((line = bufferedReader.readLine()) != null) {
											// System.out.println(line);
											highscores.add(line);
										}
										reader.close();
									
									}//Gets data from it
									else {
										highscores.add("0");
										highscores.add("0");
									}//Sets 0 0 
								
		
							} catch (IOException e) { //End of try
								System.out.println("Error");
								// e.printStackTrace();
							}
						
						}//Gets highscores from a file
						else {//Creates file
							file.createNewFile();
							highscores.add("0");
							highscores.add("0");
						}//Sets 0 0 
					} catch (IOException e) {
						System.out.println("Error");
					}
					
					lblHighScoreValue.setText(highscores.get(0));
					lblComputerHighScore.setText(highscores.get(1));
					
				}
				
			}

		});
		btnStart.setBounds(382, 355, 200, 150);
		panelStart.add(btnStart);
		
		bgPanelStart = new JLabel("");
		bgPanelStart.setBounds(0, 0, 977, 604);
		Image bg1 = new ImageIcon(this.getClass().getResource("/grass.jpg")).getImage();
		float width = bgPanelStart.getHeight() * (995f/618f);
		bg1 = bg1.getScaledInstance((int)width, bgPanelStart.getHeight(), Image.SCALE_SMOOTH);
		bgPanelStart.setIcon(new ImageIcon(bg1));
		panelStart.add(bgPanelStart);
		
		// Setting all the game button pictures to default
		changePicture(0);
		//Image bg = new ImageIcon(this.getClass().getResource("/grasspanel.jpg")).getImage();
		bg = bg.getScaledInstance(995, 618, Image.SCALE_SMOOTH);
		//Image bg1 = new ImageIcon(this.getClass().getResource("/grass.jpg")).getImage();
	
		
		//to set default label pictures
		changePicturelbl(0);
	}//End of constructor
	
	private int result() {
		Random ran = new Random();
		int resultValue = ran.nextInt(3)+1;
		return resultValue;
	}//Gives random number 1-3
	
	private void computerAnswer(int result) {
		this.result = result;
		switch(result) {
		case 1:
			lblComputerAnswer.setText("Computer's choice: Rock");
			changePicturelbl(1);
			break;
		case 2:
			lblComputerAnswer.setText("Computer's choice: Paper");
			changePicturelbl(2);
			break;
		case 3:
			lblComputerAnswer.setText("Computer's choice: Scissors");
			changePicturelbl(3);
			break;
		default:
			lblComputerAnswer.setText("");
		}
	}//Transforms random number into rock/paper/scissors and gives it to the user as computer answer
	
	private void setScorePlayer() {
		int score;
		score = Integer.parseInt(lblScoreValue.getText());
		score++;
		lblScoreValue.setText(Integer.toString(score));
	}
	
	private void setScoreComp() {
		int score;
		score = Integer.parseInt(lblComputerScore.getText());
		score++;
		lblComputerScore.setText(Integer.toString(score));
	}
	
//	private void setHighScorePlayer() {
//		int score;
//		score = Integer.parseInt(lblScoreValue.getText());
//		score++;
//		lblHighScoreValue.setText(Integer.toString(score));
//	}
//	
//	private void setHighScoreComp() {
//		int score;
//		score = Integer.parseInt(lblComputerScore.getText());
//		score++;
//		lblComputerHighScore.setText(Integer.toString(score));
//	}
	
	private void updateHighScore() {
		int highscorePlayer, highscoreComp, scorePlayer, scoreComp;
		highscorePlayer = Integer.parseInt(lblHighScoreValue.getText());
		highscoreComp = Integer.parseInt(lblComputerHighScore.getText());
		scorePlayer = Integer.parseInt(lblScoreValue.getText());
		scoreComp = Integer.parseInt(lblComputerScore.getText());
		if(scorePlayer > highscorePlayer || scoreComp > highscoreComp) {
			lblHighScoreValue.setText(Integer.toString(scorePlayer));
			lblComputerHighScore.setText(Integer.toString(scoreComp));
		}
	}
	
	private String setPath() {
		
		filePath = testFile.getAbsolutePath() + fileAdd;
		return filePath;
	}
	
	private void saving() {
		try {
			FileWriter writer = new FileWriter(setPath());
			writer.write(lblHighScoreValue.getText());
			writer.write("\r\n");
			writer.write(lblComputerHighScore.getText());
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void resetScore() {
		lblScoreValue.setText("0");
		lblComputerScore.setText("0");
	}
	
	private void resetHighScore() {
		lblHighScoreValue.setText("0");
		lblComputerHighScore.setText("0");
	}
	
	private void changePicture(int picNumb)
	{
		
		
		switch (picNumb)
		{
		
		case 0:
			
			btnRock.setIcon(new ImageIcon(img1));			
			btnPaper.setIcon(new ImageIcon(img2));
			btnScissors.setIcon(new ImageIcon(img3));
			break;
			
		case 1:
			
			btnRock.setIcon(new ImageIcon(img1a));			
			btnPaper.setIcon(new ImageIcon(img2));
			btnScissors.setIcon(new ImageIcon(img3));
			break;

		case 2:
			
			btnRock.setIcon(new ImageIcon(img1));			
			btnPaper.setIcon(new ImageIcon(img2a));
			btnScissors.setIcon(new ImageIcon(img3));
			break;

		case 3:
			
			btnRock.setIcon(new ImageIcon(img1));
			btnPaper.setIcon(new ImageIcon(img2));
			btnScissors.setIcon(new ImageIcon(img3a));
			break;
		
		}
	}
	
	private void changePicturelbl(int picNumblbl)
	{

		switch (picNumblbl)
		{
		
		case 0:
			
			lblRock.setIcon(new ImageIcon(img4));			
			lblPaper.setIcon(new ImageIcon(img5));
			lblScissors.setIcon(new ImageIcon(img6));
			break;
			
		case 1:
			
			lblRock.setIcon(new ImageIcon(img4a));			
			lblPaper.setIcon(new ImageIcon(img5));
			lblScissors.setIcon(new ImageIcon(img6));
			break;

		case 2:
			
			lblRock.setIcon(new ImageIcon(img4));			
			lblPaper.setIcon(new ImageIcon(img5a));
			lblScissors.setIcon(new ImageIcon(img6));
			break;

		case 3:
			
			lblRock.setIcon(new ImageIcon(img4));
			lblPaper.setIcon(new ImageIcon(img5));
			lblScissors.setIcon(new ImageIcon(img6a));
			break;
		
		}
	}
}
