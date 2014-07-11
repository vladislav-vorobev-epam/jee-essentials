#!/bin/bash -eux

echo '==> Perform provisionning using Chef'
echo "gem: --no-ri --no-rdoc" > ~/.gemrc

echo '==> Installation of dev tools'
yum install -y gcc make gcc-c++ kernel-devel-`uname -r` zlib-devel openssl-devel readline-devel sqlite-devel perl dkms unzip vim git mc

echo '==> Run provision recipes'
LANGUAGE=en_US LC_CTYPE=en_US chef-solo -c /tmp/chef/solo.rb -j /tmp/chef/dev_node.json -o "role[dev_role]"


