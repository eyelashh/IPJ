import java.util.ArrayList;

public class Validador {

	public Validador()
	{
		super();
	}
	
		// UTILIZADOR:
	
		// valida nome do Funcionario ou Administrador:
		protected boolean valNome(String nome)
		{
			boolean teste = nome.matches("\\p{Upper}(\\p{Lower}+\\s?)");
			
			return teste;
		}
		
		// valida contacto:
		protected boolean valContacto(String contacto)
		{
			boolean teste=contacto.matches("^[-+]?\\d+(\\d+)?$");
			
			if(contacto.indexOf(".")!=-1 || contacto.charAt(0)!='9' || contacto.charAt(0)!='2' || contacto.length()!=9)
			{
				teste=false;
			}
			
			return teste;
			
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
		
		
		// LIVRO:
		
		// validacao de titulo nao necessario
		
		protected boolean autor(String nome)
		{
			boolean teste = nome.matches("\\p{Upper}(\\p{Lower}+\\s?)");
			
			return teste;
			
		}
		
		protected boolean valPreco(String preco)
		{
			boolean teste=preco.matches("^\\d+(\\d+)?$");
			
			return teste;
			
		}
		
		protected boolean valStock(String stock)
		{
			boolean teste=stock.matches("^\\d+(\\d+)?$");
			
			return teste;
		}
		
		protected boolean valAno(String ano)
		{
			boolean teste=ano.matches("^\\d+(\\d+)?$");
			
			try
			{
			int a = Integer.parseInt(ano);
			
			if(a<0 && a>2019)
			{
				teste = false;
			}
			}
			catch(Exception i)
			{
				teste = false;
			}

			return teste;
		}
		// id de livros nao sei de é necessario;
		
		
		protected boolean valNif()
		{
			
			
			return true;
		}
	
}
