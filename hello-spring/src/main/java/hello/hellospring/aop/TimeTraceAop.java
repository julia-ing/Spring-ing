package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP 는 Aspect 적어줘야 하고
// 스프링 빈으로 등록해줘야 함 : @Component 해줘도 되는데 SpringConfig 에 @Bean 등록해주는 걸 선호
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // 타겟팅
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            // Object result = joinPoint.proceed(); // 다음 메서드로 진행
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
