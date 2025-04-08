package io.programeday.utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro Zacarias
 */
public class Mensagem {

    public static void addMensagem(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public static void mensagemInformacao(String mensagem){
        addMensagem(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
    }
    
    public static void mensagemAlerta(String mensagem){
        addMensagem(FacesMessage.SEVERITY_WARN, mensagem, mensagem);
    }
    
    public static void mensagemPerigo(String mensagem){
        addMensagem(FacesMessage.SEVERITY_WARN, mensagem, mensagem);        
    }

}
