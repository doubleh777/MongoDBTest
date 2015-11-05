package mongodbtest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoJDBCTest {
	public static void main(String[] args) {
		
		Mongo conn;
		try{
			/* DB 접속 */
			conn = new Mongo("127.0.0.1", 27017);
			DB db = conn.getDB("Novelizer");
			DBCollection collection = db.getCollection("scene");
			
			/* 데이터 삽입 */
			BasicDBObject document = new BasicDBObject();
			document.append("sceneID", 1);
			document.append("nextSceneID", 2);
			document.append("backgroundImagePath", "Image/prettyBackgroundImage");
			collection.insert(document);
			
			/* 데이터 조회 */
			DBCursor cursor = collection.find();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
       

		}catch(Exception e){
			/* 예외 처리 */
			e.printStackTrace();
		}
	}
}
