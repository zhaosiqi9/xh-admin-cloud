package com.xh.common.core.aspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 10:22
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    public static final List<String> SKIP_METHOD_REGEX = List.of(".*import.*", ".*export.*", ".*download.*", ".*upload.*");

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new NamedThreadLocal<>("Cost Time");

    @Pointcut("@annotation(com.xh.common.core.annotation.Log)")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    @AfterReturning(pointcut = "pointCut()", returning = "jsonResult")
    public void after(JoinPoint joinPoint, Object jsonResult) {
        printLog(joinPoint, jsonResult, null);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        printLog(joinPoint, null, e);
    }

    private void printLog(JoinPoint joinPoint, Object jsonResult, Exception ex1) {
        try {
            long nextId = IdUtil.getSnowflakeNextId();
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            log.info("{}【请求】{} {} ", nextId, className, methodName);

            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

            Map<String, String[]> requestParamMap = request.getParameterMap();
            if (CollUtil.isNotEmpty(requestParamMap)) {
                String requestArgs = JSON.toJSONString(requestParamMap);
                log.info("{}【参数】{}", nextId, requestArgs);
            }
            if (StrUtil.equalsIgnoreCase(request.getHeader("Content-Type"), "application/json")) {
                Object[] args = joinPoint.getArgs();
                if (ArrayUtil.isNotEmpty(args)) {
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse) {
                            continue;
                        }
                        log.info("{}【参数{}】{}", nextId, i, JSON.toJSONString(args[i]));
                    }
                }
            }

            if (jsonResult != null) {
                log.info("{}【返回】{}", nextId, JSON.toJSONString(jsonResult));
            }
            if (ex1 != null) {
                log.error("【异常】{}", ex1.getMessage());
            }
            log.info("{}【耗时】{} ms", nextId, System.currentTimeMillis() - TIME_THREADLOCAL.get());
        } catch (Exception e) {
            log.error("【日志异常】{}", e.getMessage(), e);
        } finally {
            TIME_THREADLOCAL.remove();

        }
    }

}
