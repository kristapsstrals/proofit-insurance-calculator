package proofit.insurance.calculator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import proofit.insurance.calculator.services.PremiumCalculator;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PremiumCalculator getPremiumCalculator() {
        return new PremiumCalculator();
    }
}
