
public class Validador {
	
	public Validador()
	{
		super();
	}
	
	// UTILIZADORES:
	
	// cria id de utilizador:
	protected int ValUtilizadorid()
	{
		return 0;
	}
	
	// valida nome:
	protected boolean valNome()
	{
		
		return true;
	}
	
	// valida apelido
	protected boolean valSobrenome()
	{
		return true;
	}
	
	// valida data:
	protected boolean valDataNasc()
	{
	
		return true;
	}
	
	// valida numero de indentificaçao:
	protected boolean valNIdentificacao()
	{
		return true;
	}
	
	// valida contacto:
	protected boolean valContacto()
	{
		return true;
	}
	
	// valida username:
	protected boolean valUsername()
	{
		return true;
	}
	
	// valida passe
	protected boolean valPassword()
	{
		return true;
	}
	
	// valida id funcionario
	protected int valIdFuncionario()
	{
		return 0;
	}
	
	
	
	
	
	// CARTOES:
	
	// valida id cartao:
	protected int valIdCartao()
	{
		return 0;
	}
	
	// valida titular de cartao:
	protected boolean valTitularCartao()
	{
		return true;
		
	}
	
	// valida codigo de validacao cartao()
	
	protected int valCodCartao()
	{
		return 0;
	}
	
	
	
	// CONTAS:
	
	// valida idconta (ainda é necessario ver se é necessario)
	protected int idConta()
	{
		return 0;
	}
	
	
	// valida valor max de levantamento por operacao em conta:
	protected boolean valVMaxLevConta()
	{
		return true;
	}
	
	// valida valor max levantamento por operacao:
	protected boolean valVMaxLevContaOP()
	{
		return true;
	}
	
	// valida valor max levantamento por dia:
	protected boolean valVMaxLevContaDia()
	{
		return true;
	}
	
	
	
	
	// CONTA POUPANÇA:
	
	// valida juros
	protected boolean valJuros()
	{
		
		return true;
	}
	
	// valida valor max levantamento por mes:
	protected boolean valVMaxLevContaMes()
	{
		return true;
	}
	
	// OPERAÇOES:
	
	// valida valor de operacao:
	protected boolean valValorOperacao()
	{
		return true;
	}
	
	// valida conta a transferir:
	protected boolean valContaTransferir()
	{
		return true;
	}
	
	

}
