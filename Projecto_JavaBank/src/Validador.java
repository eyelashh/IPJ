import java.util.ArrayList;
import java.util.regex.*;


public class Validador {
	
	public Validador()
	{
		super();
	}
	
	// UTILIZADORES:
	
	// cria id de utilizador:
	protected int ValUtilizadorid(ArrayList<Utilizador> util)
	{
		int id = 1;
		if(util.size()!=0)
		{
			id = util.get(util.size()-1).getIdUtilizador()+1;
		}
		
		return id;
	}
	
	// valida nome:
	protected boolean valNome(String nome)
	{
		boolean teste = nome.matches("\\p{Upper}(\\p{Lower}+\\s?)");
		
		return teste;
	}
	
	// valida apelido
	protected boolean valSobrenome(String apelido)
	{
		boolean teste = apelido.matches("\\p{Upper}(\\p{Lower}+\\s?)");
		
		return teste;
	}
	
	// valida data: (nao sei se é necessario)
	
	
	// valida numero de indentificaçao:
	protected boolean valNumIdentificacao(String str)
	{
		boolean teste=str.matches("^[-+]?\\d+(\\.\\d+)?$");
		
		if(str.indexOf(".")!=-1)
		{
			teste=false;
		}
		return teste;

	}
	
	// valida contacto:
	protected boolean valContacto(String contacto)
	{
		boolean teste=contacto.matches("^[-+]?\\d+(\\.\\d+)?$");
		
		if(contacto.indexOf(".")!=-1 || contacto.charAt(0)!='9' || contacto.charAt(0)!='2' || contacto.length()!=9)
		{
			teste=false;
		}
		
		return true;
	}
	
	// valida username:
	protected boolean valUsername(String user, ArrayList<Utilizador> utilizadores)
	{
		boolean existe=false;
		
		for(int i=0; i<utilizadores.size();i++)
		{
			if(utilizadores.get(i).getUsername().equals(user))
			{
				existe= true;
			}
		}
		return existe;
	}
	
	// valida passe
	protected boolean valPassword(String password)
	{
		// 8 caracteres com 1 numero e 1 letra
		boolean valida=password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
		
		return valida;
	}
	
	// valida id funcionario
	protected int valIdFuncionario(ArrayList<Utilizador> util)
	{
		int idfun = 0;
		boolean existe=false;
		
		do {
			idfun =(int) (Math.random()*1000);
			
			for(int i=0; i<util.size();i++)
			{
				if(util.get(i) instanceof Funcionario)
				{
					
				}
				
			}
				
		} while(existe);
		
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
