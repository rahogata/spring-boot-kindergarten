package in.co.rahogata.preauthrestapi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;
import org.springframework.security.access.method.AbstractFallbackMethodSecurityMetadataSource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class DefaultMethodSecuritySource extends AbstractFallbackMethodSecurityMetadataSource  {

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    protected Collection<ConfigAttribute> findAttributes(Method method, Class<?> targetClass) {
        List<ConfigAttribute> attributes = new ArrayList<>();

        // if the class is annotated as @Controller we should by default deny access to every method
        if (AnnotationUtils.findAnnotation(targetClass, Controller.class) != null) {
            attributes.add(Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE);
        }
        Annotation preAuth = AnnotationUtils.getAnnotation(method, PreAuthorize.class);
        Annotation postAuth = AnnotationUtils.getAnnotation(method, PostAuthorize.class);
        if (preAuth != null || postAuth != null) {
            return null;
        }
        return attributes;
    }

    @Override
    protected Collection<ConfigAttribute> findAttributes(Class<?> clazz) {
        return null;
    }

    
}
