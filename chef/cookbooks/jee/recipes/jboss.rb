#
# Cookbook Name:: chef/cookbooks/jee
# Recipe:: jboss
#

bash "download JBoss" do
  cwd '/opt'
  code <<-EOF
    wget -c http://webdizz.name/jeeessentials/jboss-eap-6.2.0.zip
  EOF
  not_if { ::File.exists?('/opt/jboss-eap-6.2.0.zip') }
end