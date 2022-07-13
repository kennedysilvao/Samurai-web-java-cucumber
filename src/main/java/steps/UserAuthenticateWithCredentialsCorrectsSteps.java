package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.DashPage;
import pages.LoginPage;
import utilitarios.Utils;

public class UserAuthenticateWithCredentialsCorrectsSteps {

    LoginPage loginPage = new LoginPage();

    @Dado("que acesso a página de login")
    public void queAcessoAPáginaDeLogin() {
        loginPage.acessarPaginaLogin();
        Utils.logPrint("Acessar pagina principal");
    }

    @Quando("informo o nome do usuário {string}")
    public void informoONomeDoUsuário(String username) {
        loginPage.preencherCampoLogin(username);
    }
    @E("informo a senha do usuário {string}")
    public void informoASenhaDoUsuário(String pass) {
        loginPage.preencherCampoSenha(pass);
        Utils.logPrint("Preencher usuario e senha");
    }
    @E("clico no botão entrar")
    public void clicoNoBotãoEntrar() {
        loginPage.submeterLogin();
    }
    @Então("vejo o usuário logado")
    public void vejoOUsuárioLogado() {
        DashPage dashPage = new DashPage();
        String validarMsg = dashPage.verificarUsuarioLogado();
        Assert.assertEquals("teste2", validarMsg);
        Utils.logPrint("Usuario logado");
    }
}

