#!/bin/bash

dir=`dirname "$0"`

benchmarks=(
	video
	camera
)

for bch in ${benchmarks[@]}; do
	cd ./${bch}/badapt_run
	./all.sh
	cd ../..
done
