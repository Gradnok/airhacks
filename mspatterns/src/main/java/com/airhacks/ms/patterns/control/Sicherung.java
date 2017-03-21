
package com.airhacks.ms.patterns.control;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class Sicherung {

    AtomicLong ERROR_COUNTER = new AtomicLong(0);

    @AroundInvoke
    public Object check(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        try {
            if (ERROR_COUNTER.get() > 3) {
                System.out.println("circuit opened");
                return null;
            }
            return ic.proceed();
        } catch (Exception ex) {
            ERROR_COUNTER.incrementAndGet();
            System.out.println("Error happened: " + ERROR_COUNTER.get());
            throw ex;
        } finally {
            System.out.println("After method: " + method);
        }
    }


}
