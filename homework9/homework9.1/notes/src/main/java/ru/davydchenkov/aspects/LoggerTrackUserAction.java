package ru.davydchenkov.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggerTrackUserAction {

    @Pointcut("execution(* ru.davydchenkov.service.NoteService.*(..))")
    public void logNoteServiceMethodPointCut(){
    }

    @Before("logNoteServiceMethodPointCut()")
    public void beforeTestServiceBean(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        System.out.printf("Действие пользователя: Метод %s в классе %s вызывается с аргументами: %s",
                methodName, className, Arrays.toString(args));
    }

    @AfterReturning(value = "logNoteServiceMethodPointCut()", returning = "result")
    public void afterReturningTestServiceBean(JoinPoint joinPoint, Object result){
        log.info("Result: {}", result);
    }

    @AfterThrowing(value = "logNoteServiceMethodPointCut()", throwing = "e")
    public void afterReturningTestServiceBean(Throwable e){
        log.error("Exception: {} - {}", e.getClass(), e.getMessage());
    }
}
