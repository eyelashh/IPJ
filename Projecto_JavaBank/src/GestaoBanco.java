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
	private ObjectInputStream iS;
	private ObjectOutputStream oS;
	
	// Construtor:
	public GestaoBanco() {
		// INICIALIZA O BANCO:
		this.javabank = new Banco();
		iS = null;
		// CRIA FICHEIROS:
		this.fileUtil = new File("fileUtil.dat");
	}

	@SuppressWarnings("unchecked")
	protected void run()
	{
		
		//FICHEIRO DE UTILIZADORES:
		//
		//
		//
		// Caso nao exista um ficheiro de utilizadores é criado 3 users por defeito!
		if(!this.fileUtil.exists())
		{
			Utilizador adm = new Administrador(-1,"Administrador","Master",Date.valueOf(LocalDate.now()),"CC",0,"DEI",910000000,"admin","admin");
			Utilizador fun = new Funcionario(-2,"Funcionario","Master",Date.valueOf(LocalDate.now()),"CC",0,"DEI",910000000,"funcionario", "funcionario",-2);
			Utilizador clt = new Cliente(-3,"Cliente","Master",Date.valueOf(LocalDate.now()),"CC",0,"DEI",910000000,"cliente","cliente");
			javabank.addUtilizador(adm);
			javabank.addUtilizador(fun);
			javabank.addUtilizador(clt);
			
			// De seguida é efectuada a criaçao do ficheiro:
			try
			{
				this.fileUtil.createNewFile();
				oS = new ObjectOutputStream(new FileOutputStream(this.fileUtil));
				oS.writeObject(javabank.getUtlizadores());
				oS.close();
			}
			catch(IOException e)
			{
				System.out.println("Teste 2 falhado");
			}
		}
		else
		{
			try
			{
				System.out.println(fileUtil.getName());
				this.iS = new ObjectInputStream(new FileInputStream(this.fileUtil));
				try
				{
					this.javabank.setUtlizadores((ArrayList<Utilizador>) iS.readObject()); 
					iS.close();
				}
				catch(ClassNotFoundException y)
				{
					System.out.println("Teste 1 falhado");
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	
		
		
		
		
		
		
	}
	
	
	
}
