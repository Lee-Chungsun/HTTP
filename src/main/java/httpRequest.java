String url = "url 주소";
//호출할 url 주소 http://IP/~~.do or ~~.jsp 

URL url = new URL( url );
HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			 
conn.setDoOutput(true);
conn.setRequestProperty("Content-Type", "application/json"); 
// json형태로 전송(파라미터)
conn.setRequestProperty("Accept", "application/xml");
// 호출후 reponse는 xml 형태로 받음
conn.setRequestMethod("POST");
// 요청 방식은 post 방식
conn.setConnectTimeout(5000);
// 연결 제한?시간은 (5000)
conn.connect();
//연결

// write
OutputStream os = conn.getOutputStream();
String stringParam = new GsonBuilder().create().toJson( param, Map.class );
// param이 map 타입인데 json으로 바꿔줌 gson 라이브러리 추가해야함.
// com.google.gson.GsonBuilder.GsonBuilder()
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( os, "UTF-8") );
bw.write( stringParam ); // json으로 만든 parameter를 넘긴당
bw.flush();
bw.close();
os.close();

// reader
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
StringBuffer sb = new StringBuffer();
String jsonData = "";

while ((jsonData = br.readLine()) != null) {
	sb.append(jsonData);
}
