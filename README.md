# SocketProxy
Simple socket proxy to test low bandwidth TCP connections

# Usage
java -cp SocketProxy.jar jw.SocketProxy -t $TargetHost/$TargetIP:$TargetPort -lp $LocalPort -in 20Kbps -out 30Kpbs

# Example

`java -cp SocketProxy.jar jw.SocketProxy -t 192.168.1.5:12001 -sp 8888 -in 20Kbps -out 30Kbps`

# JDK requirement
Developed with Java 8.
