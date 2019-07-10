package org.mvnsearch;

import com.pszymczyk.consul.ConsulProcess;
import com.pszymczyk.consul.junit.ConsulExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**                           
 * Consul integration test
 *
 * @author linux_china
 */
@ExtendWith(ConsulExtension.class)
public class ConsulIntegrationTest {
    @Test
    void test(ConsulProcess consul) {
        System.out.println(consul.getHttpPort());
    }
}
