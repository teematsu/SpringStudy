package springstudy.sample1;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * prototypeスコープのBeanで、proxy無し。
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.NO)
public class NoProxyPrototypeScopeBean {
    public int getIdentityHashCode() {
        return System.identityHashCode(this);
    }
}
