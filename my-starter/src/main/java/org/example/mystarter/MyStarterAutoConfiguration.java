package org.example.mystarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ConditionalOnWebApplication  //确保只有在 Web 应用程序中才会启用此自动配置
@Import(MyController.class)   //将MyController导入到自动配置类中
public class MyStarterAutoConfiguration {
}
