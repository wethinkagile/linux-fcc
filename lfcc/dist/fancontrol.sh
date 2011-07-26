#!/bin/bash
export DISPLAY=:0.$1; aticonfig --pplib-cmd "set fanspeed 0 $2"
export DISPLAY=:0
