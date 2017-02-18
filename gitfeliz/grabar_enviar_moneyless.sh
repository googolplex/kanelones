#!/bin/bash
# hecho para mi pc de escritorio
# el 2017/01
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace.dist/kanelonesv1.dist/*.war  /home/xoldfusion/Downloads/kanelones2017/amazon2017llave/
cp -r /home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace/kanelonesv1  kanelones
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/server.xml kanelones/tomcatfeliz
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/context.xml kanelones/tomcatfeliz
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/web.xml kanelones/tomcatfeliz
cp *.sh kanelones/gitfeliz
# cp -r openshiftfeliz kanelones/
cp -r jasperfeliz kanelones/
cp  amazon2017llave/*.sh kanelones/amazon2017llave
cp  amazon2017llave/*.war kanelones/amazon2017llave
rm *.*~
rm kanelones/*.*~
cd kanelones
git add -A
git commit -a -m "creando la model"
git push -u origin master
