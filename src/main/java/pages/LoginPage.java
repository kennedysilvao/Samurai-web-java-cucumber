package pages;

import org.openqa.selenium.By;

import static steps.Hooks.driver;
import static steps.Hooks.urlBase;


public class LoginPage {

    public void acessarPaginaLogin() {
        driver.get(urlBase + "/");
    }

    public void preencherCampoLogin(String usuario) {
        driver.findElement(By.cssSelector("input[placeholder$=email]")).sendKeys(usuario);
    }

    public void preencherCampoSenha(String senha) {
        driver.findElement(By.cssSelector("input[placeholder$=secreta]")).sendKeys(senha);
    }

    public void submeterLogin() {
        driver.findElement(By.xpath("//button[text()='Entrar']")).click();
    }

    public String alertaDeMensagem() {
        return driver.findElement(By.xpath("//small[@class='alert-error']")).getText();
    }
}
