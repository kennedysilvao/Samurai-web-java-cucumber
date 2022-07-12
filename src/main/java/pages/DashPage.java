package pages;

import org.openqa.selenium.By;
import static steps.Hooks.driver;

public class DashPage {

    public String verificarUsuarioLogado() {
        return driver.findElement(By.xpath("//strong[text()='teste2']")).getText();
    }
}
