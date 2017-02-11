package calculadoraredeip;

/**
 * Classe do elemento de rede.
 * @author Elma Santos e Fabiana Marinheiro
 * 
 */
public class ElementoDeRede {
	
	private String elemento;
	protected String primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto; //campos em binário
	protected int primeiroCampoDecimal, segundoCampoDecimal, terceiroCampoDecimal, quartoCampoDecimal; //campos em decimal
	
	/**
	 * Método construtor.
	 * @param elemento String - Elemento de rede.
	 */
	public ElementoDeRede(String elemento){
		this.elemento = elemento;
	}
		
	/**
	 * Método para converter a String do elemento de rede em decimal, dividida em 4 campos.
	 * @param elemento String - Elemento de rede.
	 */
	public void converterParaDecimal(String elemento){
		
		String campo[] = new String[4];
		campo = elemento.split("\\.");//separa a string pelos pontos e atribui a um vetor
		
		//converte cada posição do vetor para int e atribui às respectivas variáveis
		primeiroCampoDecimal = Integer.parseInt(campo[0]);
		segundoCampoDecimal = Integer.parseInt(campo[1]);
		terceiroCampoDecimal = Integer.parseInt(campo[2]);
		quartoCampoDecimal = Integer.parseInt(campo[3]);
	}	
	
	
	/**
	 * Método para converter os campos do elemento de inteiro para binário (String).
	 */
	public void converterParaBinario(){
		//cada campo é convertido para binário e 0s são inseridos à esquerda até que tenha 8 bits
		primeiroOcteto = Integer.toBinaryString(primeiroCampoDecimal);
		while(primeiroOcteto.length() < 8){
			primeiroOcteto = "0" + primeiroOcteto;
		}
		segundoOcteto = Integer.toBinaryString(segundoCampoDecimal);
		while(segundoOcteto.length() < 8){
			segundoOcteto = "0" + segundoOcteto;
		}
		terceiroOcteto = Integer.toBinaryString(terceiroCampoDecimal);
		while(terceiroOcteto.length() < 8){
			terceiroOcteto = "0" + terceiroOcteto;
		}
		quartoOcteto = Integer.toBinaryString(quartoCampoDecimal);
		while(quartoOcteto.length() < 8){
			quartoOcteto = "0" + quartoOcteto;
		}
	}
	
	/**
	 * Método para retornar primeiro octeto do elemento.
	 * @return String - primeiro octeto.
	 */
	public String getPrimeiroOcteto(){
		return primeiroOcteto;
	}
	
	/**
	 * Método para retornar segundo octeto do elemento.
	 * @return String - segundo octeto.
	 */
	public String getSegundoOcteto(){
		return segundoOcteto;
	}
	
	/**
	 * Método para retornar terceiro octeto do elemento..
	 * @return String - terceiro octeto.
	 */
	public String getTerceiroOcteto(){
		return terceiroOcteto;
	}

	/**
	 * Método para retornar quarto octeto do elemento..
	 * @return String - quarto octeto.
	 */
	public String getQuartoOcteto(){
		return quartoOcteto;
	}
}
