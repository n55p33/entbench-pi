#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

ent -cp $dir/../build/classes video.Main 720 480
mv mode.txt run_sd_${1}_stamp.txt
