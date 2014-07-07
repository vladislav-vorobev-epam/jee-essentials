base_path = '/tmp'
file_cache_path "/var/chef-solo"
cookbook_path [
               "#{base_path}/chef/cookbooks",
               "#{base_path}/chef/ext_cookbooks"
              ]
role_path [ "#{base_path}/chef/roles" ]
# log_level :debug
