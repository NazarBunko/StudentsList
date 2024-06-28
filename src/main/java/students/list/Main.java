package students.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Component
public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Properties properties = new Properties();
        InputStream input = Files.newInputStream(Paths.get(".properties"));
        properties.load(input);

        MainWindow window = context.getBean("mainWindow", MainWindow.class);
        window.setSize(Integer.parseInt(properties.getProperty("${mainWindow.width}")), Integer.parseInt(properties.getProperty("${mainWindow.height}")));

        context.close();
    }
}
