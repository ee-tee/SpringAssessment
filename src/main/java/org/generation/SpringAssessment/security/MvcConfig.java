package org.generation.SpringAssessment.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        //We can register view that create a direct mapping between the URL and the view name (.html)
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/todolist").setViewName("todolist");
        registry.addViewController("/newtaskform").setViewName("newtaskform");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //Expose the images, js, css resources to the client (browser) so that they can access the static folders / necessary files to display
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

}

//Reference Link: https://spring.io/guides/gs/securing-web/
