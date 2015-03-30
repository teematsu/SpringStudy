package springstudy.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonScopeBean {
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
    
    public int[] getPrototypeScopeBeanIdentityTwice() {
        int id1= prototypeScopeBean.getIdentityHashCode();
        int id2= prototypeScopeBean.getIdentityHashCode();
        return new int[]{id1, id2};
    }

    
    /*
     * proxy無しのprototypeを呼び出す。
     */

    public int getNoProxyPrototypeScopeBeanIdentity() {
        return noProxyPrototypeScopeBean.getIdentityHashCode();
    }
    
    public int[] getNoProxyPrototypeScopeBeanIdentityTwice() {
        int id1= noProxyPrototypeScopeBean.getIdentityHashCode();
        int id2= noProxyPrototypeScopeBean.getIdentityHashCode();
        return new int[]{id1, id2};
    }
    
}
