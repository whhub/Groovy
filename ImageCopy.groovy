      def srcStream = new File('D:/1.png').newDataInputStream()
      def dstStream = new File('D:/2.png').newDataOutputStream()
      dstStream << srcStream
      dstStream.flush()
      srcStream.close()
      dstStream.close()

      // new File(1.txt) << new File(2.txt).text