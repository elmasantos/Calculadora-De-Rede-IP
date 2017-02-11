# Calculadora De Rede IP

## 1 - Descrição

O software Calculadora de Rede IP foi desenvolvido para a disciplina Redes de Computadores, com o objetivo de auxiliar na identificação de endereço padrão,
identificação de endereço com máscara, cálculo de bloco e cálculo de subredes. O programa foi implementado na linguagem de programação Java, utilizando o
Eclipse como ambiente de desenvolvimento.

## 2 - Funcionalidades

A calculadora de rede IP apresenta um menu inicial com as seguintes
funcionalidades:
###Identificação de endereço padrão:
o usuário deve informar um endereço IP no formato X.X.X.X. Caso o IP seja válido, ele receberá como saída a classe da rede IP (inclusive informando casos em que o endereço é de uma rede privada), a máscara
padrão, o netid e o hostid.
###Identificação de endereço com máscara:
o usuário deve fornecer um endereço IP e uma máscara de rede, ambos no formato X.X.X.X. Caso sejam válidos, ele receberá como saída a classe da rede IP (inclusive informando casos em que o endereço é de uma rede privada), o netid e o hostid.
###Cálculo de bloco:
o usuário deve fornecer um endereço IP e uma máscara de rede, ambos no formato X.X.X.X. Caso sejam válidos, ele receberá como saída a classe da rede IP (inclusive informando casos em que o endereço é de uma rede privada), o endereço de subrede,
o endereço de broadcast e a quantidade de endereços na subrede.
###Cálculo de sub-redes:
o usuário deve fornecer um endereço IP e uma máscara de rede, ambos no formato X.X.X.X. Caso sejam válidos, ele receberá como saída a classe do endereço IP (inclusive informando casos em que o endereço é de uma rede privada), e, para cada subrede
possível, são listados o endereço de subrede e de broadcast, a quantidade de endereços na subrede e todos os endereços de host possíveis na subrede.

## 3 - Instalação e utilização

Para utilizar o aplicativo, o usuário deve abrir o prompt de comando do sistema operacional Windows e ir até o diretório onde se encontra o arquivo “calcIP.jar”. Estando no diretório correto, basta digitar “java -jar calcIP.jar” para executar a
aplicação. Caso não execute, significa que o Java Development Kit (JDK) não está instalado.

É possível fazer o download do JDK nesse link: [Java SE Development Kit 8 Downloads](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

## 4 - Autoras

* **Elma Santos**
* **Fabiana Marinheiro**
