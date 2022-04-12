package interfaceXmlEnergiza;
/*	
 * Essa classe foi desenvolvida para ser transformada em elementos para o arquivo XML posteriormente � povoa��o das vari�veis.
 * Ele ser� usada somente para "converter" seus atributos em elementos XML.
 * Seu construtor receber� como par�metro os elementos que existir�o no XML.
 */

public class BusinessHours {
    private String data;
    private String dia;
    private String horaInicial;
    private String horaFinal;
    
    public BusinessHours(String data, String dia, String horaInicial, String horaFinal) {
        this.data = data;
        this.dia = dia;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }    
    
}
