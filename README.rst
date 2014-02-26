****************
jee-essentials
****************

Source code for JEEEssentials training

=================
JBoss Management
=================

Add admin user::

  ./jboss-eap-6.1/bin/add-user.sh -u admin -p admin_123

Start::

  ./jboss-eap-6.1/bin/standalone.sh --debug -b 0.0.0.0 -bmanagement=0.0.0.0 -c standalone-full.xml


=================
JBoss Management Console
=================

Open in browser: http://192.168.56.102:9990/
