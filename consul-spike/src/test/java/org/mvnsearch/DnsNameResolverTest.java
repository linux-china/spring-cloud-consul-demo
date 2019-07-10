package org.mvnsearch;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.resolver.dns.DnsNameResolver;
import io.netty.resolver.dns.DnsNameResolverBuilder;
import io.netty.resolver.dns.DnsServerAddressStreamProvider;
import io.netty.resolver.dns.SingletonDnsServerAddressStreamProvider;
import io.netty.util.concurrent.Future;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * DNS name resolver test
 *
 * @author linux_china
 */
public class DnsNameResolverTest {
    private String domainName = "httpbin.org";
    private String dnsServer = "127.0.0.1:8600";

    @Test
    public void testResolveDomain() throws Exception {
        DnsNameResolver resolver = newResolver(true).build();
        try {
            Future<InetAddress> resolve = resolver.resolve("user-service");
            System.out.println(resolve.sync().get());
        } finally {
            resolver.close();
        }

    }


    private static DnsNameResolverBuilder newResolver(boolean decodeToUnicode) {
        return newResolver(decodeToUnicode, null);
    }

    private static DnsNameResolverBuilder newResolver(boolean decodeToUnicode,
                                                      DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        final NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        final EventLoop next = nioEventLoopGroup.next();
        DnsNameResolverBuilder builder = new DnsNameResolverBuilder(next)
                .channelType(NioDatagramChannel.class)
                .maxQueriesPerResolve(1)
                .decodeIdn(decodeToUnicode)
                .optResourceEnabled(false)
                .ndots(1);
        builder.nameServerProvider(new SingletonDnsServerAddressStreamProvider(new InetSocketAddress("127.0.0.1", 8600)));
        return builder;
    }
}
