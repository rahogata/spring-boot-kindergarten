/**
 * 
 */
package in.co.rahogata.yaml.config;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author shiva
 *
 */
@Component
public class YamlPropertiesCustomizer implements HibernatePropertiesCustomizer {

    private static final Logger LOG = LoggerFactory.getLogger(YamlPropertiesCustomizer.class);

    /**
     * @see org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer#customize(java.util.Map)
     */
    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        LOG.info(">>>>>>>> {}", hibernateProperties);
    }

}
