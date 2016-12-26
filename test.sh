#!/bin/bash

ROOT=$(cd $(dirname $0) && pwd)

find . -type f -name "*.sh" | xargs chmod +x
find ./test/ai -type f | xargs chmod +x
./build.sh

cd $ROOT && npm install && cd -
mocha $(ls test/test*.js) -t 5300 -R tap
