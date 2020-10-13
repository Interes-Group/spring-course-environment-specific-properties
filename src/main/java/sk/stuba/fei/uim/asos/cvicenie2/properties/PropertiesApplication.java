package sk.stuba.fei.uim.asos.cvicenie2.properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.logging.Logger;

public class PropertiesApplication {

    private static final Logger log = Logger.getLogger(PropertiesApplication.class.getSimpleName());

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        ConfigurableEnvironment environment = appContext.getEnvironment();
        environment.setActiveProfiles("dev");
        appContext.refresh();

        MongoRepository bean = appContext.getBean(MongoRepository.class);
        log.info(bean.toString());
    }
}
