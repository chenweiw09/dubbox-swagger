package io.hulk.dubbo.springfox.core.config;

import io.hulk.dubbo.springfox.core.common.DubboSpringfoxContants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Springfox配置类
 *
 * @author zhaojigang
 * @date 2018/4/18
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        final String serviceGroup = System.getProperty(DubboSpringfoxContants.SERVICE_GROUP, "dev");
        if (serviceGroup.equals(DubboSpringfoxContants.SERVICE_GROUP_PRODUCT)) {
            // 生产环境需要将swagger-ui中的接口信息隐藏
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.none())
                    .build();
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建rpc的api文档")
                .description("对rpc方法重新加载动态生成对应的controller类")
                .termsOfServiceUrl("")
                .version("1.0")
                .contact(new Contact("", "", ""))
                .build();
    }

}