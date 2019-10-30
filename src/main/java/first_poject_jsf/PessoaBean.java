package first_poject_jsf;

import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

import org.w3c.dom.html.HTMLButtonElement;

@SessionScoped
@ManagedBean(name = "pessoaBean")

public class PessoaBean {
	
	private String nome;
	private String sobreNome;
	private String nomeCompleto;
	private List<String> nomes = new ArrayList<String>();
	private HtmlCommandButton commandButton;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto =  nomeCompleto;
	}
	
	public String concatenarNomes() {
		this.nomeCompleto = this.nome + " " + this.sobreNome;
		nomes.add(this.nomeCompleto);
		
		//Disabilitar Botao
		if(nomes.size() > 3) {
			commandButton.setDisabled(true);
			return "index?faces-redirect=true";
		}
		return null;
	}
	
	public List<String> getNomes() {
		return nomes;
	}
	
	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	
	public void limparLista() {
		nomes.clear();
		commandButton.setDisabled(false);
	}
}
