package com.xiasheng.medical.dietitian;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:/config/spring/local/appcontext-*.xml",
        "classpath*:/config/spring/*.*"})
public abstract class GenericTest {

    public String obj2str(Object object) {
        if (object != null) {
            return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
        } else {
            return "null";
        }
    }
}
