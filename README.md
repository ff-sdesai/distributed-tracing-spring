# spring-cloud-sleuth-otel-slf4j

##Run the Example

cd /home/sdesai/Uplight/code/open-telemetry/spring-cloud-sleuth-otel-slf4j
mvn clean install
sudo docker build -f DockerFile -t spring-cloud-sleuth-otel-slf4j .
sudo docker compose up
Once application is up, hit http://localhost:8181/?testCount=1 from web browser to generate traces and logs


## view the signals
View the `trace signal` in Datadog:
[Datadog APM Traces](https://app.datadoghq.com/apm/traces?query=%40_top_level%3A1%20service%3Aspring-cloud-sleuth-otel-slf4j&cols=core_service%2Ccore_resource_name%2Clog_duration%2Clog_http.method%2Clog_http.status_code&env=none&historicalData=false&messageDisplay=inline&sort=desc&spanType=all&spanViewType=metadata&start=1669976026075&end=1669976926075&paused=false)
