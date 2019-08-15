Spring Boot Consul Registry Server
====================================

### Setup

* Start Consul agent in Docker
```
$ docker-compose up -d
```

* Execute TerraForm plan
```
$ terraform apply
```

* Start Spring Boot Application. 

* Visit http://localhost:8500/ui/  to check service and KV data

### Tools

* DNS
```
dig @127.0.0.1 -p 8600 httpbin.org. ANY
```

### References

* Consul Connect with Envoy and Docker: https://medium.com/@abhinavsonkar/consul-connect-with-envoy-and-docker-dc0cf53b8c1a
* Spring Cloud Consul: https://cloud.spring.io/spring-cloud-consul/single/spring-cloud-consul.html
* Consul: https://www.consul.io/
* Terraform Consul provider： https://www.terraform.io/docs/providers/consul/index.html

