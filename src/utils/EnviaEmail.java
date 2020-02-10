/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class EnviaEmail {
    public void enviaCotacao (JFrame tela, String empresa, String user, String Email) {
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.hostinger.com.br");
        email.setSmtpPort(587);                
        email.setAuthenticator(new DefaultAuthenticator("contato@uniunjuntas.com.br", "x96q12r57"));
        email.setSSLOnConnect(true);
        
            try{               
                //estrutura do e-mail
                email.setFrom("contato@uniunjuntas.com.br"); //remetente
                email.setSubject("Cotação de compra "+empresa);  //assunto
                email.setMsg("Cotação de compra expedida por "+user+"\n E-mail: "+Email); //mensagem
                email.addTo("contato@uniunjuntas.com.br"); //destinatario
                
                //anexo
                EmailAttachment anexo = new EmailAttachment();
                anexo.setPath("..\\src\\utils\\Carrinho.pdf");
                anexo.setDisposition(EmailAttachment.ATTACHMENT);
                
                email.attach(anexo);
                
                email.send();
                JOptionPane.showMessageDialog(tela, "E-Mail enviado com sucesso");
            } catch (EmailException ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao enviar o e-mail. \n"+ex);
        }        
    }
    
    public void enviaSenha (JFrame tela, String user, String Email) {
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.hostinger.com.br");
        email.setSmtpPort(587);                
        email.setAuthenticator(new DefaultAuthenticator("contato@uniunjuntas.com.br", "x96q12r57"));
        email.setSSLOnConnect(true);
        
            try{               
                //estrutura do e-mail
                email.setFrom("contato@uniunjuntas.com.br"); //remetente
                email.setSubject("Pedido de recuperação de senha");  //assunto
                email.setMsg("Nome de usuário: "+user+"\n E-mail: "+Email); //mensagem
                email.addTo(Email); //destinatario
                
                email.send();
                JOptionPane.showMessageDialog(tela, "E-Mail enviado com sucesso");
            } catch (EmailException ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao enviar o e-mail. \n"+ex);
        }        
    }    
}
