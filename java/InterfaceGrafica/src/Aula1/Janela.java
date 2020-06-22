package Aula1;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Janela extends JFrame {
	private JButton btContinuar, btCancelar;
	private JPanel jpSul, jpNorte, jpCentro;
	private JRadioButton rbMasc, rbFem;
	
	Janela(){
		super ("Cadastro");
	}
	
	public void montarTela(){
		
		Container conteudo = getContentPane();
		
		jpSul = new JPanel();
		FlowLayout fl = (FlowLayout) jpSul.getLayout();
		fl.setAlignment (FlowLayout.RIGHT);
		
		jpNorte = new JPanel();
		FlowLayout fl2 = (FlowLayout) jpNorte.getLayout();
		fl2.setAlignment (FlowLayout.LEFT);
		
		BoxLayout bl = new BoxLayout (jpNorte, BoxLayout.Y_AXIS);
		jpNorte.setLayout(bl);
		
		jpCentro = new JPanel();
		
		
		btContinuar = new JButton ("Continuar");
		btCancelar = new JButton ("Cancelar");
		
		JLabel lbNome = new JLabel ("Nome");
		JTextField tfNome = new JTextField(3);
		
		JLabel lbTel = new JLabel ("Telefone");
		JTextField tfTel = new JTextField(3);
		String Telefone = tfTel.getText();
		
		JLabel lbSexo = new JLabel ("Sexo");
		rbMasc = new JRadioButton ("Masculino");
		rbFem = new JRadioButton ("Feminino");
		ButtonGroup bgSexo = new ButtonGroup();
		bgSexo.add(rbMasc);
		bgSexo.add(rbFem);
		
		
		jpSul.add(btContinuar);
		jpSul.add(btCancelar);
		jpNorte.add(lbNome);
		jpNorte.add(tfNome);
		jpNorte.add(lbTel);
		jpNorte.add(tfTel);
		jpCentro.add(lbSexo);
		jpCentro.add(rbMasc);
		jpCentro.add(rbFem);
		
		conteudo.add(jpSul, BorderLayout.SOUTH);
		conteudo.add(jpNorte, BorderLayout.NORTH);
		conteudo.add(jpCentro, BorderLayout.CENTER);
		
		setSize (600,400);
		setResizable (true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
}