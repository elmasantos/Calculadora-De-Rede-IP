package calculadoraredeip;

/**
 * Classe da calculadora de rede.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */
public class CalculadoraDeRede {
	
	String classe; //classe do endereço IP
	int primeiroCampoEnderecoDeRede, segundoCampoEnderecoDeRede, terceiroCampoEnderecoDeRede, quartoCampoEnderecoDeRede;//campos de endereço de rede
	int primeiroCampoEnderecoComMascara, segundoCampoEnderecoComMascara, terceiroCampoEnderecoComMascara, quartoCampoEnderecoComMascara;//campos de endereço de rede com mascara padrão
	//int primeiroCampoEnderecoDeRede, segundoCampoEnderecoDeRede, terceiroCampoEnderecoDeRede, quartoCampoEnderecoDeRede;//campos de endereço de rede

	double quantidadeSubRedes = 0; //quantidade de sub redes
	double quantidadeSubRedesDaSubRede = 0; //quantidade de sub redes da sub rede
	
	/**
	 * Método construtor.
	 */
	public CalculadoraDeRede(){
	
	}
	
	/**
	 * Método para informar a classe do endereço IP, indicando se é endereço de rede privada.
	 * @param primeiroCampoDecimal int - primeiro campo de endereço IP.
	 * @param segundoCampoDecimal int - segundo campo do endereço IP.
	 */
	public void informarClasse(int primeiroCampoDecimal, int segundoCampoDecimal){
		if(primeiroCampoDecimal >= 0 && primeiroCampoDecimal <=127){
			classe = "CLASSE A";
			System.out.println(classe);
			if(primeiroCampoDecimal == 10){
				System.out.println("Rede privada.");
			}
		}
		else if(primeiroCampoDecimal >= 128 && primeiroCampoDecimal <= 191){
			classe = "CLASSE B";
			System.out.println(classe);		
			if((primeiroCampoDecimal == 172) && (segundoCampoDecimal >= 16 && segundoCampoDecimal <=31)){
				System.out.println("Rede privada.");
			}
		}
		else if(primeiroCampoDecimal >= 192 && primeiroCampoDecimal <= 223){
			classe = "CLASSE C";
			System.out.println(classe);
			if(primeiroCampoDecimal == 192 && primeiroCampoDecimal == 168){
				System.out.println("Rede privada.");
			}
		}
		else if(primeiroCampoDecimal >= 224 && primeiroCampoDecimal <= 239){
			classe = "CLASSE D";
			System.out.println(classe);
		}
		else if(primeiroCampoDecimal >= 240 && primeiroCampoDecimal <= 255){
			classe = "CLASSE E";
			System.out.println(classe);
		}		
	}
	
	/**
	 * Método para calcular máscara padrão.
	 */
	public void calcularMascaraPadrao(){
		if(classe.equals("CLASSE A")){
			System.out.println("Máscara padrão: 255.0.0.0");
		}
		else if(classe.equals("CLASSE B")){
			System.out.println("Máscara padrão: 255.255.0.0");
		}
		else if(classe.equals("CLASSE C")){
			System.out.println("Máscara padrão: 255.255.255.0");
		}
		else if(classe.equals("CLASSE D") || classe.equals("CLASSE E")){
			System.out.println("Máscara padrão: não aplicável");
		}
	}
	
	/**
	 * Método para calcular netid.
	 * @param primeiroCampoDecimal int - primeiro campo de endereço IP.
	 * @param segundoCampoDecimal int - segundo campo de endereço IP.
	 * @param terceiroCampoDecimal int - terceiro campo de endereço IP.
	 * @param quartoCampoDecimal int - quarto campo de endereço IP.
	 */
	public void calcularNetID(int primeiroCampoDecimal, int segundoCampoDecimal, int terceiroCampoDecimal){
		if(classe.equals("CLASSE A")){
			System.out.println("Netid: " + primeiroCampoDecimal + ".0.0.0");
		}
		else if(classe.equals("CLASSE B")){
			System.out.println("Netid: " + primeiroCampoDecimal + "." + segundoCampoDecimal + ".0.0");
		}
		else if(classe.equals("CLASSE C")){
			System.out.println("Netid: " + primeiroCampoDecimal + "." + segundoCampoDecimal + "." + terceiroCampoDecimal + ".0");
		}
		else if(classe.equals("CLASSE D") || classe.equals("CLASSE E")){
			System.out.println("Netid: não aplicável");
		}
	}
	
	/**
	 * Método para calcular hostid.	
	 * @param segundoCampoDecimal int - segundo campo de endereço IP.
	 * @param terceiroCampoDecimal int - terceiro campo de endereço IP.
	 * @param quartoCampoDecimal int - quarto campo de endereço IP.
	 */
	public void calcularHostID(int segundoCampoDecimal, int terceiroCampoDecimal, int quartoCampoDecimal){
		if(classe.equals("CLASSE A")){
			System.out.println("Hostid: 0." + segundoCampoDecimal + "." + terceiroCampoDecimal + "." + quartoCampoDecimal);
		}
		else if(classe.equals("CLASSE B")){
			System.out.println("Hostid: 0.0." + terceiroCampoDecimal + "." + quartoCampoDecimal);
		}
		else if(classe.equals("CLASSE C")){
			System.out.println("Hostid: 0.0.0." + quartoCampoDecimal);
		}
		else if(classe.equals("CLASSE D") || classe.equals("CLASSE E")){
			System.out.println("Hostid: não aplicável");
		}
	}
	
	/**
	 * Método auxiliar para contar 1s presentes na máscara ou no endereço IP.
	 * @param elemento String - cadeia de bits.
	 * @param contador int - contador de 1s na cadeia de bits.
	 */
	public int contarUns(String elemento, int contador){
		int tamanho = elemento.length();
		for(int i = 0; i < tamanho; i++){
			if(elemento.charAt(i) == '1'){
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Método para cálculo de enredeço de rede e broadcast.
	 * @param primeiroOctetoMascara String - primeiro campo da máscara (em binário).
	 * @param segundoOctetoMascara String - segundo campo da máscara (em binário).
	 * @param terceiroOctetoMascara String - terceiro campo da máscara (em binário).
	 * @param quartoOctetoMascara String - quarto campo da máscara (em binário).
	 * @param primeiroOctetoIP String - primeiro campo do endereço IP (em binário).
	 * @param segundoOctetoIP String - segundo campo do endereço IP (em binário).
	 * @param terceiroOctetoIP String - terceiro campo do endereço IP (em binário).
	 * @param quartoOctetoIP String - quarto campo do endereço IP (em binário).
	 */
	public void calcularEndereco(String bit, String primeiroOctetoMascara, String segundoOctetoMascara, String terceiroOctetoMascara, String quartoOctetoMascara,
		String primeiroOctetoIP, String segundoOctetoIP, String terceiroOctetoIP, String quartoOctetoIP){
		String mascaraConcatenada = primeiroOctetoMascara + segundoOctetoMascara + terceiroOctetoMascara + quartoOctetoMascara;
		String enderecoIPConcatenado = primeiroOctetoIP + segundoOctetoIP + terceiroOctetoIP + quartoOctetoIP;
		String enderecoEmBinario;
		int contador = 0;
		contador = contarUns(mascaraConcatenada, contador);
	
		enderecoEmBinario = enderecoIPConcatenado.substring(0, contador);
		for(int i = contador+1; i <= 32;i++){
			enderecoEmBinario += bit;
		}
		String primeiroCampoEndereco, segundoCampoEndereco, terceiroCampoEndereco, quartoCampoEndereco;
		
		primeiroCampoEndereco = enderecoEmBinario.substring(0, 8);
		segundoCampoEndereco = enderecoEmBinario.substring(8, 16);
		terceiroCampoEndereco = enderecoEmBinario.substring(16, 24);
		quartoCampoEndereco = enderecoEmBinario.substring(24, 32);
		
		primeiroCampoEnderecoDeRede = Integer.parseInt(primeiroCampoEndereco, 2);
		segundoCampoEnderecoDeRede = Integer.parseInt(segundoCampoEndereco, 2);
		terceiroCampoEnderecoDeRede = Integer.parseInt(terceiroCampoEndereco, 2);
		quartoCampoEnderecoDeRede = Integer.parseInt(quartoCampoEndereco, 2);
		
	}
	
	/**
	 * Método que informa endereço de rede e calcula netid e hostid do endereço de rede dado.
	 */
	public void enderecoDeRedeNetidEHostid(String primeiroOctetoMascara, String segundoOctetoMascara, String terceiroOctetoMascara, String quartoOctetoMascara,
			String primeiroOctetoIP, String segundoOctetoIP, String terceiroOctetoIP, String quartoOctetoIP){
		
		calcularEndereco("0", primeiroOctetoMascara, segundoOctetoMascara, terceiroOctetoMascara, quartoOctetoMascara,
				 primeiroOctetoIP, segundoOctetoIP, terceiroOctetoIP, quartoOctetoIP);
		System.out.println("Endereço de rede: " + primeiroCampoEnderecoDeRede + "." + segundoCampoEnderecoDeRede + "."
				+ terceiroCampoEnderecoDeRede + "." + quartoCampoEnderecoDeRede);
		calcularNetID(primeiroCampoEnderecoDeRede ,segundoCampoEnderecoDeRede, terceiroCampoEnderecoDeRede);
		calcularHostID(segundoCampoEnderecoDeRede, terceiroCampoEnderecoDeRede, quartoCampoEnderecoDeRede);
	}
	
	/**
	 * Método que informa o broadcast.
	 */
	public void imprimirBroadcast(String primeiroOctetoMascara, String segundoOctetoMascara, String terceiroOctetoMascara, String quartoOctetoMascara,
			String primeiroOctetoIP, String segundoOctetoIP, String terceiroOctetoIP, String quartoOctetoIP){
		calcularEndereco("1", primeiroOctetoMascara, segundoOctetoMascara, terceiroOctetoMascara, quartoOctetoMascara,
				 primeiroOctetoIP, segundoOctetoIP, terceiroOctetoIP, quartoOctetoIP);
		
		//int primeiroCampoEnderecoBroadcast, segundoCampoEnderecoBroadcast, terceiroCampoEnderecoBroadcast, quartoCampoEnderecoBroadcast;//campos de endereço broadcast

			System.out.println("Endereço de broadcast: " + primeiroCampoEnderecoDeRede + "." + segundoCampoEnderecoDeRede + "."
					+ terceiroCampoEnderecoDeRede + "." + quartoCampoEnderecoDeRede);
	}
	
	/**
	 * Método para calcular quantidade de sub redes.
	 * @param primeiroOctetoMascara String - primeiro campo da máscara (em binário).
	 * @param segundoOctetoMascara String - segundo campo da máscara (em binário).
	 * @param terceiroOctetoMascara String - terceiro campo da máscara (em binário).
	 * @param quartoOctetoMascara String - quarto campo da máscara (em binário).
	 */
	public void quantidadeSubRedes(String primeiroOctetoMascara, String segundoOctetoMascara, String terceiroOctetoMascara, String quartoOctetoMascara){
		String mascaraConcatenada = primeiroOctetoMascara + segundoOctetoMascara + terceiroOctetoMascara + quartoOctetoMascara;
		int contador = 0;
		int n = 0;
		contador = contarUns(mascaraConcatenada, contador);
		
		switch (classe){
			case "CLASSE A":
				n = contador - 8;
				quantidadeSubRedes = Math.pow(2, n);
				break;
			case "CLASSE B":
				n = contador - 16;
				quantidadeSubRedes = Math.pow(2, n);
				break;
			case "CLASSE C":
				n = contador - 24;
				quantidadeSubRedes = Math.pow(2, n);
				break;
			case "CLASSE D":
				System.out.println("Não se aplica");
				break;
			case "CLASSE E":
				System.out.println("Não se aplica");
				break;
			default:
				System.out.println("Classe inválida.");
		}
		System.out.println("Quantidade de endereços na sub-rede: " + quantidadeSubRedes);
	}
	
	/**
	 * Método para calcular sub redes da sub rede.
	 * @param primeiroOctetoMascara String - primeiro campo da máscara (em binário).
	 * @param segundoOctetoMascara String - segundo campo da máscara (em binário).
	 * @param terceiroOctetoMascara String - terceiro campo da máscara (em binário).
	 * @param quartoOctetoMascara String - quarto campo da máscara (em binário).
	 */
	public void subRedesDaSubRede(String primeiroOctetoMascara, String segundoOctetoMascara, String terceiroOctetoMascara, String quartoOctetoMascara){
		String mascaraConcatenada = primeiroOctetoMascara + segundoOctetoMascara + terceiroOctetoMascara + quartoOctetoMascara;
		int contador = 0;
		int n = 0;
		
		contador = contarUns(mascaraConcatenada, contador);

		n = 32 - contador;
		quantidadeSubRedesDaSubRede = Math.pow(2, n);
		System.out.println("Quantidade de sub redes da sub rede:" + quantidadeSubRedesDaSubRede);
		
	}
	
	/**
	 * Método para calcular endereço de rede a partir da máscara padrão.
	 * @param primeiroOctetoIP String - primeiro campo do endereço IP (em binário).
	 * @param segundoOctetoIP String - segundo campo do endereço IP (em binário).
	 * @param terceiroOctetoIP String - terceiro campo do endereço IP (em binário).
	 * @param quartoOctetoIP String - quarto campo do endereço IP (em binário).
	 */
	public void calcularEnderecoComMP(String primeiroOctetoIP, String segundoOctetoIP, String terceiroOctetoIP, String quartoOctetoIP){
		
		String enderecoIPConcatenado = primeiroOctetoIP + segundoOctetoIP + terceiroOctetoIP + quartoOctetoIP;
		String enderecoComMascaraPadrao;
		int contador = 0;
		
		switch (classe){
			case "CLASSE A":
				contador = 8;
				break;
			case "CLASSE B":
				contador = 16;
				break;
			case "CLASSE C":
				contador = 24;
				break;
			case "CLASSE D":
				System.out.println("Não se aplica");
				break;
			case "CLASSE E":
				System.out.println("Não se aplica");
				break;
		}
			
		enderecoComMascaraPadrao = enderecoIPConcatenado.substring(0, contador);
		for(int i = contador+1; i <= 32;i++){
			enderecoComMascaraPadrao += 0;
		}

		String primeiroCampoEnderecoDeRede, segundoCampoEnderecoDeRede, terceiroCampoEnderecoDeRede, quartoCampoEnderecoDeRede;//campos de endereço de rede
		
		primeiroCampoEnderecoDeRede = enderecoComMascaraPadrao.substring(0, 8);
		segundoCampoEnderecoDeRede = enderecoComMascaraPadrao.substring(8, 16);
		terceiroCampoEnderecoDeRede = enderecoComMascaraPadrao.substring(16, 24);
		quartoCampoEnderecoDeRede = enderecoComMascaraPadrao.substring(24, 32);
		
		primeiroCampoEnderecoComMascara = Integer.parseInt(primeiroCampoEnderecoDeRede, 2);
		segundoCampoEnderecoComMascara = Integer.parseInt(segundoCampoEnderecoDeRede, 2);
		terceiroCampoEnderecoComMascara = Integer.parseInt(terceiroCampoEnderecoDeRede, 2);
		quartoCampoEnderecoComMascara = Integer.parseInt(quartoCampoEnderecoDeRede, 2);
			
		System.out.println("Endereço de rede com mascara padrão: " + primeiroCampoEnderecoComMascara + "." + segundoCampoEnderecoComMascara + "."
				+ terceiroCampoEnderecoComMascara + "." + quartoCampoEnderecoComMascara);
			
	}
	
	/**
	 * Método para listar sub redes.
	 */
	public void listarSubRede(){
		int contadorDeRede = 1;
		for(int i = 0;i < quantidadeSubRedes; i++){
			System.out.print("Endereço de rede da sub rede " + contadorDeRede + ": ");
			for(int j = 0; j < quantidadeSubRedesDaSubRede; j++){
				if(j == quantidadeSubRedesDaSubRede-1){
					System.out.print("Endereço de broadcast: ");
				}
				if(quartoCampoEnderecoComMascara <= 255){
					System.out.println(primeiroCampoEnderecoComMascara + "." + segundoCampoEnderecoComMascara + "." + terceiroCampoEnderecoComMascara + "." + quartoCampoEnderecoComMascara++);
				}
				else if(terceiroCampoEnderecoComMascara <= 255){
					quartoCampoEnderecoComMascara = 0;
					System.out.println(primeiroCampoEnderecoComMascara + "." + segundoCampoEnderecoComMascara + "." + ++terceiroCampoEnderecoComMascara + "." + quartoCampoEnderecoComMascara++);
				}
				else if(quartoCampoEnderecoComMascara >= 255 && terceiroCampoEnderecoComMascara >= 255){
					quartoCampoEnderecoComMascara = 0;
					terceiroCampoEnderecoComMascara = 0;
					System.out.println(primeiroCampoEnderecoComMascara + "." + ++segundoCampoEnderecoComMascara + "." + terceiroCampoEnderecoComMascara++ + "." + quartoCampoEnderecoComMascara++);
				}					
			}
				contadorDeRede++;	
		}
	}
	
	/**
	 * Método para retornar a classe do endereço IP;
	 * @return String - classe.
	 */
	public String getClasse(){
		return classe;
	}
	
}
