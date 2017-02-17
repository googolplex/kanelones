#!/bin/bash
# hecho para mi pc de escritorio
# el 2017/01
# cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace.dist/kanelonesv3.dist/*.war  /home/xoldfusion/Descargas/kanelones2017/amazon2017llave/
# cp -r /home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace/kanelonesv3  kanelones
# cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/*.xml kanelones/tomcatfeliz
cp *.sh kanelones/gitfeliz
# cp -r openshiftfeliz kanelones/
# cp -r jasperfeliz kanelones/
# cp  amazon2017llave/*.sh kanelones/amazon2017llave
# cp  amazon2017llave/*.war kanelones/amazon2017llave ### no llevo el war porque no es necesario
rm *.*~
rm kanelones/*.*~
cd kanelones
git add -A
git commit -a -m "comenzando el projecto"
git push -u origin master
