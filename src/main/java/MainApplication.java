import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class MainApplication extends Application<SampleConfig> {
    public static void main(String[] args) throws Exception {
        System.out.println("hi folks");
        System.out.println(args[0]+"   "+args[1]);
        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "MainApplication";
    }

    @Override
    public void initialize(Bootstrap<SampleConfig> bootstrap) {
        System.out.println("initializing");
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);

    }

    @Override
    public void run(SampleConfig configuration,
                    Environment environment) {
        System.out.println("running server");

        final AddResource resource = new AddResource(
                configuration.getFirstNumber(),
                configuration.getSecondNumber()
        );
        environment.jersey().register(resource);
    }

}