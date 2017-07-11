package org.william.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.william.service.CacheDataService;

/**
 * Created by huawai on 2017/7/11. Description:
 */
@Aspect
@Component
public class CacheDataAspect {

    @Before("@annotation(cacheData)")
    public void cacheDataBefore(JoinPoint joinPoint, CacheData cacheData) {
        Object[] args = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        for (int i = 0; i < args.length; i++) {
            Annotation[][] annotations = method.getParameterAnnotations();
            Annotation[] annotationArray = annotations[i];
            for (Annotation annotation : annotationArray) {
                if (annotation instanceof CacheDataParam) {
                    Object arg = args[i];
                    Class clazz = cacheData.handleClass();
                    try {
                        Method reflectMethod = clazz.getMethod(cacheData.handleMethodName(),
                                Object.class);
                        reflectMethod.invoke(new CacheDataService(), arg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
