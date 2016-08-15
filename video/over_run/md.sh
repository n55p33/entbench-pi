#!/bin/sh

dir=`dirname "$0"`

export PANDA_RUNS=11
export ENT_BATTERY_LEVEL=0.70

ent -cp $dir/../build/classes video.Main 1280 720
mv mode.txt run_md_mc_java_stamp.txt
