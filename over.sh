#!/bin/bash

dir=`dirname "$0"`

benchmarks=(
	camera
	javaboy
)

for bch in ${benchmarks[@]}; do
	cd ./${bch}/over_run
	./md.sh java
	cd ../..
done
