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

* Start Spring Boot App

* Visit http://localhost:8500/ui/  to check service and KV data

### References

* Spring Cloud Consul: http://cloud.spring.io/spring-cloud-static/spring-cloud-consul/1.2.1.RELEASE/
* Consul: https://www.consul.io/
* Terraform Consul provider： https://www.terraform.io/docs/providers/consul/index.html

