#!/bin/bash
/usr/local/glassfish4/glassfish/bin/asadmin deploy --port 4848 --user admin --host 127.0.0.1  --passwordfile gfpw  --force=true --upload=false ../target/ws-ear.ear