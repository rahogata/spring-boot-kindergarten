# spring-boot-kindergarten
A playground project for using spring boot for web or console java applications.

## Load test

```shell
jmeter -n -t vthread.jmx -l vthread.report -e -o vthread-reports
```

### Start app

```shell
java -XX:+FlightRecorder -XX:StartFlightRecording=duration=100s,filename=vthread.jfr,dumponexit=true,settings=vthread.jfc -jar -Dspring.threads.virtual.enabled=true spring-boot-kindergarten.jar
```