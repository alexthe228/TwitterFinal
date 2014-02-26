package com.lib;



import java.util.ArrayList;
import java.util.List;







import com.datastax.driver.core.*;

public final class Keyspaces {



public Keyspaces(){

}

public static void SetUpKeySpaces(Cluster c){
try{
//Add some keyspaces here
String createkeyspace="create keyspace if not exists keyspace2 WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
String CreateTweetTable = "CREATE TABLE if not exists Tweets ("+
"user varchar,"+
" interaction_time timeuuid,"+
" tweet varchar,"+
" PRIMARY KEY (interaction_time)"+
");";

String CreateUsersTable = "CREATE TABLE if not exists Users ("+
"user varchar,"+
" password varchar,"+
" email varchar,"+
" PRIMARY KEY (user)"+ ");";

String CreateFriendsTable = "CREATE TABLE if not exists Friends ("+
"user1 varchar,"+
"user2 varchar,"+
" PRIMARY KEY (user1)"+ ");";


Session session = c.connect();
try{
PreparedStatement statement = session
.prepare(createkeyspace);
BoundStatement boundStatement = new BoundStatement(
statement);
ResultSet rs = session
.execute(boundStatement);

}catch(Exception et){
System.out.println("Can't create keyspace2 "+et);
}

//now add some column families
session.close();
session = c.connect("keyspace2");

try{
SimpleStatement cqlQuery = new SimpleStatement(CreateTweetTable);
session.execute(cqlQuery);
}catch(Exception et){
System.out.println("Can't create tweet table "+et);
}

try{
SimpleStatement cqlQuery = new SimpleStatement(CreateFriendsTable);
session.execute(cqlQuery);
}catch(Exception et){
System.out.println("Can't create tweet table "+et);
}

try{
SimpleStatement cqlQuery = new SimpleStatement(CreateUsersTable);
session.execute(cqlQuery);
}catch(Exception et){
System.out.println("Can't create tweet table "+et);
}
session.close();

}catch(Exception et){
System.out.println("Other keyspace or coulm definition error" +et);
}

}
}