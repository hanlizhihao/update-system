package com.thinking.update.main;

import com.thinking.update.main.common.handler.ApiResponseHandler;
import lombok.Setter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

/**
 * @author Administrator
 */
@EnableTransactionManagement
@ServletComponentScan
@EnableSwagger2
@MapperScan(basePackages = {"com.thinking.update.main.dao", "com.thinking.update.common.dao", "com.thinking.update.*.dao"})
@SpringBootApplication
@ConfigurationProperties(prefix = "app")
@ComponentScan(basePackages = {"com.thinking.update.main", "com.thinking.update.common"})
public class UpdateMainApplication extends WebMvcConfigurerAdapter {

    private static final String LANGUAGE = "language";

    @Setter
    private Boolean swaggerEnabled;

    public static void main(String[] args) {
        SpringApplication.run(UpdateMainApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error/403.html").setViewName("403.html");
        registry.addViewController("/error/404.html").setViewName("404.html");
        registry.addViewController("/error/500.html").setViewName("500.html");
        registry.addViewController("/error/401.html").setViewName("401.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }


    /**
     * 同一结果包装
     * @return
     */
    @Bean
    public InitializingBean apiSupport() {
        return new InitializingBean() {
            @Autowired
            private RequestMappingHandlerAdapter adapter;

            @Override
            public void afterPropertiesSet() throws Exception {
                List<HandlerMethodReturnValueHandler> nHanders = new ArrayList<>(adapter.getReturnValueHandlers());
                nHanders.add(0, new ApiResponseHandler(adapter.getMessageConverters()));
                adapter.setReturnValueHandlers(nHanders);
            }
        };
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return configurableEmbeddedServletContainer -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
            ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
            configurableEmbeddedServletContainer.addErrorPages(error401Page, error403Page, error404Page, error500Page);
        };
    }

    /**
     * cookie区域解析器
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver slr = new CookieLocaleResolver();
        slr.setDefaultLocale(Locale.CHINA);
        //设置cookie有效期.
        slr.setCookieMaxAge(3600);
        slr.setCookieName(LANGUAGE);
        return slr;
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .apiInfo(ApiInfo.DEFAULT)
                .produces(newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessages())
                .globalResponseMessage(RequestMethod.POST, responseMessages())
                .globalResponseMessage(RequestMethod.DELETE, responseMessages())
                .globalResponseMessage(RequestMethod.PATCH, responseMessages())
                .globalResponseMessage(RequestMethod.PUT, responseMessages());
    }

    private List<ResponseMessage> responseMessages() {

        Map<String, Header> headers = newHashMap();
        headers.put("Location", new Header("Location", "登录URL", new ModelRef("")));

        return newArrayList(
                new ResponseMessageBuilder()
                        .code(400)
                        .message("请求参数没填好")
                        .build(),
                new ResponseMessageBuilder()
                        .code(401)
                        .message("未授权，需要重新登录")
                        .headersWithDescription(headers)
                        .build(),
                new ResponseMessageBuilder()
                        .code(403)
                        .message("无权限!")
                        .build(),
                new ResponseMessageBuilder()
                        .code(404)
                        .message("请求路径没有或页面跳转路径不对")
                        .build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("服务器端错误")
                        .responseModel(new ModelRef("Errors"))
                        .build());
    }
}
