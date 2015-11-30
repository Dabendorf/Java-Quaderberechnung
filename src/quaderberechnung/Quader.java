package quaderberechnung;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

/**
 * Dies ist die einzige Klasse des Quaderprojektes, welche sowohl die Rechenalgorithmen als auch das Design steuert.
 * 
 * @author Lukas Schramm
 * @version 1.0
 * 
 */
public class Quader {

	private JFrame frame1 = new JFrame("Quaderberechnung");
	private NumberFormat format1 = NumberFormat.getInstance(); 
	private NumberFormat format2 = NumberFormat.getInstance();
	private NumberFormat format3 = NumberFormat.getInstance();
	private NumberFormatter formatter1 = new NumberFormatter(format1);
    private NumberFormatter formatter2 = new NumberFormatter(format2);
    private NumberFormatter formatter3 = new NumberFormatter(format3);
	private JFormattedTextField feldSeiteA = new JFormattedTextField(formatter1);
	private JFormattedTextField feldSeiteB = new JFormattedTextField(formatter2);
	private JFormattedTextField feldSeiteC = new JFormattedTextField(formatter3);
	private JButton buttonRechnen = new JButton("Berechne");
	private JLabel labelSeiteA = new JLabel(" Breite:");
	private JLabel labelSeiteB = new JLabel(" Tiefe");
	private JLabel labelSeiteC = new JLabel(" Höhe:");
	private JLabel labelLE1 = new JLabel("LE");
	private JLabel labelLE2 = new JLabel("LE");
	private JLabel labelLE3 = new JLabel("LE");
	private JLabel labelVolumen = new JLabel();
	private JLabel labelOberflaeche = new JLabel();
	private JLabel labelKantenlaenge = new JLabel();
	private JLabel labelGrundflaeche = new JLabel();
	private JLabel labelRaumdiagonale = new JLabel();
	
	public Quader() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(400,200));
		frame1.setMinimumSize(new Dimension(400,200));
		frame1.setMaximumSize(new Dimension(600,400));
		frame1.setResizable(true);
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridBagLayout());
		
		JPanel paneleingabe = new JPanel();
		paneleingabe.setLayout(new GridBagLayout());
		JPanel paneleingabelinks = new JPanel();
		paneleingabelinks.setLayout(new GridBagLayout());
		paneleingabelinks.add(labelSeiteA,new GridBagFelder(0,0,1,1,0.3,0.33));
		paneleingabelinks.add(feldSeiteA,new GridBagFelder(1,0,1,1,0.5,0.33));
		paneleingabelinks.add(labelLE1,new GridBagFelder(2,0,1,1,0.2,0.33));
		paneleingabelinks.add(labelSeiteB,new GridBagFelder(0,1,1,1,0.3,0.33));
		paneleingabelinks.add(feldSeiteB,new GridBagFelder(1,1,1,1,0.5,0.33));
		paneleingabelinks.add(labelLE2,new GridBagFelder(2,1,1,1,0.2,0.33));
		paneleingabelinks.add(labelSeiteC,new GridBagFelder(0,2,1,1,0.3,0.33));
		paneleingabelinks.add(feldSeiteC,new GridBagFelder(1,2,1,1,0.5,0.33));
		paneleingabelinks.add(labelLE3,new GridBagFelder(2,2,1,1,0.2,0.33));
		
		paneleingabe.add(paneleingabelinks,new GridBagFelder(0,0,1,1,0.7,1));
		paneleingabe.add(buttonRechnen,new GridBagFelder(1,0,1,1,0.3,1));
		paneleingabelinks.setPreferredSize(new Dimension(0,0));
		buttonRechnen.setPreferredSize(new Dimension(0,0));
		
		JPanel panelausgabe = new JPanel();
		panelausgabe.setLayout(new GridBagLayout());
		JLabel nameVolumen = new JLabel(" Volumen:");
		JLabel nameOberflaeche = new JLabel(" Oberflächeninhalt:");
		JLabel nameKantenlaenge = new JLabel(" Kantenlänge:");
		JLabel nameGrundflaeche = new JLabel(" Grundfläche:");
		JLabel nameRaumdiagonale = new JLabel(" Raumdiagonale:");
		panelausgabe.add(nameVolumen,new GridBagFelder(0,0,1,1,0.4,0.2));
		panelausgabe.add(labelVolumen,new GridBagFelder(1,0,1,1,0.6,0.2));
		panelausgabe.add(nameOberflaeche,new GridBagFelder(0,1,1,1,0.4,0.2));
		panelausgabe.add(labelOberflaeche,new GridBagFelder(1,1,1,1,0.6,0.2));
		panelausgabe.add(nameKantenlaenge,new GridBagFelder(0,2,1,1,0.3,0.2));
		panelausgabe.add(labelKantenlaenge,new GridBagFelder(1,2,1,1,0.7,0.2));
		panelausgabe.add(nameGrundflaeche,new GridBagFelder(0,3,1,1,0.4,0.2));
		panelausgabe.add(labelGrundflaeche,new GridBagFelder(1,3,1,1,0.6,0.2));
		panelausgabe.add(nameRaumdiagonale,new GridBagFelder(0,4,1,1,0.4,0.2));
		panelausgabe.add(labelRaumdiagonale,new GridBagFelder(1,4,1,1,0.6,0.2));
		
		nameVolumen.setPreferredSize(new Dimension(0,0));
		labelKantenlaenge.setPreferredSize(new Dimension(0,0));
		nameOberflaeche.setPreferredSize(new Dimension(0,0));
		labelGrundflaeche.setPreferredSize(new Dimension(0,0));
		nameKantenlaenge.setPreferredSize(new Dimension(0,0));
		labelRaumdiagonale.setPreferredSize(new Dimension(0,0));
		nameGrundflaeche.setPreferredSize(new Dimension(0,0));
		labelOberflaeche.setPreferredSize(new Dimension(0,0));
		nameRaumdiagonale.setPreferredSize(new Dimension(0,0));
		labelVolumen.setPreferredSize(new Dimension(0,0));
		
	    feldSeiteA.setText("");
	    feldSeiteB.setText("");
	    feldSeiteC.setText("");
	    feldSeiteA.setHorizontalAlignment(SwingConstants.RIGHT);
	    feldSeiteB.setHorizontalAlignment(SwingConstants.RIGHT);
	    feldSeiteC.setHorizontalAlignment(SwingConstants.RIGHT);
	    labelKantenlaenge.setHorizontalAlignment(SwingConstants.LEFT);
	    labelGrundflaeche.setHorizontalAlignment(SwingConstants.LEFT);
	    labelRaumdiagonale.setHorizontalAlignment(SwingConstants.LEFT);
	    labelOberflaeche.setHorizontalAlignment(SwingConstants.LEFT);
	    labelVolumen.setHorizontalAlignment(SwingConstants.LEFT);
	    buttonRechnen.setMargin(new Insets(2, 2, 2, 2));
	    buttonRechnen.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent evt) { 
	    		berechnen();
	    	}
	    });
	    
	    format1.setGroupingUsed(false);
	    format2.setGroupingUsed(false);
	    format3.setGroupingUsed(false);
	    formatter1.setAllowsInvalid(false);
	    formatter2.setAllowsInvalid(false);
	    formatter3.setAllowsInvalid(false);
	    
	    frame1.add(paneleingabe,new GridBagFelder(0,0,1,1,1,0.5));
	    frame1.add(panelausgabe,new GridBagFelder(0,1,1,1,1,0.5));
	    paneleingabe.setPreferredSize(new Dimension(0,0));
	    panelausgabe.setPreferredSize(new Dimension(0,0));
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode liest die Strings ein, loest die Gleichungen und gibt die Ergebnisse aus.<br>
	 * Das Einlesen von Kommazahlen geht etwas komplizierter von statten, weil Java zu bloed dafuer ist.
	 */
	private void berechnen() {
		try {
			String stra[] = feldSeiteA.getText().split(",");
			String strb[] = feldSeiteB.getText().split(",");
			String strc[] = feldSeiteC.getText().split(",");
			double seitea;
			double seiteb;
			double seitec;
			if(stra.length==1) {
				seitea = Double.valueOf(stra[0]);
			} else {
				seitea = Double.valueOf(stra[0])+Double.valueOf(stra[1])/Math.pow(10,stra[1].length());
			}
			if(strb.length==1) {
				seiteb = Double.valueOf(strb[0]);
			} else {
				seiteb = Double.valueOf(strb[0])+Double.valueOf(strb[1])/Math.pow(10,strb[1].length());
			}
			if(strc.length==1) {
				seitec = Double.valueOf(strc[0]);
			} else {
				seitec = Double.valueOf(strc[0])+Double.valueOf(strc[1])/Math.pow(10,strc[1].length());
			}
			if(seitea<0 || seiteb<0 || seitec<0) {
				JOptionPane.showMessageDialog(null, "Du hast negative Werte eingetragen."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
			} else {
				double volumen = seitea*seiteb*seitec;
				double oberflaeche = 2*seitea*seiteb + 2*seiteb*seitec + 2*seitea*seitec;
				double kantenlaenge = 4*(seitea+seiteb+seitec);
				double grundflaeche = seitea*seiteb;
				double raumdiagonale = Math.sqrt(Math.pow(seitea,2)+Math.pow(seiteb,2)+Math.pow(seitec,2));
				
				labelVolumen.setText(Math.round(volumen*1000)/1000.0+" VE");
				labelOberflaeche.setText(Math.round(oberflaeche*1000)/1000.0+" FE");
			    labelKantenlaenge.setText(Math.round(kantenlaenge*1000)/1000.0+" LE");
			    labelGrundflaeche.setText(Math.round(grundflaeche*1000)/1000.0+" FE");
			    labelRaumdiagonale.setText(Math.round(raumdiagonale*1000)/1000.0+" LE");
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Du hast falsche Werte eingetragen."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Ergebnis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new Quader();
	}
}