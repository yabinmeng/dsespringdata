```
CREATE KEYSPACE testks WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE testks.person (
    id text PRIMARY KEY,
    age int,
    name text
)


cqlsh:testks> select * from person ;

 id                                   | age | name
--------------------------------------+-----+---------
 e56c5bfb-e507-4da0-9459-95a9c14f0d00 |  40 | Jon Doe
 ```
 

 ```
[main] INFO com.datastax.driver.core - DataStax Java Driver 1.7.0 for DataStax Enterprise (DSE) and Apache Cassandra®
[main] INFO com.datastax.driver.core.GuavaCompatibility - Detected Guava >= 19 in the classpath, using modern compatibility layer
[main] INFO com.datastax.driver.core.ClockFactory - Using native clock to generate timestamps.
[main] INFO com.datastax.driver.core.utils.UUIDs - PID obtained through native call to getpid(): 11500
[main] INFO com.datastax.driver.core.NettyUtil - Did not find Netty's native epoll transport in the classpath, defaulting to NIO.
[main] INFO com.datastax.driver.core.Cluster - Cannot connect with protocol version DSE_V2, trying with DSE_V1
[main] INFO com.datastax.driver.core.policies.DCAwareRoundRobinPolicy - Using data-center name 'DC1' for DCAwareRoundRobinPolicy (if this is incorrect, please provide the correct datacenter name with DCAwareRoundRobinPolicy constructor)
[main] INFO com.datastax.driver.core.Cluster - New Cassandra host /35.239.224.37:9042 added
{ @type = com.ymeng.Person, id = e56c5bfb-e507-4da0-9459-95a9c14f0d00, name = Jon Doe, age = 40 }
[main] INFO com.ymeng.MyDseSpringTest - e56c5bfb-e507-4da0-9459-95a9c14f0d00
```
