****************
jee-essentials
****************

Source code for JEEEssentials training

=================
JBoss Management
=================

Add admin user::

  ./jboss-eap-6.2/bin/add-user.sh -u admin -p admin_123

Start::

  ./jboss-eap-6.2/bin/standalone.sh --debug -b 0.0.0.0 -bmanagement=0.0.0.0 -c standalone-full.xml

Deployment::

  mvn clean jboss-as:deploy -s settings.xml

Undeployment::

  mvn jboss-as:undeploy -s settings.xml

=================
JBoss Management Console
=================

Open in browser: http://192.168.56.102:9990/


=================
Build Box
=================

/opt/chef/embedded/bin/gem install berkshelf
/opt/chef/embedded/bin/berks vendor --debug /tmp/ext_cookbooks

make vmware/centos65
vagrant box add centos-jee.box --provider vmware_desktop ~/Downloads/centos-jee.box
mv box/vmware/centos65-cheflatest.box ~/Downloads/centos-jee.box
