//import groovy.json.StreamingJsonBuilder
//import groovy.xml.XmlSlurper
import javax.json.*

//xml_json(xml1.xml)
//
//def xml_json(xml){
//
//}

String json = Json.createObjectBuilder()
        .add("key1", "value1")
        .add("key2", "value2")
        .build()
        .toString();

println json

//StringWriter writer = new StringWriter()
//StreamingJsonBuilder builder = new StreamingJsonBuilder(writer)
//builder.records {
//   car {
//       name 'HSV Maloo'
//       make 'Holden'
//       year 2006
//       country 'Australia'
//       record {
//           type 'speed'
//           description 'production pickup truck with speed of 271kph'
//       }
//   }
//}
//String json = JsonOutput.prettyPrint(writer.toString())
//
//println json

//def text = '''
//    <list>
//        <technology>
//            <name>Groovy</name>
//        </technology>
//    </list>
//'''
//
//def list = new XmlSlurper().parseText(text)
//
//assert list instanceof groovy.xml.slurpersupport.GPathResult
//assert list.technology.name == 'Groovy'