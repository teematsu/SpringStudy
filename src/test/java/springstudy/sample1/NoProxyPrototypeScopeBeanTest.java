package springstudy.sample1;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * proxy無しのprototypeを呼び出した場合の動作。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml"})
public class NoProxyPrototypeScopeBeanTest {
    @Autowired
    SingletonScopeBean singletonScopeBean;
    @Autowired
    AnotherSingletonScopeBean anothorSingletonScopeBean;
    

    @Test
    public void singleton経由でprototypeを2度呼び出すと同じインスタンスが呼び出される() {
        int id1 = singletonScopeBean.getNoProxyPrototypeScopeBeanIdentity();
        int id2 = singletonScopeBean.getNoProxyPrototypeScopeBeanIdentity();
        assertThat(id1, is(id2));
    }
    
    @Test
    public void singletonからでprototypeを2度呼び出すと同じインスタンスが呼び出される() {
        int[] ids = singletonScopeBean.getNoProxyPrototypeScopeBeanIdentityTwice();
        assertThat(ids[0], is(ids[1]));
    }

    @Test
    public void 異なるsingletonからprototypeを呼び出すと別のインスタンスが呼び出される() {
        int id1 = singletonScopeBean.getNoProxyPrototypeScopeBeanIdentity();
        int id2 = anothorSingletonScopeBean.getNoProxyPrototypeScopeBeanIdentity();
        assertThat(id1, is(not(id2)));
    }

}