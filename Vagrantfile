# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  config.vm.box_url = "http://cloud-images.ubuntu.com/vagrant/saucy/current/saucy-server-cloudimg-amd64-vagrant-disk1.box"
  config.vm.box = "ubuntu-13.10"

  #config.vm.network :forwarded_port, guest: 8080, host: 8181

  config.vm.network :private_network, ip: "192.168.56.19"

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
                     "recipe[polyglot::java]"
                    ]
    chef.json = {
      :maven => {'3' => {:version=>'3.0.5'}},
      :java => {:jdk_version => 7}
    }
  end
end
