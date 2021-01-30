/**
 * 
 */
package in.co.rahogata.yaml.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiva
 *
 */
@RestController
public class YamlPropertyDisplayer {

    @Value("${info.app.version}")
    private String version;

    private Environment env;

    @Autowired
    public YamlPropertyDisplayer(Environment env) {
        this.env = env;
    }

    @GetMapping("/show")
    public Map<String, Object> displayYamlProperties() {
        Map<String, Object> result = new HashMap<>();
        result.put("info.app.name", env.getProperty("info.app.name"));
        result.put("info.app.version", version);
        result.put("service.id", env.getProperty("service.id"));
        return result;
    }
}
