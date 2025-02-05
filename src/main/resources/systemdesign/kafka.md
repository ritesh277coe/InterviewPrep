https://developer.confluent.io/courses/architecture/guarantees/
https://learn.conduktor.io/kafka/kafka-advanced-concepts/

### Durability Guarantee

producer acks = 0 ,1 (written to leader) ALL(written to all )
min.insync.replicas = The topic level configuration tells the broker to not allow an event to be written to a
 topic unless there are N replicas in the ISR.

## Bestcase
`
Replication = 3, ack = all and min.insync.replicas = 2.....Will guarantee best case scenario with durability + latency
because ack has to be received from one of the replica other than leader to send ack bck to producer.
In case of leader failure, other node with latest data will take over.
`

The whole system will not work if 2 brokers are down and will raise exception NotEnoughReplicasException.

`Ordering guarantee`:
`enable.idempotence=true`

Producer is assigned an `PID` by broker. Producer attach PID on each message. In case of producer resending same messages, broker
checks that PID message(hash) in hashmap and rejects duplicate message. This avoids duplicate and message reordering.

But disadvantage of above is that PID is assigned by broker and if producer crashes, broker assigns new PID to producer
and duplicates cant be matched then as new messages will use new PID

Transaction in kafka == multiple writes to multiple topic ATOMICALLY. Either all will happen or entire writes are rolledback.
In this unique transaction id is job of user application.
All the messages written to broker has transaction state in meta data. If transaction state is not committed on messages, then its the onus of consumer to filer them while consuming.
Though consumer libs will do that, but consumer cant expect atomically increasing offsets.

Transaction use transaction coordinator which has hashmap of TID: all topic:partitions involved in transaction.
