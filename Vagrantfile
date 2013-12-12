# -*- mode: ruby -*-
# vi: set ft=ruby :

project_key = 'jee'

Vagrant.configure("2") do |config|

  config.vm.hostname = "#{project_key}.vm.local"

  config.vm.define 'ubuntu1310-server' do |c|
    c.vm.box = "ubuntu1310-server"
  end

  #config.vm.network :forwarded_port, guest: 8080, host: 8181

  config.vm.network :private_network, ip: "192.168.100.19"

  # config.vm.synced_folder "../data", "/vagrant_data"

  config.vm.provider :virtualbox do |vb|
    # Don't boot with headless mode
    vb.gui = false

    vb.customize ["modifyvm", :id, "--memory", "1048"]
    vb.customize ["modifyvm", :id, "--cpus", 4]
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
      :maven => {'3' => {:version=>'3.0.5'}},
      :java => {:jdk_version => 7, :install_flavor => 'oracle'},
      :mysql => {:server_debian_password => '123456', :server_root_password => '123456', :server_repl_password => '123456',
        :tunable => {:innodb_flush_method => 'O_DIRECT'}}
    }
  end
end
