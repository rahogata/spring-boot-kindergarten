package in.co.rahogata.print;

import in.co.rahogata.annotation.ConditionalOnEnablePrint;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@ConditionalOnEnablePrint
@Service
public class PrintServiceImpl {

    @Autowired
    @Qualifier("printConfigs")
    private Map<String, String> printConfigs;

    @PostConstruct
    public void print() {
        log.info("printing with configs ... {}", printConfigs);
    }
}
