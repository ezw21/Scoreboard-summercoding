import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * This Class is implemented for a summer kids coding Programme
 * Aim to provide a fun, attractive interface to motivate student to accomplish the given task
 * Have a second class - Student, to support this main class 
 * Declare student profile in Scoreboard constructor, update after every class (perhaps implement a save file feature)
 * Weekly update these methods : Week_update, Homework_update, Additional_update
 * @author Edward Wong - University of Canterbury 
 * 26/11/2020
 */
public class Scoreboard {

	private JFrame frame;
	private JTextField input_Field;
	private int state;
	private int condition;
	private int studNo = 99;
	String temp_str;
	
	private Student student_0;
	private Student student_1;
	private Student student_2;
	private Student student_3;
	private Student student_4;
	private Student student_5;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scoreboard window = new Scoreboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});}
	
	//Declare design component
	JLabel System_Message = new JLabel();
	JProgressBar progressBar = new JProgressBar();
	JLabel Week_Label = new JLabel("Week_0");
	JLabel Level_Label = new JLabel("LV_99");
	JLabel EXP_Label = new JLabel("1000/1000");
	
	//Declare Task and Grade component
	JPanel Panel = new JPanel();
	JLabel Task_1 = new JLabel("New label");
	JLabel Task_2 = new JLabel("New label");
	JLabel Task_3 = new JLabel("New label");
	JLabel Task_4 = new JLabel("New label");	
	JLabel Grade_1 = new JLabel("XXX");
	JLabel Grade_2 = new JLabel("XXX");
	JLabel Grade_3 = new JLabel("XXX");
	JLabel Grade_4 = new JLabel("XXX");
	JButton Homework = new JButton("Homework");
	JButton Additional = new JButton("Additional");
	
	//Declare checkbox and button
	JCheckBox chckbxNewCheckBox = new JCheckBox("");
	JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
	JButton Enter = new JButton("Enter");
	private final JButton View = new JButton("View");
	private final JButton Add = new JButton("Add");
	private final JLabel Name_Label = new JLabel("Name");
	/**
	 * Create the application.
	 */
	public Scoreboard() {
		// declare student profile [Name, review, exp, level]
		student_0 = new Student("Mason", "No review at the moment", 0, 3 );	//Maison	
		student_1 = new Student("Jason", "No review at the moment", 0, 3 );	//Jayson
		student_2 = new Student("Han", "No review at the moment", 0, 3 );	//Han
		student_3 = new Student("Justin", "No review at the moment", 0, 3 ); 	//Justin
		student_4 = new Student("Student_4's Name", "No review at the moment", 1, 1 );	
		student_5 = new Student("Eason", "No review at the moment", 0, 3 );	//Eason
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Scoreboard_1.3");
		frame_panel_init();
		task_init();
		grade_init();
		task_btn_init();
		checkbox_init();
		design();
		button_design();
		
		/**
		 * Please update these Methods
		 */
		week_update();
		additional_update();
		homework_update();
		

		
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get studNo input
				if ((state == 0) && (condition == 1)) {
					String temp_str;
					temp_str = input_Field.getText();
					studNo = Integer.parseInt(temp_str);
					//System.out.println(studNo);
					// for debugging
					if (studNo == 0) {
						view_enter(student_0);
					}
					else if (studNo == 1) {
						view_enter(student_1);
					}
					else if (studNo == 2) {
						view_enter(student_2);
					}
					else if (studNo == 3) {
						view_enter(student_3);
					}
					else if (studNo == 4) {
						view_enter(student_4);
					}
					else if (studNo == 5) {
						view_enter(student_5);
					}
					else {
						state = 0; condition = 1;
						System_Message.setText("Invalid input");
					}

				}
				else {
					System_Message.setText("Click on functional button..");
				}
				
				
				
				input_Field.setText("");
			}
		});

		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt user to input studentNo
				condition = 0;
				if ((state == 0) && (condition == 0)) {
					System_Message.setText("Please key in Student Number that you wish to view and click Enter...");
					condition++;
				}
				
				
				input_Field.setText("");
			}
		});

		Add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				temp_str = input_Field.getText();
				if (temp_str.length() > 0) {
					
					if (studNo == 0) {
						add_enter(student_0,Integer.parseInt(temp_str) );
					}
					else if (studNo == 1) {
						add_enter(student_1,Integer.parseInt(temp_str) );
					}
					else if (studNo == 2) {
						add_enter(student_2,Integer.parseInt(temp_str) );
					}
					else if (studNo == 3) {
						add_enter(student_3,Integer.parseInt(temp_str) );
					}
					else if (studNo == 4) {
						add_enter(student_4,Integer.parseInt(temp_str) );
					}
					else if (studNo == 5) {
						add_enter(student_5,Integer.parseInt(temp_str) );
					}
//					else {
//						state = 0; condition = 1;
//						System_Message.setText("Invalid input");
//					}
					
				}
				else {
					System_Message.setText("Empty input.");
				}

				
				temp_str = "";
				input_Field.setText("");
			}
		});
}
	public void add_enter (Student student_index, int addition) {
		
		student_index.setExp(student_index.getExp() + addition);						//Add exp to student account
		
		while (student_index.getExp() >= 1000) {										//Check does student can level up
			student_index.setExp(student_index.getExp() - 1000);						//Deduct 1k EXP from student account
			student_index.setLevel(student_index.getLevel() + 1);						//Up Level
			
		}
		update_All(student_index);
		System_Message.setText("Level UP !!! You are currently on level " + String.valueOf(student_index.getLevel()));

	}
	public void view_enter(Student student_index) {
		update_All(student_index);
		
	}	
	public void update_All(Student student_index) {
		Name_Label.setText(student_index.getName());
		System_Message.setText(student_index.getReview()); 								// Action on Review
		EXP_Label.setText(String.valueOf(student_index.getExp()) + " / 1000");			// Action on EXP
		progressBar.setValue(student_index.getExp());									// Action on EXP, ProgressBar
		Level_Label.setText("LV " + String.valueOf(student_index.getLevel()));					// Action on LV
	}
	public void button_design() {
		//Enter button
		Enter.setFont(new Font("Tahoma", Font.BOLD, 11));
		Enter.setForeground(new Color(0, 0, 0));
		Enter.setBackground(new Color(173, 216, 230));
		Enter.setBounds(797, 312, 85, 45);
		Enter.setOpaque(true);
		frame.getContentPane().add(Enter);
		
		// View and add button
		View.setFont(new Font("Tahoma", Font.BOLD, 11));
		View.setBounds(620, 358, 80, 23);
		frame.getContentPane().add(View);
		Add.setFont(new Font("Tahoma", Font.BOLD, 11));
		Add.setBounds(707, 358, 80, 23);
		frame.getContentPane().add(Add);
		Name_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Name_Label.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		Name_Label.setBounds(180, 24, 360, 45);
		Name_Label.setOpaque(true);
		
		frame.getContentPane().add(Name_Label);
	}
	public void checkbox_untick() {
		chckbxNewCheckBox.setSelected(false);
		chckbxNewCheckBox_1.setSelected(false);
		chckbxNewCheckBox_2.setSelected(false);
		chckbxNewCheckBox_3.setSelected(false);
	}
	public void week_update() {
		// Upload Week from here
		
		Week_Label.setText("Week 5");
	}
	public void homework_update() {
		// Upload homework from here
		Task_1.setText("Practice on using round() function");
		Task_2.setText("Understanding the meaning of def and parameter.");
		Task_3.setText("Write a simple function. Then use the function.");
		Task_4.setText("Write a function to calculate the days in given number of years.");	
		
		Grade_1.setText("250");
		Grade_2.setText("250");
		Grade_3.setText("250");
		Grade_4.setText("250");
		
		Task_1.setVisible(true);
		Task_2.setVisible(true);
		Task_3.setVisible(true);
		Task_4.setVisible(true);
		checkbox_untick();

	}
	public void additional_update() {
		
		Task_1.setText("Do it if you can / We can discuss it in next class");
		Task_2.setText("Do this");
		Task_3.setText("Do this");
		Task_4.setText("Do this");
		
		Grade_1.setText("1000");
		Grade_2.setText("250");
		Grade_3.setText("250");
		Grade_4.setText("250");
		
		// Set visibility of the tasks
		Task_1.setVisible(true);
		Task_2.setVisible(false);
		Task_3.setVisible(false);
		Task_4.setVisible(false);
		
		checkbox_untick();
	}
	public void frame_panel_init() {
		frame.setBounds(100, 100, 950, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);			// Absolute layout
		
		
		Panel.setBounds(10, 100, 914, 200);
		Panel.setOpaque(true);
		Panel.setLayout(null);
		frame.getContentPane().add(Panel);
	}
	public void design() {

		
		System_Message.setBackground(new Color(250, 250, 210));
		System_Message.setVerticalAlignment(SwingConstants.BOTTOM);
		System_Message.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		System_Message.setText("Prepare_for_system_Message...");
		System_Message.setBounds(10, 311, 600, 85);
		System_Message.setOpaque(true);
		frame.getContentPane().add(System_Message);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(1000);
		
		
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setValue(400);
		progressBar.setBounds(101, 70, 650, 25);
		progressBar.setOpaque(true);
		frame.getContentPane().add(progressBar);
		
		
		Week_Label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Week_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Week_Label.setBackground(new Color(222, 184, 135));
		Week_Label.setBounds(10, 0, 160, 25);
		Week_Label.setOpaque(true);
		frame.getContentPane().add(Week_Label);
		
		Level_Label.setForeground(new Color(25, 25, 112));
		Level_Label.setBackground(new Color(255, 235, 205));
		Level_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Level_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Level_Label.setBounds(10, 35, 85, 60);
		Level_Label.setOpaque(true);
		frame.getContentPane().add(Level_Label);
		
		
		EXP_Label.setBackground(new Color(255, 235, 205));
		EXP_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EXP_Label.setHorizontalAlignment(SwingConstants.CENTER);
		EXP_Label.setBounds(757, 51, 167, 45);
		EXP_Label.setOpaque(true);
		frame.getContentPane().add(EXP_Label);
		
		// Init, declare, add Text field
		input_Field = new JTextField();
		input_Field.setBounds(620, 322, 167, 25);
		frame.getContentPane().add(input_Field);
		input_Field.setOpaque(true);
		input_Field.setColumns(10);
	}
	public void task_btn_init() {
		//init homework and additional button
		Homework.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homework_update();
			}
		});
		Homework.setBounds(0, 0, 150, 50);
		Panel.add(Homework);
		
		
		Additional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				additional_update();
			}
		});

		
	}
	public void checkbox_init () {
		Additional.setBounds(0, 61, 150, 50);
		Panel.add(Additional);
		
		chckbxNewCheckBox.setBounds(846, 15, 43, 23);
		Panel.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1.setBounds(846, 65, 43, 23);
		Panel.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2.setBounds(846, 115, 43, 23);
		Panel.add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3.setBounds(846, 165, 43, 23);
		Panel.add(chckbxNewCheckBox_3);
	}
	public void grade_init() {
		//init all grade label
		Grade_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Grade_1.setBackground(new Color(240, 230, 140));
		Grade_1.setHorizontalAlignment(SwingConstants.CENTER);
		Grade_1.setBounds(770, 0, 70, 45);
		Grade_1.setOpaque(true);
		Panel.add(Grade_1);
		
		
		Grade_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Grade_2.setBackground(new Color(240, 230, 140));
		Grade_2.setHorizontalAlignment(SwingConstants.CENTER);
		Grade_2.setBounds(770, 50, 70, 45);
		Grade_2.setOpaque(true);
		Panel.add(Grade_2);
		
		
		Grade_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Grade_3.setBackground(new Color(240, 230, 140));
		Grade_3.setHorizontalAlignment(SwingConstants.CENTER);
		Grade_3.setBounds(770, 100, 70, 45);
		Grade_3.setOpaque(true);
		Panel.add(Grade_3);
		
		
		Grade_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		Grade_4.setBackground(new Color(240, 230, 140));
		Grade_4.setHorizontalAlignment(SwingConstants.CENTER);
		Grade_4.setBounds(770, 150, 70, 45);
		Grade_4.setOpaque(true);
		Panel.add(Grade_4);
	}
	public void task_init() {
		// Init all task label
		
		Task_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Task_1.setHorizontalAlignment(SwingConstants.CENTER);
		Task_1.setBackground(new Color(135, 206, 250));
		Task_1.setBounds(160, 0, 600, 45);
		Task_1.setOpaque(true);
		Panel.add(Task_1);
		
		Task_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Task_2.setHorizontalAlignment(SwingConstants.CENTER);
		Task_2.setBackground(new Color(135, 206, 250));
		Task_2.setBounds(160, 50, 600, 45);
		Task_2.setOpaque(true);
		Panel.add(Task_2);
		
		Task_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Task_3.setHorizontalAlignment(SwingConstants.CENTER);
		Task_3.setBackground(new Color(135, 206, 250));
		Task_3.setBounds(160, 100, 600, 45);
		Task_3.setOpaque(true);
		Panel.add(Task_3);
		
		Task_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Task_4.setHorizontalAlignment(SwingConstants.CENTER);
		Task_4.setBackground(new Color(135, 206, 250));
		Task_4.setBounds(160, 150, 600, 45);
		Task_4.setOpaque(true);
		Panel.add(Task_4);
			
	}
}

