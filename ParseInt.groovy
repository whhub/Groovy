def timeP = 0
try {
    final timeString = "16:22:30"
    timeP = Integer.parseInt(timeString)
} catch(Throwable e) {

}
def time = timeP * 60 * 1000
println timeP

