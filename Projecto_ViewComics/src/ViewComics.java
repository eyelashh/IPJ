
public class ViewComics {

	public static void main(String[] args) {
		
		AppCliente clt = new AppCliente();
		clt.run();
		
		Livraria l=Livraria.getInstance();
		
		l.addUtilizador(new Funcionario(1,"Joana",11111111,"ja","jaa"));
		l.addUtilizador(new Funcionario(1,"Bruno",22222222,"bo","boo"));
		l.addUtilizador(new Administrador(1,"Tamara",33333333,"ta","taa"));
		l.addUtilizador(new Funcionario(1,"Joao",4444444,"jo","joo"));
		l.addUtilizador(new Funcionario(1,"Ana",5555555,"aaa","aaa"));
		l.addUtilizador(new Funcionario(1,"Helena",6666666,"ha","haa"));
		l.addUtilizador(new Funcionario(1,"Carlos",777777777,"cs","css"));
		l.addUtilizador(new Funcionario(1,"Mariana",88888888,"ma","maa"));
		l.addUtilizador(new Funcionario(1,"Lucia",999999999,"la","laa"));
		l.addUtilizador(new Administrador(1,"Miguel",1010101101,"ml","mll"));
		
		
	}

}
