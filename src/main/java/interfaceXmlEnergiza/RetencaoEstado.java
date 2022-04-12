package interfaceXmlEnergiza;
/*	
 * Essa classe foi desenvolvida para ser transformada em elementos para o arquivo XML posteriormente � povoa��o das vari�veis.
 * Ele ser� usada somente para "converter" seus atributos em elementos XML.
 * Seu construtor receber� como par�metro os elementos que existir�o no XML.
 */


public class RetencaoEstado {
    private String PB;
    private String BO;
    private String SE;
    private String MG;
    private String NF;
    
    
    public RetencaoEstado(String PB, String BO, String SE, String MG, String NF){
    	this.PB = PB;
    	this.BO = BO;
    	this.SE = SE;
    	this.MG = MG;
    	this.NF = NF;
    }


	public String getPB() {
		return PB;
	}


	public void setPB(String pB) {
		PB = pB;
	}


	public String getBO() {
		return BO;
	}


	public void setBO(String bO) {
		BO = bO;
	}


	public String getSE() {
		return SE;
	}


	public void setSE(String sE) {
		SE = sE;
	}


	public String getMG() {
		return MG;
	}


	public void setMG(String mG) {
		MG = mG;
	}


	public String getNF() {
		return NF;
	}


	public void setNF(String nF) {
		NF = nF;
	}
    
    
    
}
