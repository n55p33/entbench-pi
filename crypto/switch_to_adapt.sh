#!/bin/bash

rm -rf ./src
cp -rf ./badapt src

ant clean; ant
