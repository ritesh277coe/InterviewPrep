https://www.youtube.com/watch?v=nIGuFK2qNe8&ab_channel=BinodSumanAcademy
https://www.youtube.com/watch?v=_8fHV5woDtQ&t=1558s&ab_channel=TomWells
https://www.youtube.com/watch?v=ZU1r7uEAO7o&t=481s&ab_channel=Ververica (4 video series ..very important)

### Flink kafka source does not use consumer groups

### Watermarking make sure no reorder.

### Checkpoint barrier + TwoPhaseCommitSinkFunction ensure exactly once semantics
    https://flink.apache.org/2018/02/28/an-overview-of-end-to-end-exactly-once-processing-in-apache-flink-with-apache-kafka-too/

    Let’s discuss how to extend a TwoPhaseCommitSinkFunction on a simple file-based example. 
    We need to implement only four methods and present their implementations for an exactly-once file sink:

    beginTransaction -  to begin the transaction, we create a temporary file in a temporary directory on our 
                    destination file system. Subsequently, we can write data to this file as we process it.
    preCommit        -  on pre-commit, we flush the file, close it, and never write to it again. 
                    We’ll also start a new transaction for any subsequent writes that belong 
                    to the next checkpoint.
    commit           -  on commit, we atomically move the pre-committed file to the actual destination directory.
                    Please note that this increases the latency in the visibility of the output data.
    abort            -  on abort, we delete the temporary file.


