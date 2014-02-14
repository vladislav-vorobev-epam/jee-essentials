# -*- mode: ruby -*-
# vi: set ft=ruby :

project_key = 'jee'
vm_ip = "192.168.56.102"

Vagrant.configure("2") do |config|

  config.vm.hostname = "#{project_key}.vm.local"

  config.vm.define project_key do |c|
    c.vm.box = 'dev.vm.centos65.box'
    c.vm.box_url = 'http://webdizz.name/vm_image/dev.vm.centos65.box'
  end

  #config.vm.network :forwarded_port, guest: 8080, host: 8181

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

  # Ensure a recent version of the Chef Omnibus packages are installed
  config.omnibus.chef_version = :latest

  # Enable the berkshelf-vagrant plugin
  config.berkshelf.enabled = true

  config.ssh.forward_agent = true

  # prepare VM to be an Omnibus builder

  config.vm.provision :chef_solo do |chef|
    chef.run_list = [
                     'recipe[polyglot::java]',
                     'recipe[ant::install_package]',
                     'recipe[git]',
                     'recipe[subversion::client]',
                     'recipe[riot_mysql::server]'
                    ]
    chef.json = {
      :maven => {'3' => {:version=>'3.1.1'}},
      :ant => {:install_method => 'source'},
      :java => {:jdk_version => 7, :install_flavor => 'oracle'},
      :mysql => {:server_debian_password => '123456', :server_root_password => '123456', :server_repl_password => '123456',
        :bind_address => vm_ip,
        :tunable => {:innodb_flush_method => 'O_DIRECT', :bind_address => vm_ip, :wait_timeout => 28800, :query_cache_size => '32M', :long_query_time => 1, :innodb_buffer_pool_size => '200M', :max_connections => 1000}}
    }
  end
end
