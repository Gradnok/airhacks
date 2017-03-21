
package com.airhacks.pizza.configuration.boundary;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Produces
    public String expose(InjectionPoint ip) {
        /**
         * Annotated annotated = ip.getAnnotated();        RaphaelConfigurationProperty defaultValue = annotated.getAnnotation(RaphaelConfigurationProperty.class);
        if (defaultValue != null) {
            defaultValue.propertyName() }
        *
         */
        String fieldName = ip.getMember().getName();
        return System.getenv().getOrDefault(fieldName, "2");
    }


}
