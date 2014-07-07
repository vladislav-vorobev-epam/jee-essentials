default['jee']['app_dir'] = '/vagrant'

default['jee']['host']['ip'] = '192.168.56.102'

# Database related configuration
default['jee']['database']['host'] = node['mysql']['bind_address']
default['jee']['database']['username'] = 'todo'
default['jee']['database']['password'] = 'todo'
default['jee']['database']['dbnames'] = ['todo']

default['jee']['envs'] = ['']
default['jee']['database']['ips'] = [
                                       'localhost',
                                       '192.168.56.1',
                                       node['mysql']['bind_address']
                                      ]

