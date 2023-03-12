package org.acme;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix="com.acme")
public interface MyConfig {
    @WithName("nombre")
    String nombre();

    @WithDefault("true")
    boolean isTrue();
}
