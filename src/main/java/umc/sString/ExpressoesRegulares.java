package umc.sString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//As express�es regulares s�o muito �teis para validar dados e verificar se os mesmos est�o no formato correto.

public class ExpressoesRegulares {


	public static void main(String[] args) {

		//Valida��o
		String padrao = "java";
		String texto = "JAVA";
		boolean s = texto.matches(padrao);		//m�todo que rotorna bool se ocorre a valida��o.
		System.out.println(s);
		
		
		
		/*Modificadores:
		 * (?i) Ignora mai�sculas e min�sculas.
		 * (?x) Coment�rios
		 * (?m) Multilinhas
		 * (?s) Dottal	 */
		s = texto.matches("(?i)java"); //Vai fazer a valida��o mesmo que for min�sculas as letras.	
		System.out.println(s);
		
		
		
		/*Metacaracteres:
		 . qualquer caracter
		 /d digitos      [0-9]
		 /D n�o � digito [^0-9]
		 /s espa�os      [ /t/n/x0B/f/r]
		 /S n�o � espa�o [ ^/s]
		 /w letra        [a-zA-Z_0-9]
		 /W n�o � letra  */
		s = "@".matches("."); //o ponto avalia se � qualquer caracter.
		System.out.println(s);
		s = "2".matches("//d"); //o /d avalia se � qualquer digito.
		System.out.println(s);
		s = "s".matches("//w"); //o w avalia se � qualquer digito ou letra.
		System.out.println(s);
		s = " ".matches("//s"); //o s avalia se � qualquer tipo de espa�o.
		System.out.println(s);
		s = "@@".matches(".."); //para avaliar mais de um caracter se usa mais de um metacaracter.
		System.out.println(s);
		String padraodecep = "//d//d//d//d//d-//d//d//d";  //valida��o de um cep.
		s = "06226-210".matches(padraodecep);
		System.out.println(s);
		
		
		
		/*Quantificadores
		 X{n}	 X, exatamente n vezes 
		 X{n,} 	 X, pelo menos n vezes
		 X{n, m} X, pelo menos n mas n�o + que m vezes 
		 X?		 X, 0 ou 1 vez
		 X*		 X, 0 ou + vezes
		 X+		 X, 1 ou + vezes 
		 */
		s = "06226000".matches("//d{8}"); // vai verificar se tem 8 digitos na String s
		System.out.println(s);
		s = "06265465465426000".matches("//d{8,}"); // vai verificar se tem 8 digitos ou mais na String s - pelo menos n vezes
		System.out.println(s);
		s = "06265465465426000".matches("//d{8,9}"); // vai verificar se tem 8 digitos ou no max 9- pelo menos n vezes mas n�o + que m vezes
		System.out.println(s);
		s = "a".matches(".?"); // vai verificar se tem entre 0 ou 1 vez qualquer caracter
		System.out.println(s);
		s = "a".matches(".*"); // vai verificar se tem entre 0 ou + vezes qualquer caracter
		System.out.println(s);
		s = "123".matches(".+"); // vai verificar se tem entre 1 ou + vezes qualquer caracter
		System.out.println(s);

		
		
		/*Metacaracteres de Fronteira
		 ^ inicia
		 $ finaliza
		 | ou
		*/
		s = "Pier21".matches("^Pier.*"); // vai verificar se comeca com Pier , e continua com qualquer caracter 0 ou + vezes
		System.out.println(s);
		s = "Pier21".matches(".*21$"); // vai verificar se comeca com qualquer caracter 0 ou + vezes e termina com 21
		System.out.println(s);
		s = "tem java aki".matches(".*java.*"); // vai verificar se tem java na frase
		System.out.println(s);
		s = "tem java aki".matches("^tem.*ki"); // vai verificar se comeca com tem, tem 0 ou + palavras eentre ki e termina com ki
		System.out.println(s);
		s = "sim".matches("sim|n�o"); // vai verificar se tem sim ou n�o na palavra
		System.out.println(s);
		
		
		
		/*Agrupadores
		 [...]				 agrupamento
		 [a-z]			     alcance
		 [a-e][i-u]			 uni�o
		 [a-z&&[aeiou]]		 interse��o
		 [^abc]				 exce��o
		 [a-z&&[^m-p]]		 subtra��o
		 \x					 fuga literal
		 */
		s = "s".matches("[a-z]"); // vai verificar se esta entre a e z
		System.out.println(s);
		s = "8".matches("[0-8]"); // verifica se esta entre 0 e 8
		System.out.println(s);
		s = "true".matches("[tT]rue"); // verifica a letra maiuscula e minuscula
		System.out.println(s);
		s = "true".matches("[tT]rue|[yY]es"); // verifica a letra maiuscula e minuscula  ou a outra palavra o yes
		System.out.println(s);
		s = "BeatriX".matches("[A-Z][a-zA-Z]*"); // verifica se a 1 letra � maiuscula e depois continua com outras letras 0 ou mais vezes
		System.out.println(s);
		s = "olho".matches("[^abc]lho*"); // verifica se as primeiras letras n�o s�o abc e terminam com lho
		System.out.println(s);
		s = "crau".matches("cr[ae]u"); // verifica as letras do mei se s�o a ou e 
		System.out.println(s);
		s = "rh@xti.com".matches("\\w+@\\w+\\.\\w{2,3}"); // verifica as letras do mei se s�o a ou e 
		System.out.println(s);
		
		//Para achar as ocorrencias de doce da frase abaixo
		String doce = "Qual � o Doce mais doCe que o doce?";
		Matcher oia = Pattern.compile("(?i)doce").matcher(doce);
		while(oia.find()){
			System.out.println(oia.group());
		}
		
		/*SUBSTITUI��ES*/
		texto = doce.replaceAll("(?i)doce","Salgado");
		System.out.println(texto);
		String rato = "O rato roue a roupa do rei de roma";
		String rr = rato.replaceAll("r[aeiou]", "F");
		System.out.println(rr);
		
		//Tabula��o
		texto = "tabular este texto";
		rr = texto.replaceAll("\\s", "\t");
		System.out.println(rr);
		
		String url = "www.xti.com.br/clientes-2011.html";
					//http://www.xti.com.br/2011/clientes.jsp
		String r320 = "www.xti.com.br/\\w{2,}-\\d{4}.html";
		System.out.println(url.matches(r320));
				
		texto = "(www.xti.com.br)/(\\w{2,})-(\\d{4}).html";
		String dd2 = url.replaceAll(r320, "http://$1/$3/$2.jsp");
		System.out.println(dd2);
	}

}
