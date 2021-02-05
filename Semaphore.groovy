
def lock = new Object()

def runnable = {
    println 'hi b @' + new Date()
    sleep(3000)
    synchronized (lock) {
        lock.notify()
    }
    println 'hi b again @' + new Date()
}

def thread = new Thread(runnable);
thread.start()

println 'hi a @' + new Date()
synchronized (lock) {
    lock.wait()
}
println 'hi a again @' + new Date()
