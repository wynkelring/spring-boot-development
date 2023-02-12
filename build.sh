#!/bin/bash
docker build project-parent -t project-parent:latest
docker build common-lib -t common-lib:latest
docker build development-features -t development-features:latest
