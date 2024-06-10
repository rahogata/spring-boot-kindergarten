package in.co.rahogata;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dwara {

    private static final Logger LOG = LoggerFactory.getLogger(Dwara.class);

    public static void main(String[] args) {
        LoggerContext cxt = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(cxt);
        LOG.info("Pre running app");
        SpringApplication.run(Dwara.class, args);
        LOG.info("Post running app");
    }
}
