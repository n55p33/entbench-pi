#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 2 ]; then
  echo "sd usage: [ESTIMATED_LEVEL] [RUNS]"
  exit
fi

export JAVABOY_ROM=`realpath ./small.gb`

echo $JAVABOY_ROM
echo ${PANDA_RUNS}

rm run_sd_${1}_stamp.txt
touch run_sd_${1}_stamp.txt

for i in `seq 0 ${2}`; do
	startstamp=`date +"%s"`

	ent -cp ${dir}/../build/classes JavaBoy >/dev/null &

	sleep 125
	
	stopstamp=`date +"%s"`
	killall java

	echo "ERun ${i} ${startstamp} ${stopstamp}" >> run_sd_${1}_stamp.txt

	sleep 30
done


