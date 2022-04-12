package umc.socket;


public class RealizaContaX {

	
	public RealizaContaX(){
		
		}
	
	
	public String retornaResposta(String s){
		String arrays[] = new String[2];
		double resposta;
		
		if(s.contains("@")){
			s = s.trim();
			arrays = s.split("@");
		
			if(arrays[1].equals("/")){
				resposta =  Double.parseDouble(arrays[0]) / Double.parseDouble(arrays[2]);
				s = String.valueOf("O resultado � "+resposta);
			}else if(arrays[1].equals("*")){
				resposta =  Double.parseDouble(arrays[0]) * Double.parseDouble(arrays[2]);
				s = String.valueOf("O resultado � "+resposta);
			}else if(arrays[1].equals("-")){
				resposta =  Double.parseDouble(arrays[0]) - Double.parseDouble(arrays[2]);
				s = String.valueOf("O resultado � "+resposta);
			}else if(arrays[1].equals("+")){
				resposta =  Double.parseDouble(arrays[0]) + Double.parseDouble(arrays[2]);
				s = String.valueOf("O resultado � "+ resposta);
			}
		}

			return s;
	}
	
	
} 
