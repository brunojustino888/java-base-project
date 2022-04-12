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

public class AlunoTest {

    
    public static void main(String[] args) {
        
    final String sNomeDoCurso = "Java";
    final int iPeriodo =  36;
    final int iAno = 2013;
    Aluno oTurma1[];    
    int quantidade;
    
    quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantidade de alunos que ser�o cadastrados no curso de: "+sNomeDoCurso+".","Cadastro de Alunos",2));
     oTurma1 = new Aluno[quantidade]; //criando o vetor de alunos
     
    for (int i=0;i<quantidade;i++){
        String nome = JOptionPane.showInputDialog(null,"Digite o nome do alunoo","Cadastro de Alunos",2);
        oTurma1[i] = new Aluno(nome); //instanciando cada aluno de uma vez
        System.out.println("N�mero de Matricula = 00" + oTurma1[i].iNumeroDeMatricula);
        System.out.println("Nome do Aluno = " + oTurma1[i].sNomeDoAluno);
        System.out.println("Quantidade de Semestres = " + iPeriodo);  
        System.out.println("Ano = " + iAno);  
        System.out.println("Descri��o do Curso = " + sNomeDoCurso + "\n\n");  
     }
        
    }
}
