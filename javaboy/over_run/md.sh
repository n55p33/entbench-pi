#!/bin/bash

dir=`dirname "$0"`

export JAVABOY_ROM=`realpath ./medium.gb`
export ENT_BATTERY_LEVEL=0.70

echo $JAVABOY_ROM

rm run_md_mc_java_stamp.txt
touch run_md_mc_java_stamp.txt

for i in `seq 0 11`; do
	startstamp=`date +"%s"`

	ent -cp ${dir}/../build/classes JavaBoy >/dev/null &

	sleep 125
	
	stopstamp=`date +"%s"`
	killall java

	echo "ERun ${i} ${startstamp} ${stopstamp}" >> run_md_mc_java_stamp.txt

	sleep 30
done
