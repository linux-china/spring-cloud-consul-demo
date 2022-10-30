package org.mvnsearch;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.NewCheck;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ecwid.consul.v1.kv.model.GetBinaryValue;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * consul client test
 *
 * @author linux_china
 */
public class ConsulClientTest {

    private ConsulClient client = new ConsulClient("localhost");

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testKVOperation() {
        String key = "nick";
        String value = "雷卷";
        client.setKVBinaryValue(key, value.getBytes());
        Response<GetBinaryValue> kvBinaryValue = client.getKVBinaryValue(key);
        System.out.println(new String(kvBinaryValue.getValue().getValue()));
    }

    @Test
    public void testRegisterServices() {
        NewService service1 = new NewService();
        service1.setId("myapp:192.168.0.46:8081");
        service1.setName("myapp");
        service1.setAddress("192.168.0.46");
        service1.setPort(8081);
        client.agentServiceRegister(service1);
        NewService service2 = new NewService();
        service2.setId("myapp:192.168.0.46:8082");
        service2.setName("myapp");
        service2.setAddress("192.168.0.46");
        service2.setPort(8082);
        client.agentServiceRegister(service2);
    }

    @Test
    public void testRegisterHttpBinService() {
        NewService service1 = new NewService();
        service1.setId("httpbin.org");
        service1.setName("httpbin.org");
        service1.setAddress("54.173.32.212");
        service1.setPort(80);
        NewService.Check check = new NewService.Check();
        check.setHttp("http://httpbin.org/status/200");
        check.setInterval("10s");
        check.setTimeout("2s");
        service1.setCheck(check);
        client.agentServiceRegister(service1);
    }

    @Test
    public void testQueryServices() {
        Response<List<HealthService>> healthServices = client.getHealthServices("httpbin.org", true, null);
        for (HealthService healthService : healthServices.getValue()) {
            System.out.println(healthService.getService().getId());
        }
    }

    @Test
    public void testDeregister() {
        client.agentServiceDeregister("myapp:192.168.0.46:8081");
        client.agentServiceDeregister("myapp:192.168.0.46:8082");
    }

    @Test
    public void testCheck() {
        NewCheck check = new NewCheck();
        check.setId("mvnsearch");
        check.setName("mvnsearch http service");
        check.setHttp("http://www.mvnsearch.org/health.json");
        check.setInterval("10s");
        check.setTimeout("2s");
        client.agentCheckRegister(check);
    }

    @Test
    public void testUnCheck() {
        client.agentCheckDeregister("mvnsearch");
    }
}
