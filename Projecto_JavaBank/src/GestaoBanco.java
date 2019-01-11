import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestaoBanco implements Serializable{

	Banco javabank;
	private File fileUtil;
	private File fileContas;
	private File fileCartao;
	private ObjectInputStream iS;
	private ObjectOutputStream oS;

	// Construtor:
	public GestaoBanco() {
		// INICIALIZA O BANCO:
		this.javabank = new Banco();
		iS = null;
		// CRIA FICHEIROS:
		this.fileUtil = new File("fileUtil.dat");
		this.fileContas = new File("fileContas.dat");
		this.fileCartao = new File("fileCartao.dat");

	}

	@SuppressWarnings("unchecked")
	protected void run() {

		// FICHEIRO DE UTILIZADORES:
		//
		//
		//
		// Caso nao exista um ficheiro de utilizadores � criado 3 users por defeito!
		if (!this.fileUtil.exists()) {
			Utilizador adm = new Administrador(-1, "Administrador", "Master", Date.valueOf(LocalDate.now()), "CC", 0,
					"DEI", 910000000, "admin", "admin");
			Utilizador fun = new Funcionario(-2, "Funcionario", "Master", Date.valueOf(LocalDate.now()), "CC", 0, "DEI",
					910000000, "funcionario", "funcionario", -2);
			Utilizador clt = new Cliente(-3, "Cliente", "Master", Date.valueOf(LocalDate.now()), "CC", 0, "DEI",
					910000000, "cliente", "cliente",0);

			javabank.addUtilizador(clt);
			javabank.addUtilizador(fun);
			javabank.addUtilizador(adm);

			// De seguida � efectuada a cria�ao do ficheiro:
			try {
				this.fileUtil.createNewFile();
				oS = new ObjectOutputStream(new FileOutputStream(this.fileUtil));
				oS.writeObject(javabank.getUtlizadores());
				oS.close();
			} catch (IOException e) {

			}
		}
		// caso de ja existir ficheiro transfere os ficheiros o arraylist de
		// funcionarios:
		else {
			try {
				this.iS = new ObjectInputStream(new FileInputStream(this.fileUtil));
				try {
					this.javabank.setUtlizadores((ArrayList<Utilizador>) iS.readObject());
					iS.close();
				} catch (ClassNotFoundException y) {

				}
			} catch (IOException e) {

			}
		}

		// Agora para as contas:

		// CASO NAO EXISTA FICHEIRO � CRIADO:
		if (!this.fileContas.exists()) {

			try {
				this.fileContas.createNewFile();
				this.oS = new ObjectOutputStream(new FileOutputStream(this.fileContas));
				oS.writeObject(javabank.getContas());
				oS.close();
			} catch (IOException e) {

			}
		}
		// caso ja exista vou passar a informa�ao do ficheiro para a classe:
		else {

			try {
				this.iS = new ObjectInputStream(new FileInputStream(this.fileContas));
				try {
					this.javabank.setContas((ArrayList<Conta>) iS.readObject());
					iS.close();
				} catch (ClassNotFoundException y) {

				}
			} catch (IOException e) {

			}

		}

		// Para o cartao:

		if (!this.fileCartao.exists()) {
			try {
				this.fileCartao.createNewFile();
				this.oS = new ObjectOutputStream(new FileOutputStream(this.fileCartao));
				oS.writeObject(javabank.getCartoes());
				oS.close();
			} catch (IOException e) {

			}
		} else
			try {
				
					this.iS = new ObjectInputStream(new FileInputStream(this.fileCartao));
					try {
						this.javabank.setCartoes((ArrayList<Cartao>) iS.readObject());
						iS.close();
					} catch (ClassNotFoundException y) {

					}
				
			} catch (IOException e) {

			}

	}

	// metedo que guarda os ficheiros:
	// este metedo � chamado quando qualquer uma das janelas tipo adm/clt/fun sao
	// fechadas ou efectuado logout.
	protected void atualizaficheiro(ArrayList<Utilizador> util, ArrayList<Conta> conta, ArrayList<Cartao> cartao) {
		try {
			oS = new ObjectOutputStream(new FileOutputStream(this.fileUtil));
			oS.writeObject(util);
			oS.close();
		} catch (IOException e) {

		}

		try {
			oS = new ObjectOutputStream(new FileOutputStream(this.fileContas));
			oS.writeObject(conta);
			oS.close();

		} catch (IOException e) {

		}

		try {
			oS = new ObjectOutputStream(new FileOutputStream(this.fileCartao));
			oS.writeObject(cartao);
			oS.close();

		} catch (IOException e) {

		}

	}

}
