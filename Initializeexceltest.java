String fileloc = ;

System.setProperty("ROW", "5");//Table start row
System.setProperty("COLUMN", "3");//Table start column
Fillo fillo=new Fillo();
Connection connection=fillo.getConnection(fileloc);
