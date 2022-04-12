 /*
 * Implemente um sistema chamado controle academico para cadastrar turmas e alunos para turmas.
 * Utilize uma classe chamada aluno, com os atributos referentes a um aluno (nome,matricula) e uma classe contendo os atributos:
 * 1: nome do curso
 * 2: periodo
 * 3: ano
 * 4: Alunos(vetor que devera conter objetos da classe aluno)
 */
package umc.passosBlueJ;

import javax.swing.JOptionPane;
 /**
 * @author Bruno Alves Justino
 * Date: 27/10/2012
 */

 public class Aluno {
	    
	    static int iMatricula;
	     String sNomeDoAluno;
	      int iNumeroDeMatricula;

	public Aluno(int iNumeroMatricula, String sNome){
	   iMatricula++;
	   iNumeroDeMatricula = iNumeroMatricula;
	   sNomeDoAluno = sNome;
	}

	public Aluno(String sNome){
	   iMatricula++;
	   iNumeroDeMatricula = iMatricula;
	   sNomeDoAluno = sNome;
	}

	public String getNome(){
		return sNomeDoAluno;
	}
	
	
	public void imprimir(Object o)    {
        sNomeDoAluno = o.toString();  //fun��o que vai capturar o valor do objeto e converte-lo em string
        JOptionPane.showMessageDialog(null,"O Aluno incluso �: "+sNomeDoAluno,"Imprimindo",1);
 }
	
	}