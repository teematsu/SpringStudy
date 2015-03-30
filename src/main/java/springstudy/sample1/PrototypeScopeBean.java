package springstudy.sample1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * prototypeスコープのBeanで、proxy有り。
 */
@Component
@Scope(value = "prototype")
public class PrototypeScopeBean {
    public int getIdentityHashCode() {
        return System.identityHashCode(this);
    }
}
