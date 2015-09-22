#!/bin/sh

DIRNAME=`dirname "$0"`
cd "${DIRNAME}"
DIRNAME="${PWD}"
cd "${OLDPWD}"
PROGNAME=`basename "$0"`

export OPENHAB_HOME="${DIRNAME}"

export KARAF_HOME="${OPENHAB_HOME}/runtime/karaf-home"
export KARAF_DATA="${OPENHAB_HOME}/userdata/karaf-data"
export KARAF_BASE="${OPENHAB_HOME}/userdata/karaf-base"
export KARAF_ETC="${OPENHAB_HOME}/runtime/karaf-etc"

exec "${KARAF_HOME}"/bin/karaf
