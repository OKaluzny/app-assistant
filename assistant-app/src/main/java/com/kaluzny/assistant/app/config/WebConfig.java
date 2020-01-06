package com.kaluzny.assistant.app.config;

import com.kaluzny.assistant.app.utils.converter.PageRequestArgumentResolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Web configuration.
 *
 * @author Oleg Kaluzny
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageRequestArgumentResolver());
    }

    private PageRequestArgumentResolver pageRequestArgumentResolver() {
        return new PageRequestArgumentResolver();
    }
}
