Debug the code CallableThread using Executor framework
Look at ThreadPoolExecutor and especially function runWorker. The number of threads will depend upon configuration
For ex: Executors.newFixedThreadPool(3); will spawn 3 threads

Each worker Thread will be in infinite loop:
run() {
    while (get_Task() != null) {
        task.run() or task.call;
    }
}

And get_Task() will pop work from the blocking task queue