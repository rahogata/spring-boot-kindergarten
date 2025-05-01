package in.co.rahogata.condition;

import in.co.rahogata.annotation.EnablePrint;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Optional;

public class EnablePrintCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
         return context.getBeanFactory().getBeansWithAnnotation(EnablePrint.class).entrySet().stream().findFirst().isPresent();
    }
}
