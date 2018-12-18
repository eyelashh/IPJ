import java.util.HashMap;
import java.util.Scanner;

/**
 * Breve descrição do código
 *
 * @sid 2013
 * @aid 1.1
 */

public class Client {

	private int id;
	private String name;
	private int nif;
	private HashMap<Integer, Integer> cart;
	boolean finalCart;
	
	public Client(int id, String name, int nif, HashMap<Integer, Integer> cart, boolean finalCart) {
		super();
		this.id = id;
		this.name = name;
		this.nif = nif;
		this.cart = cart;
		this.finalCart = finalCart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNif() {
		return nif;
	}
	public void setNif(int nif) {
		this.nif = nif;
	}
	public HashMap<Integer, Integer> getCart() {
		return cart;
	}
	public void setCart(HashMap<Integer, Integer> cart) {
		this.cart = cart;
	}
	public boolean isFinalCart() {
		return finalCart;
	}
	public void setFinalCart(boolean finalCart) {
		this.finalCart = finalCart;
	}
	
public void addToCart(Book b) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Quantos livros "+b.getName()+" pretende adicionar ao carrinho?");
	int q=sc.nextInt();
	this.cart.put(b.getBookID(),q);
}
public void removeFromCart(Book b) {
	
	this.cart.remove(b.getBookID());	
}
	
}
