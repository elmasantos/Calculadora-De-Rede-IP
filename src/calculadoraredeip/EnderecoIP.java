package calculadoraredeip;

/**
 * Classe do endereço IP.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */
public class EnderecoIP extends ElementoDeRede {

	/**
	 * Método construtor.
	 * @param elemento String - Endereço IP.
	 */
	public EnderecoIP(String elemento) {
		super(elemento);
	}
	
	/**
	 * Método para verificar se endereço IP é válido.
	 * @return true - se for endereço válido ou false se não for.
	 */
	public boolean validarIP(){
		if(primeiroCampoDecimal == 127){
			System.out.println("Endereço de loopback!");
			return false;
		}
		else if((primeiroCampoDecimal >= 0 && primeiroCampoDecimal <= 255) && (segundoCampoDecimal >= 0 && segundoCampoDecimal <=255) && (terceiroCampoDecimal >= 0 && terceiroCampoDecimal <= 255) && (quartoCampoDecimal >= 0 && quartoCampoDecimal <=255)){
			return true;
		}
		else{
			return false;
		}		
	}
	
	/**
	 * Método para retornar primeiro campo decimal do endereço IP.
	 * @return int - primeiro campo do endereço IP.
	 */
	public int getPrimeiroCampoDecimal(){
		return primeiroCampoDecimal;
	}
	
	/**
	 * Método para retornar segundo campo decimal do endereço IP.
	 * @return int - segundo campo do endereço IP.
	 */
	public int getSegundoCampoDecimal(){
		return segundoCampoDecimal;
	}
	
	/**
	 * Método para retornar terceiro campo decimal do endereço IP.
	 * @return int - terceiro campo do endereço IP.
	 */
	public int getTerceiroCampoDecimal(){
		return terceiroCampoDecimal;
	}

	/**
	 * Método para retornar quarto campo decimal do endereço IP.
	 * @return int - quarto campo do endereço IP.
	 */
	public int getQuartoCampoDecimal(){
		return quartoCampoDecimal;
	}
	
}
