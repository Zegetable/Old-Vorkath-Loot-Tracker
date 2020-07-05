
import java.awt.event.*;
import java.awt.*;
import java.io.*;

import javax.swing.*;



public class VorkathLootTrackerBack extends JFrame implements ActionListener {

	private JPanel backPanel, entryPanel, eep, radioPanel, statPanel;
	private JLabel valueLabel, isShitter, isUnique, spaceLabel;
	private JTextField lootValueField;
	private JButton addValue;
	private JRadioButton sYes, sNo, uYes, uNo;
	private JLabel statsLabel, totalGP, totalKC, avgGP, numUni, numShit;
	private String sum, avg,kc,uniques,shitters;
	private ButtonGroup ubg, sbg;
	
	
	VorkathLootTrackerBack() throws IOException{
		
		
		//gettign initial values from files
		//sum
		FileInputStream fs= new FileInputStream("vorkathSum.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		sum = br.readLine();
		br.close();
		fs.close();
		//avg
		fs= new FileInputStream("vorkathAvg.txt");
		br = new BufferedReader(new InputStreamReader(fs));
		avg = br.readLine();
		br.close();
		fs.close();
		//kc
		fs= new FileInputStream("vorkathKc.txt");
		br = new BufferedReader(new InputStreamReader(fs));
		kc = br.readLine();
		br.close();
		fs.close();
		//uniques
		fs= new FileInputStream("vorkathUniques.txt");
		br = new BufferedReader(new InputStreamReader(fs));
		uniques = br.readLine();
		br.close();
		fs.close();
		//shitters
		fs= new FileInputStream("vorkathShit.txt");
		br = new BufferedReader(new InputStreamReader(fs));
		shitters = br.readLine();
		br.close();
		fs.close();
		
		
		
		
		//start interface!
		backPanel = new JPanel();
		add(backPanel);
		backPanel.setLayout(new GridBagLayout());
		GridBagConstraints backGBC = new GridBagConstraints();
		backGBC.gridy = 0;
		backGBC.gridx = 0;
		//backGBC.gridheight = 6;
		backGBC.fill = GridBagConstraints.HORIZONTAL;
		backGBC.insets = new Insets(4,4,4,4);
		
		
		//start entry panel
		entryPanel = new JPanel();
		backPanel.add(entryPanel,backGBC);
		entryPanel.setLayout(new GridBagLayout());
		GridBagConstraints entryGBC = new GridBagConstraints();
		entryGBC.fill = GridBagConstraints.HORIZONTAL;
		entryGBC.insets = new Insets(3,4,3,4);
		entryGBC.gridy = 0;
		entryGBC.gridx = 0;
		entryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//top half entryPanel
		eep = new JPanel();
		entryPanel.add(eep,backGBC);
		eep.setLayout(new GridBagLayout());
		GridBagConstraints eepGBC = new GridBagConstraints();
		eepGBC.fill = GridBagConstraints.HORIZONTAL;
		eepGBC.insets = new Insets(3,4,3,4);
		eepGBC.gridy = 0;
		eepGBC.gridx = 0;
		
		valueLabel = new JLabel("Value: ");
		eep.add(valueLabel, eepGBC);
		eepGBC.gridy = 1;//(+1)
		lootValueField = new JTextField("gp value?", 8);
		eep.add(lootValueField, eepGBC);
		
		eepGBC.gridheight = 2;
		eepGBC.gridy = 0;//(1-)
		eepGBC.gridx = 1;//(1+)
		addValue = new JButton("Add");
		addValue.setMargin(new Insets(5,14,5,14));
		eep.add(addValue, eepGBC);
		eepGBC.gridheight = 1;//normalized
		
		//start radio buttons
		entryGBC.gridy = 1;
		//entryGBC.gridwidth = 2;
		radioPanel = new JPanel();
		entryPanel.add(radioPanel,entryGBC);
		radioPanel.setLayout(new GridBagLayout());
		GridBagConstraints radioGBC = new GridBagConstraints();
		radioGBC.fill = GridBagConstraints.HORIZONTAL;
		radioGBC.insets = new Insets(1,1,0,4);
		radioGBC.gridy = 0;
		radioGBC.gridx = 0;
		
		
		isShitter = new JLabel("Shit?");
		radioPanel.add(isShitter, radioGBC);
		
		radioGBC.gridy = 0;//(0)
		radioGBC.gridx = 1;//(1+)
		isUnique = new JLabel("Unique?");
		radioPanel.add(isUnique, radioGBC);
		
		
		radioGBC.gridy = 1;//(1+)
		radioGBC.gridx = 0;//(1-)
		sYes = new JRadioButton("Yes");
		radioPanel.add(sYes, radioGBC);
		radioGBC.gridy = 2;//(1+)
		radioGBC.gridx = 0;//(0)
		sNo = new JRadioButton("No");
		radioPanel.add(sNo, radioGBC);
		
		radioGBC.gridy = 1;//(1-)
		radioGBC.gridx = 1;//(1+)
		uYes = new JRadioButton("Yes");
		radioPanel.add(uYes, radioGBC);
		radioGBC.gridy = 2;//(1+)
		radioGBC.gridx = 1;//(0)
		uNo = new JRadioButton("No");
		radioPanel.add(uNo, radioGBC);
		radioGBC.gridy = 0;//(1+)
		radioGBC.gridx = 2;
		spaceLabel = new JLabel("         ");
		radioPanel.add(spaceLabel, radioGBC);
		ubg = new ButtonGroup();
		ubg.add(uYes);
		ubg.add(uNo);
		sbg = new ButtonGroup();
		sbg.add(sYes);
		sbg.add(sNo);
		
		//start stat panel
		entryGBC.gridy = 3;
		statPanel = new JPanel();
		entryPanel.add(statPanel, entryGBC);
		statPanel.setLayout(new GridBagLayout());
		GridBagConstraints statGBC = new GridBagConstraints();
		statGBC.gridy = 0;
		statGBC.gridx = 0;
		statGBC.insets = new Insets(6,3,6,3);
		statsLabel = new JLabel("Stats: ");
		//private JLabel statsLabel, totalGP, totalKC, avgGP, numUni, numShit;
		totalGP = new JLabel("total gp earned: "+ sum);
		statPanel.add(totalGP, statGBC);
		statGBC.gridy = 1;//+1
		avgGP = new JLabel("Avg gp earned: "+ avg);
		statPanel.add(avgGP, statGBC);
		statGBC.gridy = 2;//+1
		totalKC = new JLabel("Total kills: "+ kc);
		statPanel.add(totalKC, statGBC);
		statGBC.gridy = 3;//+1
		numUni = new JLabel("Uniques dropped: " +uniques);
		statPanel.add(numUni, statGBC);
		statGBC.gridy = 4;//+1
		numShit = new JLabel("Shitters dropped: "+ shitters);
		statPanel.add(numShit, statGBC);
		
		
		addValue.addActionListener(this);
		
		
	}
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addValue){
			
			try{
				//increment values if necessary
				//sum
				FileInputStream fs= new FileInputStream("vorkathSum.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				sum = Integer.toString(Integer.parseInt(lootValueField.getText())+Integer.parseInt(sum));
				br.close();
				fs.close();
				totalGP.setText("total gp earned: "+ sum);
				File oldFile = new File("oldname.txt");
	            File myMedF = new File("vorkathSum.txt");
	            myMedF.createNewFile();
	            if(myMedF.renameTo(oldFile)){
	            	System.out.println("renamed old sum file!");
	            } else {
	            	System.out.println("not fixed a file!");
	            }
	            //delete old file
	            oldFile.delete();
	            //write new file with correct name
	            myMedF.createNewFile();
	            Writer output;
	            output = new BufferedWriter(new FileWriter("vorkathSum.txt", true));
	            output.append(sum+"\r\n");
	            output.close();
	            
	            
	          //kc (before avg because needed for calc
				fs= new FileInputStream("vorkathKc.txt");
				br = new BufferedReader(new InputStreamReader(fs));
				kc = Integer.toString(Integer.parseInt(br.readLine())+1);
				br.close();
				fs.close();
				totalKC.setText("Total kills: "+ kc);
				oldFile = new File("oldname.txt");
	            myMedF = new File("vorkathKc.txt");
	            myMedF.createNewFile();
	            myMedF.renameTo(oldFile);
	            //delete old file
	            oldFile.delete();
	            //write new file with correct name
	            myMedF.createNewFile();
	            output = new BufferedWriter(new FileWriter("vorkathKc.txt", true));
	            output.append(kc+"\r\n");
	            output.close();
				
	            
				//avg
				
				fs= new FileInputStream("vorkathAvg.txt");
				br = new BufferedReader(new InputStreamReader(fs));
				avg = (Integer.toString((Integer.parseInt(sum)/Integer.parseInt(kc))));
				br.close();
				fs.close();
				avgGP.setText("Avg gp earned: "+ avg);
				oldFile = new File("oldname.txt");
	            myMedF = new File("vorkathAvg.txt");
	            myMedF.createNewFile();
	            myMedF.renameTo(oldFile);
	            //delete old file
	            oldFile.delete();
	            //write new file with correct name
	            myMedF.createNewFile();
	            output = new BufferedWriter(new FileWriter("vorkathAvg.txt", true));
	            output.append(avg+"\r\n");
	            output.close();
      
				
				//uniques
				if(uYes.isSelected()){
					fs= new FileInputStream("vorkathUniques.txt");
					br = new BufferedReader(new InputStreamReader(fs));
					uniques = Integer.toString(Integer.parseInt(br.readLine())+1);
					br.close();
					fs.close();
					numUni.setText("Uniques dropped: "+ uniques);
					oldFile = new File("oldname.txt");
		            myMedF = new File("vorkathUniques.txt");
		            myMedF.createNewFile();
		            myMedF.renameTo(oldFile);
		            //delete old file
		            oldFile.delete();
		            //write new file with correct name
		            myMedF.createNewFile();
		            output = new BufferedWriter(new FileWriter("vorkathUniques.txt", true));
		            output.append(uniques+"\r\n");
		            output.close();
				}
				
				//shitters
				if(sYes.isSelected()){
					fs= new FileInputStream("vorkathShit.txt");
					br = new BufferedReader(new InputStreamReader(fs));
					shitters = Integer.toString(Integer.parseInt(br.readLine())+1);
					br.close();
					fs.close();
					numShit.setText("Shitters dropped: "+ shitters);
					oldFile = new File("oldname.txt");
		            myMedF = new File("vorkathShit.txt");
		            myMedF.createNewFile();
		            myMedF.renameTo(oldFile);
		            //delete old file
		            oldFile.delete();
		            //write new file with correct name
		            myMedF.createNewFile();
		            output = new BufferedWriter(new FileWriter("vorkathShit.txt", true));
		            output.append(shitters+"\r\n");
		            output.close();
				}
				//clear button selections
				sbg.clearSelection();
				ubg.clearSelection();
			}
			catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
}
