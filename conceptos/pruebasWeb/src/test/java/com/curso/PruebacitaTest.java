// Generated by Selenium IDE

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.net.*;
import java.util.Optional;
import java.nio.file.*;
import java.io.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PruebacitaTest {
  
  private WebDriver driver;

  @BeforeEach
  public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://54.229.30.127:4444/wd/hub"), capabilities );
  }
  
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  
  // EXCEL CSV 
  // Usuario.  Password
  //  x          √
  //  √          x
  //  x          x
  @ParameterizedTest
  @CsvFileSource(resources="/login_nok.csv", numLinesToSkip=1)
  public void loginNoExitoso(String usuario, String password) throws Exception{
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    //driver.manage().window().setSize(new Dimension(1561, 1406));
    // Boton reservar cita
    driver.findElement(By.id("btn-make-appointment")).click();

    // Rellenar el formulario de login
    driver.findElement(By.id("txt-username")).sendKeys(usuario);
    driver.findElement(By.id("txt-password")).sendKeys(password);

    capturarPantalla(driver, "login_nok_antes_"+usuario+"_"+password);

    driver.findElement(By.id("btn-login")).click();
    
    //*[@id="login"]/div/div/div[1]/p[2]
    String textoDevuelto= driver.findElement(By.xpath("//section[@id='login']//p[2]")).getText();
    Assertions.assertTrue(textoDevuelto.contains("Login failed"));
    capturarPantalla(driver, "login_nok_"+usuario+"_"+password);
  }
  
  
  @Test
  public void loginExitoso()throws Exception {
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    //driver.manage().window().setSize(new Dimension(1561, 1406));
    // Boton reservar cita
    driver.findElement(By.id("btn-make-appointment")).click();

    // Rellenar el formulario de login
    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    driver.findElement(By.id("btn-login")).click();
    
    String textoDevuelto= driver.findElement(By.xpath("//*[@id='appointment']/div/div/div/h2")).getText();
    Assertions.assertTrue(textoDevuelto.contains("Make Appointment"));
    capturarPantalla(driver, "login_ok");
    
  }
  public static void capturarPantalla(WebDriver driver, String nombre) throws Exception{
      TakesScreenshot capturador=(TakesScreenshot)driver;
      File imagen = capturador.getScreenshotAs(OutputType.FILE);
      Files.copy(imagen.toPath(), Paths.get("./"+nombre+".png"), StandardCopyOption.REPLACE_EXISTING);
  }

  
}
