package ro.mpp2025.proiectiss;

import org.springframework.context.ConfigurableApplicationContext;

public class SpringContextHelper {
    private static ConfigurableApplicationContext context;

    public static void setContext(ConfigurableApplicationContext ctx) {
        context = ctx;
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
