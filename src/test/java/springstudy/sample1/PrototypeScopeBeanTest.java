package springstudy.sample1;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * proxy有りのprototypeを呼び出した場合の動作。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml"})
public class PrototypeScopeBeanTest {
    @Autowired
    SingletonScopeBean singletonScopeBean;
    @Autowired
    AnotherSingletonScopeBean anothorSingletonScopeBean;
    
    @Test
    public void singletonを2度呼び出すと同じインスタンスが呼び出される() {
        int id1 = singletonScopeBean.getIdentityHashCode();
        int id2 = singletonScopeBean.getIdentityHashCode();
        assertThat(id1, is(id2));
    }

    @Test
    public void singleton経由でprototypeを2度呼び出すと別のインスタンスが呼び出される() {
        int id1 = singletonScopeBean.getPrototypeScopeBeanIdentity();
        int id2 = singletonScopeBean.getPrototypeScopeBeanIdentity();
        assertThat(id1, is(not(id2)));
    }
    
    @Test
    public void singletonからでprototypeを2度呼び出すと別のインスタンスが呼び出される() {
        int[] ids = singletonScopeBean.getPrototypeScopeBeanIdentityTwice();
        assertThat(ids[0], is(not(ids[1])));
    }

    @Test
    public void 異なるsingletonを呼び出せば別のインスタンスが呼び出される_当たり前だけれども() {
        int id1 = singletonScopeBean.getIdentityHashCode();
        int id2 = anothorSingletonScopeBean.getIdentityHashCode();
        assertThat(id1, is(not(id2)));
    }
    

    @Test
    public void 異なるsingletonからprototypeを呼び出すと別のインスタンスが呼び出される() {
        int id1 = singletonScopeBean.getPrototypeScopeBeanIdentity();
        int id2 = anothorSingletonScopeBean.getPrototypeScopeBeanIdentity();
        assertThat(id1, is(not(id2)));
    }

}