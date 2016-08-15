#!/bin/bash

dir=`dirname "$0"`

benchmarks=(
	video
	camera
)

for bch in ${benchmarks[@]}; do
	cd ./${bch}/baware_run
	./all.sh
	cd ../..
done
