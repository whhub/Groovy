def url = "https://eicwp5.med.agfa.be/workflow"
println url[(url.indexOf("eicwp"))..(url.indexOf("/workflow")-1)]

chromeVersion = '91.0.4430.24'
println chromeVersion[0..1] == '91'