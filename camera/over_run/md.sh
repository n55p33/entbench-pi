#!/bin/sh

dir=`dirname "$0"`

export PANDA_RUNS=11
export ENT_BATTERY_EVEL=0.70

ent -cp $dir/../build/classes camera.Main 1280 720 > /dev/null
mv mode.txt run_md_mc_java_stamp.txt
