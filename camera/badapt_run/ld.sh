#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

ent -cp $dir/../build/classes camera.Main 1920 1080
mv mode.txt run_ld_${1}_stamp.txt
