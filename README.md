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

### References

* Spring Cloud Consul: http://cloud.spring.io/spring-cloud-static/spring-cloud-consul/2.0.0.RC1/single/spring-cloud-consul.html
* Consul: https://www.consul.io/
* Terraform Consul provider： https://www.terraform.io/docs/providers/consul/index.html

