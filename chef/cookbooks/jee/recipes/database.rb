#
# Cookbook Name:: chef/cookbooks/jee
# Recipe:: database
#

include_recipe 'mysql::server'
include_recipe 'database::mysql'

mysql_root_connection_info = {
  :host => 'localhost',
  :username => 'root',
  :password => node['mysql']['server_root_password']
}

mysql_database_user 'root' do
  connection mysql_root_connection_info
  host "#{node['jee']['host']['ip']}"
  password node['mysql']['server_root_password']
  privileges [:all]
  grant_option true
  action [:create, :grant]
end

mysql_database_user 'root' do
  connection mysql_root_connection_info
  host 'localhost'
  password node['mysql']['server_root_password']
  privileges [:all]
  grant_option true
  action [:create, :grant]
end

privileges_list = [:select,:update,:insert,:create,:delete,:alter,:index,:execute,:drop]

def create_convention_name name, env_name
  default_name = name
  name = env_name.empty? ? default_name : "#{default_name}_#{env_name}"
end

node['jee']['envs'].each do |env_name|
  node['jee']['database']['dbnames'].each do |dbname|
    database_name = create_convention_name dbname, env_name
    user_name = create_convention_name node['jee']['database']['username'], env_name
    password = create_convention_name node['jee']['database']['password'], env_name

    mysql_database database_name do
      connection mysql_root_connection_info
      action :create
    end

    node['jee']['database']['ips'].each do |ip|
      mysql_database_user user_name do
        connection mysql_root_connection_info
        host "#{ip}"
        password password
        database_name database_name
        privileges privileges_list
        grant_option true
        action [:create, :grant]
      end
    end
  end

end
