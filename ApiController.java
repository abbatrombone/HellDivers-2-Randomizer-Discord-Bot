package me.abbatrombone.traz;

import org.apache.commons.lang.SystemUtils;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@RestController
public class ApiController {

    private final Environment env;

    public ApiController(Environment env) {
        this.env = env;
    }
    @GetMapping("/")
    public String home(){
        return env.getProperty("appapikey");
    }

public static String systemFilePath() {
    String filePath = System.getProperty("user.home");
    String os = SystemUtils.OS_NAME;
    if (os.equals("Linux")) {
        //filePath = filePath + "/.local/share/HellDiversLoadOut";
        filePath = "/home/trazodone/Java_Files/Prj/HellDiversLoadOut";
    } //
    if(SystemUtils.IS_OS_MAC){filePath = "/HellDiversLoadOut";}
    if(SystemUtils.IS_OS_WINDOWS){filePath = "/Library/Applications Support/HellDiversLoadOut";}

    return filePath;
    }

    public static String key() {

        StringBuilder contentBuilder = new StringBuilder();
        {
            try (Stream<String> stream = Files.lines(Paths.get(systemFilePath() + "/api.txt"), StandardCharsets.UTF_8)) {
                stream.forEach(s -> contentBuilder.append(s));
            } catch (IOException e) {
                System.out.println("Expection with File Reader");
            }
        }
        return contentBuilder.toString();
    }

}
