#!/usr/bin/env bash

echo "enter your mysql root password (probably 'password')"
stmt=$(cat $(dirname "$0")/create_databases.sql)
mysql -uroot -p$1 -e "${stmt}"