package qe.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by ymenuhin on 7/16/2017.
 */
@Aspect
@Component
public class MethodLoggingAspect {

//    @Before(value = "execution(* qe.*.get*())")
//    public void getterMethodAdvice(JoinPoint joinPoint) {
//        System.out.println("Execution getter: " + joinPoint.getTarget());
//    }

    @Around(value = "execution(* qe.*.get*())")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.format("Getter execution time: %s , %d millisecond\n", pjp.getTarget(), endTime - startTime);
        return retVal;
    }
}
