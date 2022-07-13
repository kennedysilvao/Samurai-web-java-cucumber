package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.DashPage;
import pages.LoginPage;
import utilitarios.Utils;

public class UserAuthenticateWithCredentialsIncorrectsSteps {

    LoginPage loginPage = new LoginPage();

    @Quando("informo o nome do usuário com algum erro {string}")
    public void informoONomeDoUsuárioUsuario(String usuario) {
        loginPage.preencherCampoLogin(usuario);
    }

    @E("informo a senha do usuário com algum erro {string}")
    public void informoASenhaDoUsuárioSenha(String senha) {
        loginPage.preencherCampoSenha(senha);
        Utils.logPrint("Dados inválidos");
    }
    @Então("vejo o resultado esperado {string}")
    public void vejoOResultadoEsperadoResultado(String alertMsg) {
        String validarMsg = loginPage.alertaDeMensagem();
        Assert.assertEquals(alertMsg, validarMsg);
        Utils.logPrint("Mensagem de Alerta");
    }
}

