import br.com.cm.modelo.Campo;
import br.com.cm.modelo.Tabuleiro;
import br.com.cm.visao.TabuleiroConsole;

public class Applicacao {

	public static void main(String[] args) {
		
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,3);
		
		new TabuleiroConsole(tabuleiro);
	}
}
