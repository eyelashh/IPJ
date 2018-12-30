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

public class GestaoLivraria implements Serializable{
	//meti privado em vez de publico como no banco
	Livraria viewComics;
	private File fileUtilizadores;
	private File fileCarrinhos;
	private File fileLivros;
	private ObjectInputStream iS;
	private ObjectOutputStream oS;
	
	// Construtor:
	public GestaoLivraria() {
		// INICIALIZA O A LIVRARIA:
		this.viewComics = new Livraria();
		iS = null;
		// CRIA FICHEIROS:
		this.fileUtilizadores = new File("fileUtilizadores.dat");
		this.fileCarrinhos = new File("fileCarrinhos.dat");
		this.fileLivros = new File("fileLivros.dat");
	}
	

	public Livraria getViewComics() {
		return viewComics;
	}


	public void setViewComics(Livraria viewComics) {
		this.viewComics = viewComics;
	}


	//METODO RUN()  INCLUI AUTOMATICAMENTE LEITURA E CRIACAO DOS FICHEIROS
	@SuppressWarnings("unchecked")
	protected void run()
	{
		
		//UTILIZADORES
		// CASO 1--> � criado 1 admin e 1 funcionario
		if(!this.fileUtilizadores.exists())
		{
			Utilizador adm = new Administrador(-1,"Admin_nome",96666666,"admin","admin"); 
			Utilizador fun = new Funcionario(-2,"Func_nome",93333333,"func","func");
			viewComics.addUtilizador(adm);
			viewComics.addUtilizador(fun);
			
			// De seguida � efectuada a cria�ao do ficheiro:
			try
			{
				this.fileUtilizadores.createNewFile();
				oS = new ObjectOutputStream(new FileOutputStream(this.fileUtilizadores));
				oS.writeObject(viewComics.getUtilizadores());
				oS.close();
			}
			catch(IOException e)
			{
				
			}
		}
		//CASO 2:FICHEIRO EXISTE ---> ler o ficheiro existente
		else
		{
			try
			{
				this.iS = new ObjectInputStream(new FileInputStream(this.fileUtilizadores));
				try
				{
					this.viewComics.setUtilizadores((ArrayList<Utilizador>) iS.readObject()); 
					iS.close();
				}
				catch(ClassNotFoundException y)
				{
					
				}
			}
			catch(IOException e)
			{
				
			}
		}
		
		// CARRINHOS
		// CASO 1: FICHEIRO NAO EXISTE--->crio um novo ficheiro
		if(!this.fileCarrinhos.exists())
		{
			try
			{
				this.fileCarrinhos.createNewFile();
				this.oS = new ObjectOutputStream(new FileOutputStream(this.fileCarrinhos));
				oS.writeObject(viewComics.getCarrinhos());
				oS.close();
			}
			catch(IOException e)
			{
				
			}	
		}
		//CASO 2:FICHEIRO EXISTE --> ler o ficheiro 
		else
		{
			
			try
			{
				this.iS = new ObjectInputStream(new FileInputStream(this.fileCarrinhos));
				try
				{
					this.viewComics.setCarrinhos((ArrayList<Carrinho>) iS.readObject());
					iS.close();
				}
				catch(ClassNotFoundException y)
				{
					
				}
			}
			catch(IOException e)
			{
				
			}
			
		}
		//LIVROS
		//CASO 1:FICHEIRO NAO EXISTE --> cria um novo ficheiro
		if(!this.fileLivros.exists())
		{
			viewComics.addLivro(new Livro("CapuchinhoVermelho","Autor1",2.99,10));
			viewComics.addLivro(new Livro("Tintin","Herge",11.99,5));
			viewComics.addLivro(new Livro("Asterix","Albert Underzo",7.99,20));
			try
			{
				this.fileLivros.createNewFile();
				this.oS = new ObjectOutputStream(new FileOutputStream(this.fileLivros));
				oS.writeObject(viewComics.getLivros());
				oS.close();
			}
			catch(IOException e)
			{
				
			}	
		}
		//CASO 2:FICHEIRO EXISTE -- > l� o ficheiro existente
		else
		{
			
			try
			{
				this.iS = new ObjectInputStream(new FileInputStream(this.fileLivros));
				try
				{
					this.viewComics.setLivros((ArrayList<Livro>) iS.readObject());
					iS.close();
				}
				catch(ClassNotFoundException y)
				{
					
				}
			}
			catch(IOException e)
			{
				
			}
			
		}
	
	}
	
	//GUARDAR OS FICHEIROS
	//CHAMADO em caso de logOut / fecho janela
	protected void atualizaficheiro(ArrayList<Utilizador> utilizador, ArrayList<Carrinho> carrinhos,ArrayList <Livro> livros)
	{
		try
		{
			oS = new ObjectOutputStream(new FileOutputStream(this.fileUtilizadores));
			oS.writeObject(utilizador);
			oS.close();
		}
		catch(IOException e)
		{
			
		}
		
		try
		{
			oS = new ObjectOutputStream(new FileOutputStream(this.fileCarrinhos));
			oS.writeObject(carrinhos);
			oS.close();
		}
		catch(IOException e)
		{
			
		}
		try
		{
			oS = new ObjectOutputStream(new FileOutputStream(this.fileLivros));
			oS.writeObject(livros);
			oS.close();
		}
		catch(IOException e)
		{
			
		}
	}
	

}
