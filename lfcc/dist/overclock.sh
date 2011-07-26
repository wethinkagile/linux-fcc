#!/bin/bash
DISPLAY=:0 aticonfig --od-enable --adapter=all
DISPLAY=:0 aticonfig --od-setclocks=$2,$3 --adapter=$1


