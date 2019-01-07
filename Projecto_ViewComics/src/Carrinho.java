import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

public class Carrinho implements Serializable {

	private String nif;
	private double montante;
	private boolean finalizado;
	private HashMap<Integer, Integer> conteudo;

	public Carrinho() {
		super();
	}

	public Carrinho(String nif, double montante, boolean finalizado, HashMap<Integer, Integer> compras) {
		super();
		this.nif = nif;
		this.montante = montante;
		this.finalizado = finalizado;

		// hashMap(int idLivro, int quantidade)
		this.conteudo = new HashMap<Integer, Integer>();

	}

	// construtor com nif para criar automaticamente o carrinho assim que o cliente
	// ou func insere o nif
	public Carrinho(String nif) {
		super();
		this.nif = nif;
		this.conteudo = new HashMap<Integer, Integer>();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(double montando) {
		this.montante = montando;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public HashMap<Integer, Integer> getConteudo() {
		return conteudo;
	}

	public void setConteudo(HashMap<Integer, Integer> conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return nif;
	}

	public void updateCarrinho(int idLivro, int quantidade) {

		if (this.conteudo.containsKey(idLivro)) {
			this.conteudo.replace(idLivro, quantidade);
			JOptionPane.showMessageDialog(null, "A quantidade do livro no carrinho foi alterada com sucesso");
		} else {
			this.conteudo.put(idLivro, quantidade);
			JOptionPane.showMessageDialog(null,
					"O livro escolhido e a respectiva quantidade foram adicionados ao carrinho");
		}

	}

	public int quantidadeLivro(int idLivro) {

		int quantidade = 0;

		if (this.conteudo.containsKey(idLivro)) {
			quantidade = this.conteudo.get(idLivro);

		} else {
			quantidade = 0;

		}
		
		
		return quantidade;

	}

//	public String[] listaCarrinho2() {
//
//		ArrayList<String> listaC = new ArrayList<String>();
//		
//        // Loop over String keys.
//		for (Entry<Integer, Integer> pair : this.conteudo.entrySet()) {
//            
//			String c = pair.getKey() + "::" + pair.getValue();
//			listaC.add(c);
//		}
//		String[] listaCar = new String[listaC.size()];
//		listaCar= listaC.toArray(listaCar);
//		
//	     return listaCar;
//	  }

}
