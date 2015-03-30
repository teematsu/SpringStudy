package springstudy.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AnotherSingletonScopeBean {
    @Autowired
    PrototypeScopeBean prototypeScopeBean;
    @Autowired
    NoProxyPrototypeScopeBean noProxyPrototypeScopeBean;

    
    public int getIdentityHashCode() {
        return System.identityHashCode(this);
    }

    /*
     * proxy有りのprototypeを呼び出す。
     */

    public int getPrototypeScopeBeanIdentity() {
        return prototypeScopeBean.getIdentityHashCode();
    }
    
    /*
     * proxy無しのprototypeを呼び出す。
     */

    public int getNoProxyPrototypeScopeBeanIdentity() {
        return noProxyPrototypeScopeBean.getIdentityHashCode();
    }

}
