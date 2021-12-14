package beaty;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NumberProcessor {

	private JFrame frame;
	private File numbers;
	private JTextField results;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberProcessor window = new NumberProcessor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NumberProcessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton ChooseFile = new JButton("Choose a file");
		ChooseFile.setBounds(156, 49, 113, 23);
		frame.getContentPane().add(ChooseFile);
		
		ChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Text Files", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " +
							chooser.getSelectedFile().getName());
					numbers = chooser.getSelectedFile(); //the file location is formatted like this: C:\Users\Grace\OneDrive\Desktop\numbers.txt
				}
			}
		});
		
		JButton calculate = new JButton("Do the Thing");
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		calculate.setBounds(156, 83, 113, 23);
		frame.getContentPane().add(calculate);
		
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				calculateTheThings();
			}
		});
		results = new JTextField();
		results.setBounds(30, 138, 375, 93);
		frame.getContentPane().add(results);
		results.setColumns(10);

	}
	
	public void calculateTheThings(){
		ArrayList<Double> nums = new ArrayList<Double>();
		Scanner sc = new Scanner(numbers);
	    while (sc.hasNextLine())
	      nums.add(sc.nextDouble());
	    sc.close();
	    
	    double sum = 0;
	    String numList = "";
	    for(double i: nums) {
	    	sum += i;
	    	numList += i + " ";
	    }
	    double mean = sum/nums.size();
	    double stdDev = (Math.pow(sum - mean, 2)/nums.size());
	    /**
	     * standard deviation = square root of ∑(Xi - ų)2 / N 
              where, 
                Xi = each element of the array
                ų = mean of the elements of the array
                N = Number of elements
                ∑ = Sum of the each element
	     */
	    
	    results.setText("\nThe file contains: \n" + numList + 
	    		"\nThe folliwing calculations were performed\nMean:\n" + mean + 
	    		"\nStandard Deviation:\n" + stdDev + "\n");
	}
}