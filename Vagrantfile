# -*- mode: ruby -*-
# vi: set ft=ruby :

project_key = 'jee'
vm_ip = "192.168.56.102"

Vagrant.configure("2") do |config|

  config.vm.hostname = "#{project_key}.vm.local"

  config.vm.define project_key do |c|
    c.vm.box = 'centos65-jeeessentials.box'
    c.vm.box_url = 'http://webdizz.name/vm_image/centos65-jeeessentials.box'
  end

  #config.vm.network :forwarded_port, guest: 8080, host: 8181
  config.ssh.username = 'dev'
  config.vm.network :private_network, ip: vm_ip

  # config.vm.synced_folder "../data", "/vagrant_data"

  config.vm.provider :virtualbox do |vb|
    # Don't boot with headless mode
    vb.gui = false
    vb.customize ["modifyvm", :id, "--memory", "2048"]
    vb.customize ["modifyvm", :id, "--cpus", 4]
  end

  config.vm.provider "vmware_fusion" do |v|
    v.vmx["memsize"] = "2048"
    v.vmx["numvcpus"] = 4
    v.vmx["ethernet0.virtualDev"] = "vmxnet3"
    v.synced_folder "./", "/vagrant", mount_options:['ttl=3']
  end

  config.ssh.forward_agent = true

end
