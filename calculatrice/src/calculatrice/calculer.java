package calculatrice;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculer implements ActionListener {
	JFrame frame;
	JTextField textfield;// j'ai déclaré ma variable txt field

	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[8];// 9 : le nombre de buttons qui ne contiennent pas de chiffres

	JButton plusButton, moinsButton, mulButton, clrButton, negButton, divButton, egButton, verButton;
	JPanel panel;

	double num1 = 0, num2 = 0, result = 0;
	char op;

	Font myFont = new Font("Ink Free", Font.BOLD, 30);

	calculer() {
		frame = new JFrame("Calculatrice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // le button pour fermer l'app
		frame.setSize(420, 550); // dim d'écritures
		frame.setLayout(null); // pour que chaque button prends sa place
		textfield = new JTextField(0); // j'affiche 0 :)
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);

		plusButton = new JButton("+");
		moinsButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		clrButton = new JButton("C");
		egButton = new JButton("=");
		verButton = new JButton(".");
		negButton = new JButton("'-'");

		functionButton[0] = plusButton; // on affecte des vals au tableau des buttons : functionButton
		functionButton[1] = moinsButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = clrButton;
		functionButton[5] = egButton;
		functionButton[6] = verButton;
		functionButton[7] = negButton;

		for (int i = 0; i < 8; i++) // une boucle pour parcourir mon tableau de button : functionButton
		{
			functionButton[i].addActionListener(this); // j'ai crée un Listner pour chaque button
			functionButton[i].setFont(myFont);// pour changer la couleur de mon button
			functionButton[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) // pour déclarer les buttons des nombres
		{
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this); // j'ajoute un Listner pour le button
			numberButton[i].setFocusable(false);

		}

		clrButton.setBounds(150, 430, 50, 50);
		egButton.setBounds(250, 430, 50, 50);
		negButton.setBounds(50, 430, 100, 50); // je donne des dimensions a mes buttons

		// Attention !! je dois revenir mettre en forme correctement les dim des buttons

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));// espace entre pannel de l'affochage du resultat et des nombres

		panel.add(numberButton[1]); // j'ajoute les nombres au panel :D
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(plusButton);
		// Attention je dois revenir re-structurer les buttons comme dans l'ex demandé
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(moinsButton);
		panel.add(mulButton);
		panel.add(divButton);
		panel.add(numberButton[0]);
		panel.add(clrButton);
		panel.add(egButton);
		panel.add(verButton);
		panel.add(negButton);

		frame.add(panel); // et la j'ajoute panel dans la Frame
		frame.add(plusButton);
		frame.add(moinsButton);
		frame.add(mulButton);
		frame.add(divButton);
		frame.add(clrButton);
		frame.add(egButton);
		frame.add(verButton);
		frame.add(negButton);
		frame.add(textfield);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButton[i]) // on récupère la valeur et on va les convertir
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));

			}
		}
		if (e.getSource() == verButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == plusButton) {
			num1 = Double.parseDouble(textfield.getText());// je récupèrre le 1 er numéro tapé sur ma calc et je le
															// convertis en double et je l'affecte a num1
			op = '+';
			textfield.setText("");
		}
		if (e.getSource() == moinsButton) {
			num1 = Double.parseDouble(textfield.getText());
			op = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			op = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			op = '/';
			textfield.setText("");
		}

		// et la après que l'utilisateur ai tapé son 1 er nombre nous allons récupérer
		// le 2 eme et le convertir en double

		if (e.getSource() == egButton) {
			num2 = Double.parseDouble((textfield.getText()));

			// après avoir récupérer le 2 eme nombre on va faire le calcul

			switch (op) {
			case '+':
				result = num1 + num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}

			// ici notre résultat est en Double on doit le changer en string pour l'afficher
			// dans mon textfield

			textfield.setText(String.valueOf(result));
			num1 = result; // ici je stock le résultat

		}

		// la condition pour mon button clear

		if (e.getSource() == clrButton) {
			textfield.setText("");// c'est pour changer ce qui est affiché dans le textfiend
		}

		// le button negatif
		if (e.getSource() == negButton) {
			double tempo = Double.parseDouble(textfield.getText());
			tempo = tempo * -1;
			textfield.setText(String.valueOf(tempo));

		}

	}
}