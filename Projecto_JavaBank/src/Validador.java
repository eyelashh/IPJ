import java.util.ArrayList;

public class Validador {

	public Validador() {
		super();
	}

	// UTILIZADORES:

	// cria id de utilizador:
	/**
	 * @param util
	 * @return
	 * 
	 * // cria id de utilizador:
	 */
	protected int ValUtilizadorid(ArrayList<Utilizador> util) {
		int id = 1;
		if (util.size() != 0) {
			id = util.get(util.size() - 1).getIdUtilizador() + 1;
		}
		if (id == 0) {
			id = 1;
		}
		return id;
	}

	// valida nome:
	/**
	 * @param nome
	 * @return
	 * valida nome:
	 */
	protected boolean valNome(String nome) {
		boolean teste = nome.matches("\\p{Upper}(\\p{Lower}+\\s?)");

		return teste;
	}

	// valida apelido
	/**
	 * @param apelido
	 * @return
	 * valida apelido
	 */
	protected boolean valSobrenome(String apelido) {
		boolean teste = apelido.matches("\\p{Upper}(\\p{Lower}+\\s?)");

		return teste;
	}

	

	// valida numero de indentificacao:
	
	/**
	 * @param str
	 * @return
	 * valida numero de indentificacao:
	 */
	protected boolean valNumIdentificacao(String str) {
		boolean teste = str.matches("^\\d+(\\d+)?$");

		if (str.indexOf(".") != -1) {
			teste = false;
		}
		return teste;

	}

	// valida contacto:
	/**
	 * @param contacto
	 * @return
	 * valida contacto
	 */
	protected boolean valContacto(String contacto) {

		boolean teste = contacto.matches("^\\d+(\\d+)?$");

		if (contacto.charAt(0) != '9' && contacto.charAt(0) != '2' && contacto.length() != 9) {

			teste = false;
		}

		return teste;
	}

	// valida username:
	/**
	 * @param user
	 * @param utilizadores
	 * @return
	 * valida username
	 */
	protected boolean valUsername(String user, ArrayList<Utilizador> utilizadores) {
		boolean existe = true;

		if (user.equals("")) {
			existe = false;
		}

		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizadores.get(i).getUsername().equals(user)) {
				existe = false;
			}
		}
		return existe;
	}

	// valida passe
	/**
	 * @param password
	 * @return
	 * valida password
	 */
	protected boolean valPassword(String password) {
		// 8 caracteres com 1 numero e 1 letra

		// boolean valida =
		// password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
		boolean valida = true;
		return valida;
	}

	// valida id funcionario
	
	/**
	 * @param util
	 * @return
	 * cria id funcionario
	 */
	protected int valIdFuncionario(ArrayList<Utilizador> util) {
		int idfun = 0;
		boolean existe = false;

		do {
			do {
				idfun = (int) (Math.random() * 10000);

			} while (idfun < 999);

			for (int i = 0; i < util.size(); i++) {
				if (util.get(i) instanceof Funcionario) {
					if (((Funcionario) util.get(i)).getIdFuncionario() == idfun) {
						existe = true;
					}
				}
			}

		} while (existe);

		return idfun;
	}

	// CARTOES:

	// valida id cartao:
	/**
	 * @param cart
	 * @return
	 * cria id do cartao
	 */
	protected int valIdCartao(ArrayList<Cartao> cart) {

		int idcart = 0;
		boolean existe = false;

		do {
			do {
				idcart = (int) (Math.random() * 10000);

			} while (idcart < 999);

			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getIdconta() == idcart) {
					existe = true;
				}
			}
		} while (existe);

		return idcart;
	}

	// valida titular de cartao:
	/**
	 * @param nome
	 * @return
	 * valida nome no cartao
	 */
	protected boolean valTitularCartao(String nome) {
		boolean teste = nome.matches("\\p{Upper}(\\p{Lower}+\\s?)");

		return teste;

	}

	// valida codigo de validacao cartao()

	/**
	 * @return
	 * cria codigo do cartao
	 */
	protected int valCodCartao() {
		int codval = 0;

		do {
			codval = (int) (Math.random() * 1000);

		} while (codval < 100);

		return codval;
	}

	// CONTAS:

	// valida idconta 
	/**
	 * @param contas
	 * @return
	 * cria id de conta
	 */
	protected int idConta(ArrayList<Conta> contas) {
		int id = 1;
		if (contas.size() != 0) {
			id = contas.get(contas.size() - 1).getIdConta() + 1;
		}
		return id;
	}

	// valida valor max de levantamento por operacao em conta:
	/**
	 * @param valor
	 * @return
	 * valida valor de levantamento de conta
	 */
	protected boolean valVMaxLevConta(String valor) {
		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	// valida valor max levantamento por operacao:
	/**
	 * @param valor
	 * @return
	 *  valida valor de levantamento de conta por operacao
	 */
	protected boolean valVMaxLevContaOP(String valor) {

		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	// valida valor max levantamento por dia:
	protected boolean valVMaxLevContaDia(String valor) {
		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	// CONTA POUPANï¿½A:

	// valida juros
	/**
	 * @param valor
	 * @return
	 * valida juros
	 */
	protected boolean valJuros(String valor) {

		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");
		return teste;
	}

	// valida valor max levantamento por mes:
	/**
	 * @param valor
	 * @return
	 *  valida valor de levantamento de conta por mes
	 */
	protected boolean valVMaxLevContaMes(String valor) {
		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	
	/**
	 * @param valor
	 * @return
	 * valida saldo
	 */
	protected boolean valsaldo(String valor) {
		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	// OPERAï¿½OES:

	// valida valor de operacao:
	/**
	 * @param valor
	 * @return
	 * valida o valor de operaçao
	 */
	protected boolean valValorOperacao(String valor) {
		boolean teste = valor.matches("^\\d+(\\.\\d+)?$");

		return teste;
	}

	// valida conta a transferir:
	
	/**
	 * @param valor
	 * @return
	 * valida valor a transferir
	 */
	protected boolean valContaTransferir(String valor) {
		boolean teste = valor.matches("^\\d+(\\d+)?$");
		return teste;
	}

	// validador de operaï¿½oes:
	/**
	 * @param op
	 * @return
	 * valida id de operaçoes
	 */
	protected int validoperacoes(ArrayList<Operacao> op) {
		int id = 1;
		if (op.size() != 0) {
			id = op.get(op.size() - 1).getIdOperacao() + 1;
		}
		return id;
	}

}
