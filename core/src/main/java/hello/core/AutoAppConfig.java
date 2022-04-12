package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // member 만 컴포넌트 스캔의 대상이 됨
        // basePackages = {"hello.core", "hello.service"} 가능
        // 디폴트 시작 위치는 현재 클래스의 패키지 즉 hello.core
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
