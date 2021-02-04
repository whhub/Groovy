        File file = new File("FileAttribute.groovy");
        Long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        System.out.println(date);
        println new Date().minus(date)