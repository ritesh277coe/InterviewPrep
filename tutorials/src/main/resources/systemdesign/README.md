###System design interview
###Requirement clarifications:
    1.Users/Customers:          Who will use the system and how system is used

    2.Scale (Read/write load):  Incoming data rate (write speed)/Outgoing data (read speed)
                                Spike limits to expect during incoming requests
                                Average incoming/outgoing payload  

    3.Performace:               What is the expected write to read data delay
                                Expected Read latency 

    4.Cost:                     Should we design to reduce development cost or maintenace cost
    
####Above clarification helps to decide FUNCTIONAL and NON FUNCTIONAL aspect of system
    Functional: How system behaves ..like api design
    Non functional: How system is expected to perform: 
                        performance, scalability, Availability

                    How to treat Consistency in case of n/w partioning

                    Cost Analysis

### Design very simple working design components needs to implement service.
    
### Then think about the data model:
    Saving each every event:
        pros:
                Fast writes
                slice/dice is possible
                Recalculation is possible if need
        cons:
                slow reads as service needs to compute aggregate /calculate results
                Need lot of space, so may cost

    Aggregate data over a perios and then saving it:
        pros:
            Fast Reads
            Less data needs to saved
        cons:
            Delayed writes as aggregates needs to wait to do aggregates
            May need service for aggregate results
            Very hard coupled, so data has very specific use.
            Cant recalculate in case of errors

### Think about delay with incoming data and when user needs to read it:
    If delay is in mins: Needs Streaming service
    If delay is in hours/days: Batch processing

### What type of data store: Depends upon
    Scale the read load
    Sclae the write load
    Read/write performance
    How to guarantee strong Consistency / what are tradeoffs
    Data recovery in case of crash
    Data security
    How future change in schema will be handled
    Where to run
    How much cost

###Relational DBs Mysql: Should Address SAP [Scalability Availability Performance]
                                        Configuration Service
                                            |
    processing service -----------------____|____________--------------shard_proxy_Service--Mysql [A-M]-------shard_proxy_Service--Replicated_Mysql
                                        |  Query        |
                                        |Processing     |
                                        |Proxy          |
    Read Service   ---------------------|_______________|-------------shard_proxy_service------Mysql [N-Z] ---shard_proxy_Service--Replicated_Mysql
    
    Processing service: Generate write load
    Read Service: Generate read load
    Query Service: Processing and read service should talk to Query service for executing the query. Query Processing is the one responsible to interact with Mysqls.
    Configuration Service: Is responsible for health check and update the active Ips of mysqls shards in case of new shard or in case of failure
    Shard_proxy_Service: Is for every mysql which help in caching results of query, decides if query will access the master or replicated server


###Non Relational DBs :
    In Short,   Discuss gossip protocol in which each node knows about few neighbours[max 3]
                Discuss consistent hashing
                Discuss quoram read/write
    The above design eliminates need for all the proxy service needed by Mysql design

###Data models
    In relational, model has to be normalized
    In No Sql Db, Model can be denomalized and should be designed with query into consideration

###Processing service design: 
    Should scale
    Should have high throughput
    Should not loose any data in case of crash
    Should handle slow/intermitent db connection
    In short, service has to scale, reliable, and fast
            scale = partition
            reliable = replication/checkpoint
            fast = caching
