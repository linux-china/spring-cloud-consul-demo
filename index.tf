# Configure the Consul provider
provider "consul" {
  address = "localhost:8500"
  datacenter = "DC1"
}

resource "consul_key_prefix" "user-service-config" {

  # Prefix to add to prepend to all of the subkey names below.
  path_prefix = "config/user-service/"

  subkeys = {
    "company" = "mvnsearch.org"
    "admin" = "linux_china"
  }
}